package com.shubin.hydrator;

import com.shubin.model.store.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransactionHydrator implements Hydrator<Transaction> {
    @Override
    public List<Transaction> hydrateList(ResultSet rs) throws SQLException {
        return null;
    }
}
