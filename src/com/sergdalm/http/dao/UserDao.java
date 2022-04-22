package com.sergdalm.http.dao;

import com.sergdalm.http.entity.User;
import com.sergdalm.http.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements Dao<Integer, User> {
    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users (name, birthday, email, password, role, gender) 
            VALUES  (?, ?, ?, ?, ?, ? )
            """;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findId(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setObject(1, entity.getName());
            prepareStatement.setObject(2, entity.getBirthday());
            prepareStatement.setObject(3, entity.getEmail());
            prepareStatement.setObject(4, entity.getPassword());
            prepareStatement.setObject(5, entity.getRole().name());
            prepareStatement.setObject(6, entity.getGender().name());

            prepareStatement.executeUpdate();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
