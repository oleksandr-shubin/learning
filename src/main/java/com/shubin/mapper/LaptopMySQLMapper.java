package com.shubin.mapper;

import com.shubin.hydrator.Hydrator;
import com.shubin.model.computer.Laptop;
import com.shubin.model.computer.LaptopConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LaptopMySQLMapper implements Mapper<Laptop> {
    private Connection connection;
    private Hydrator<Laptop> hydrator;

    public LaptopMySQLMapper(Connection connection, Hydrator<Laptop> hydrator) {
        this.connection = connection;
        this.hydrator = hydrator;
    }

    public List<Laptop> findByConfiguration(LaptopConfiguration configuration) throws SQLException {
        String sql = "SELECT computer_id, manufacturer, model, price, amount," +
                " keyboard, touchpad, random_access_memory," +
                " video_card, battery, configuration" +
                " FROM laptop LEFT JOIN computer USING(computer_ID)" +
                " WHERE configuration = ?";
        PreparedStatement selectStatement = connection.prepareStatement(sql);
        selectStatement.setString(1, configuration.name());
        ResultSet rs = selectStatement.executeQuery();
        return hydrator.hydrateList(rs);
    }
}
