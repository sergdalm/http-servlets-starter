package com.sergdalm.http.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Flight {
    private Long id;
    private String flight_no;
    private LocalDateTime departure_date;
    private String departure_airport_code;
    private LocalDateTime arrival_data;
    private String arrival_airport_code;
    private Integer aircraft_id;
    private FlightStatus status;

}
