package com.shubin.hydrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Hydrator<T> {

    /**
     * Fills list of objects with values from DB
     *
     * @param rs ResultSet from sql SELECT
     * @return List of T filled with values
     */
    List<T> hydrateList(ResultSet rs) throws SQLException;
}
