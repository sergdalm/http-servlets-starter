package com.sergdalm.http.filter;

import com.sergdalm.http.dto.UserDto;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static com.sergdalm.http.util.UrlPath.IMAGES;
import static com.sergdalm.http.util.UrlPath.LOGIN;
import static com.sergdalm.http.util.UrlPath.REGISTRATION;

// Это обязательно должен быть интерфейс из класса jakarta.servlet

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION, IMAGES);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPublicPath(uri) || isUserLoggedIn(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // В английском слово referer пишется с двумя r, но не стали уже исправлять и так и оставили
            // Это страница говорит о том, откуда пришел пользователь на эту страницу
            // Но referer нам не поможет если пользователь будет самостоятельно что-то менять на стороне клиента,
            // менять куки - в таком случае мы можем зайти в вечный цикл перенаправлений.
            // Однако есть лимиты по перенаправлениям - у пользователя будет ошибка, что перенаправлений слишком много.
            // Либо можно просто всегда перенаправлять пользователя на логин страницу.
            String previousPage = ((HttpServletRequest) servletRequest).getHeader("referer");

            // Также часто используются следующие статус коды,
            // если пользователь не прошел::
            // аутентификацию (401 - Unauthorized)
            // авторизацию (403 - Forbidden).
            // Если пользователь зашел сюда с другой страницы сайта - мы направляем его обратно,
            // а если он сам ввел название страницы в адресной строке - на страницу логина
            ((HttpServletResponse) servletResponse).sendRedirect(
                    previousPage != null ? previousPage : LOGIN);
        }
    }

    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream()
                .anyMatch(uri::startsWith);
    }
}
