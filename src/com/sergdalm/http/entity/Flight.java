package com.sergdalm.http.entity;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public LocalDateTime getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDateTime departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_airport_code() {
        return departure_airport_code;
    }

    public void setDeparture_airport_code(String departure_airport_code) {
        this.departure_airport_code = departure_airport_code;
    }

    public LocalDateTime getArrival_data() {
        return arrival_data;
    }

    public void setArrival_data(LocalDateTime arrival_data) {
        this.arrival_data = arrival_data;
    }

    public String getArrival_airport_code() {
        return arrival_airport_code;
    }

    public void setArrival_airport_code(String arrival_airport_code) {
        this.arrival_airport_code = arrival_airport_code;
    }

    public Integer getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(Integer aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flight_no='" + flight_no + '\'' +
                ", departure_date=" + departure_date +
                ", departure_airport_code='" + departure_airport_code + '\'' +
                ", arrival_data=" + arrival_data +
                ", arrival_airport_code='" + arrival_airport_code + '\'' +
                ", aircraft_id=" + aircraft_id +
                ", status=" + status +
                '}';
    }
}
