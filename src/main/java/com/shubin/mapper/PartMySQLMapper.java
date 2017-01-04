package com.shubin.mapper;

import com.shubin.hydrator.Hydrator;
import com.shubin.model.computer.parts.Part;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PartMySQLMapper implements Mapper<Part> {
    private Connection connection;
    private Hydrator<Part> hydrator;

    public PartMySQLMapper(Connection connection, Hydrator<Part> hydrator) {
        this.connection = connection;
        this.hydrator = hydrator;
    }

    public List<Part> findAllAvailable() throws SQLException {
        String sql = "SELECT part_id, type, info, amount, price FROM part WHERE amount > 0";
        PreparedStatement selectStatement = connection.prepareStatement(sql);
        ResultSet rs = selectStatement.executeQuery();
        return hydrator.hydrateList(rs);
    }
}
