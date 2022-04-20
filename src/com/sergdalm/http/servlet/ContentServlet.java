package com.sergdalm.http.servlet;

import com.sergdalm.http.dto.FlightDto;
import com.sergdalm.http.service.FlightService;
import com.sergdalm.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {
    private final FlightService flightService = FlightService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flightDtos = this.flightService.findAll();
        req.setAttribute("flights", flightDtos);
        req.getSession().setAttribute("flightsMap", flightDtos.stream()
                .collect(toMap(FlightDto::getId, FlightDto::getDescription)));

        // В методе getRequestDispatcher() надо указать полный путь к файлу JSP начиная от директории web.
        // Лучше вынести полный путь в утилитный класс (JspHelper)
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
