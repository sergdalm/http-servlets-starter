package com.sergdalm.http.servlet;

import com.sergdalm.http.service.ImageService;
import com.sergdalm.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(UrlPath.IMAGES + "/*")
public class ImageServlet extends HttpServlet {
    private final ImageService imageService = ImageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        //requestURI() возвращает только путь, без порта и хоста
        // убираем часть images и пллучаем чистый путь к картинке
        String imagePath = requestURI.replace("images", "");

        imageService.get(imagePath)
                .ifPresentOrElse(image -> {
                    // по-хорошему мы должны определять content-type,
                    // но можно использовать и универсальный тип для всех потоков байт
                    resp.setContentType("application/octet-stream");
                    writeImage(image, resp);
                }, () -> resp.setStatus(404));
    }

    @SneakyThrows
    private void writeImage(InputStream image, HttpServletResponse resp) {
        try (image; ServletOutputStream outputStream = resp.getOutputStream()) {
            // проходимся циклом чтобы не читать все байт сразу не помещая в оперативную память
            int currentByte;
            while ((currentByte = image.read()) != -1) {
                outputStream.write(currentByte);
            }
        }
    }
}
