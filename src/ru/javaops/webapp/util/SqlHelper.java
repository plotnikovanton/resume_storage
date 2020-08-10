package ru.javaops.webapp.util;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.sql.ConnectionFactory;
import ru.javaops.webapp.sql.SqlManipulator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public <T> T help(String query, SqlManipulator<T> sqlManipulator) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            return sqlManipulator.manipulate(preparedStatement);
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) throw new ExistStorageException(e.getSQLState());
            throw new StorageException(e);
        }
    }
}
