package com.shubin.service;

import com.shubin.mapper.ComputerStoreMySQLMapper;
import com.shubin.model.computer.Laptop;
import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;
import com.shubin.model.store.Transaction;

import java.sql.SQLException;
import java.util.Map;

public class ComputerStoreService {
    private ComputerStoreMySQLMapper mapper;

    public ComputerStoreService(ComputerStoreMySQLMapper mapper) {
        this.mapper = mapper;
    }

    public void buyLaptop(Transaction transaction) throws IllegalStateException {
        try {
            mapper.buyLaptop(transaction);
        } catch (SQLException e) {
            throw new IllegalStateException("Wrong response from mapper", e);
        }
    }

    public void buyCustomLaptop(Laptop laptop, int userId, Map<PartType, Part> parts) throws IllegalStateException {
        try {
            mapper.buyCustomLaptop(laptop, userId, parts);
        } catch (SQLException e) {
            throw new IllegalStateException ("Wrong repsonse from mapper", e);
        }
    }
}
