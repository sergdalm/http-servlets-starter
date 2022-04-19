package com.sergdalm.http.servlet;

import com.sergdalm.http.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Long flightId = Long.valueOf(req.getParameter("flightId"));

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h1> Купленные билеты</h1>") ;
            printWriter.write("<ul>");
            ticketService.findByFlightId(flightId).forEach(
                    ticketDto -> printWriter.write("""
                            <li>
                                %s
                            </li>
                            """.formatted(ticketDto.getSeatNo()))
            );
            printWriter.write("</ul>");
        }
    }
}
