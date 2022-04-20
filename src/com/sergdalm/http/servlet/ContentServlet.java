package com.sergdalm.http.servlet;

import com.sergdalm.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // В методе getRequestDispatcher() надо указать полный путь к файлу JSP начиная от директории web.
        // Лучше вынести полный путь в утилитный класс (JspHelper)
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
