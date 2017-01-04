package com.shubin.hydrator;

import com.shubin.model.computer.Laptop;
import com.shubin.model.computer.LaptopConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaptopHydrator implements Hydrator<Laptop> {
    private Connection connection;

    public LaptopHydrator(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Laptop> hydrateList(ResultSet rs) throws SQLException {
        List<Laptop> laptops = new ArrayList<>();
        while (rs.next()) {
            Laptop laptop = new Laptop();
            laptop.setComputerId(rs.getInt("computer_id"));
            laptop.setManufacturer(rs.getString("manufacturer"));
            laptop.setModel(rs.getString("model"));
            laptop.setPrice(rs.getInt("price"));
            laptop.setAmount(rs.getInt("amount"));
            laptop.setKeyboard(rs.getString("keyboard"));
            laptop.setTouchpad(rs.getString("touchpad"));
            laptop.setRandomAccessMemory(rs.getString("random_access_memory"));
            laptop.setVideoCard(rs.getString("video_card"));
            laptop.setBattery(rs.getString("battery"));
            laptop.setConfiguration(LaptopConfiguration.valueOf(rs.getString("configuration")));

            laptops.add(laptop);
        }
        return laptops;
    }

    /**
     * FIXME
     * @param rs ResultSet from sql SELECT
     * @return
     */
    @Override
    public Laptop hydrate(ResultSet rs) {
        return null;
    }
}
