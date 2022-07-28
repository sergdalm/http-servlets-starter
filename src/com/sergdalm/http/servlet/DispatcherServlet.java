package com.sergdalm.http.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

//        req.setAttribute("1", "234");
//        req.getRequestDispatcher("/flights")
//                .forward(req, resp);
//
//
//        var writer = resp.getWriter();
//        writer.write("Hello 2");
//        System.out.println();
        resp.sendRedirect("/flights");


//        req.setAttribute("1", "123");
//        requestDispatcher.forward(req, resp);
    }
}
