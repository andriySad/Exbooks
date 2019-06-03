package exbooks.api.repositories.impl;

import exbooks.api.entities.User;
import exbooks.api.repositories.UserRepository;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {

    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/ExBooks";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "023843";

    private static final String INSERT_USER_SQL = "INSERT INTO \"user\" (email, phone, password, first_name, sur_name, is_active) VALUES (?, ?, ?, ?,?,?) RETURNING id";

    public User insert(User user) throws Exception {
        try (Connection dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD)) {
            try (PreparedStatement statement = dbConnection.prepareStatement(INSERT_USER_SQL)) {
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPhone());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getFirstName());
                statement.setString(5, user.getSurname());
                statement.setBoolean(6, user.isActive());

                try (ResultSet generatedKeys = statement.executeQuery()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getLong(1));
                    }
                }
            }
            return user;
        }
    }

}