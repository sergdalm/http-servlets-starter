package com.sergdalm.http.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Flight {
    private Long id;
    private String flight_no;
    private LocalDateTime departure_date;
    private String departure_airport_code;
    private LocalDateTime arrival_data;
    private String arrival_airport_code;
    private Integer aircraft_id;
    private FlightStatus status;

    public Flight(Long id, String flight_no, LocalDateTime departure_date, String departure_airport_code, LocalDateTime arrival_data, String arrival_airport_code, Integer aircraft_id, FlightStatus status) {
        this.id = id;
        this.flight_no = flight_no;
        this.departure_date = departure_date;
        this.departure_airport_code = departure_airport_code;
        this.arrival_data = arrival_data;
        this.arrival_airport_code = arrival_airport_code;
        this.aircraft_id = aircraft_id;
        this.status = status;
    }
}
