package com.sergdalm.http.dao;

import com.sergdalm.http.entity.Ticket;
import com.sergdalm.http.util.ConnectionManager;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket> {
    private static final TicketDao INSTANCE = new TicketDao();

    private static final String FIND_ID = """
            SELECT *
            FROM ticket
            WHERE id = ?
            """;

    private static final String FIND_BY_FLIGHT_ID = """
            SELECT *
            FROM ticket
            WHERE flight_id = ?
            """;

    private TicketDao() {
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public Optional<Ticket> findId(Long id) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ID)) {
            prepareStatement.setLong(1, id);
            var resultSet = prepareStatement.executeQuery();
            return Optional.of(buildTicket(resultSet));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ticket> findAllByFlightId(Long flightId) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_BY_FLIGHT_ID)) {
            List<Ticket> tickets = new ArrayList<>();

            prepareStatement.setObject(1, flightId);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                tickets.add(buildTicket(resultSet));
            }
            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Ticket buildTicket(ResultSet resultSet) {
        try {
            return new Ticket(
                    resultSet.getObject("id", Long.class),
                    resultSet.getObject("passenger_no", String.class),
                    resultSet.getObject("passenger_name", String.class),
                    resultSet.getObject("flight_id", Long.class),
                    resultSet.getObject("seat_no", String.class),
                    resultSet.getObject("cost", BigDecimal.class)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }
}
