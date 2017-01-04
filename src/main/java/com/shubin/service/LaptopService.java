package com.shubin.service;

import com.shubin.mapper.LaptopMySQLMapper;
import com.shubin.model.computer.Laptop;
import com.shubin.mapper.Mapper;
import com.shubin.model.computer.LaptopConfiguration;

import java.sql.SQLException;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class LaptopService {
    private LaptopMySQLMapper mapper;

    public LaptopService(LaptopMySQLMapper mapper) {
        this.mapper = mapper;
    }

    public List<Laptop> findByConfiguration(LaptopConfiguration configuration) throws IllegalStateException {
        try {
            return mapper.findByConfiguration(configuration);
        } catch (SQLException e) {
            throw new IllegalStateException("Wrong response from mapper", e);
        }
    }
}
