package com.sergdalm.http.service;

import com.sergdalm.http.dao.TicketDao;
import com.sergdalm.http.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.*;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();
    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public TicketDto findId(Long id) {
         return  null;
    }

    public List<TicketDto> findByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()
                ))
                .collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
