package com.sergdalm.http.service;

import com.sergdalm.http.dao.FlightDao;
import com.sergdalm.http.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.*;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {
    }

    private final FlightDao flightDao = FlightDao.getInstance();

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> new FlightDto(
                        flight.getId(),
                        """
                            %s - %s - %s
                        """.formatted(flight.getDeparture_airport_code(),
                                    flight.getArrival_airport_code(),
                                flight.getStatus())
                ))
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
