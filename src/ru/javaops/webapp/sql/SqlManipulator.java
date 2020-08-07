package ru.javaops.webapp.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlManipulator<T> {
    T manipulate(PreparedStatement preparedStatement) throws SQLException;
}
