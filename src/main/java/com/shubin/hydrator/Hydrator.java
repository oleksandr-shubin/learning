package com.shubin.hydrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Hydrator<T> {

    /**
     * Fills an empty object with values from DB
     *
     * @param rs ResultSet from sql SELECT
     * @return instance of T filled with values
     */
    T hydrate (ResultSet rs);

    /**
     * Fills list of objects with values from DB
     *
     * @param rs ResultSet from sql SELECT
     * @return List of T filled with values
     */
    List<T> hydrateList(ResultSet rs) throws SQLException;
}
