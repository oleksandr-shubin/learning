package com.shubin.mapper;

import com.shubin.controller.ComputerStoreController;
import com.shubin.hydrator.Hydrator;
import com.shubin.model.computer.AbstractComputer;
import com.shubin.model.computer.Laptop;
import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;
import com.shubin.model.store.Transaction;

import java.sql.*;
import java.util.Map;

public class ComputerStoreMySQLMapper implements Mapper<Transaction> {
    private Connection connection;
    private Hydrator<Transaction> hydrator;

    public ComputerStoreMySQLMapper(Connection connection,
                                    Hydrator<Transaction> hydrator) throws SQLException {

        this.connection = connection;
        this.hydrator = hydrator;
    }

    public void buyLaptop(Transaction transaction) throws SQLException {
        try {
            connection.setAutoCommit(false);
            String updateComputerSql = "UPDATE computer SET amount = amount - ? WHERE computer_id = ?";
            PreparedStatement updateTransactonStatement = connection.prepareStatement(updateComputerSql);
            updateTransactonStatement.setInt(1, transaction.getAmount());
            updateTransactonStatement.setInt(2, transaction.getComputerId());

            PreparedStatement insertTransactionStatement = createSaveTransactionStatement(transaction);
            insertTransactionStatement.executeUpdate();
            updateTransactonStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Transaction rolled back", e);
        }
    }

    public void buyCustomLaptop(Laptop customLaptop, int userId, Map<PartType, Part> parts) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // saving laptop
            String insertComputerSql = "INSERT INTO " +
                    "computer(manufacturer, model, price, amount) " +
                    "VALUES(?, ?, ? ,?)";
            String insertLaptopSql = "INSERT INTO " +
                    "laptop(computer_id, keyboard, touchpad, random_access_memory," +
                    "video_card, battery, configuration)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertComputerStatement = connection.prepareStatement(insertComputerSql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertLaptopStatement = connection.prepareStatement(insertLaptopSql);

            insertComputerStatement.setString(1, customLaptop.getManufacturer());
            insertComputerStatement.setString(2, customLaptop.getModel());
            insertComputerStatement.setInt(3,customLaptop.getPrice());
            insertComputerStatement.setInt(4, customLaptop.getAmount());
            insertComputerStatement.executeUpdate();
            ResultSet generatedKeys = insertComputerStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                customLaptop.setComputerId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Unable to retrieve generated key");
            }

            insertLaptopStatement.setInt(1, customLaptop.getComputerId());
            insertLaptopStatement.setString(2, customLaptop.getKeyboard());
            insertLaptopStatement.setString(3, customLaptop.getTouchpad());
            insertLaptopStatement.setString(4, customLaptop.getRandomAccessMemory());
            insertLaptopStatement.setString(5, customLaptop.getVideoCard());
            insertLaptopStatement.setString(6, customLaptop.getBattery());
            insertLaptopStatement.setString(7, customLaptop.getConfiguration().name());
            insertLaptopStatement.executeUpdate();

            //removing amount from parts
            String updatePartSql = "UPDATE part SET amount = amount-1 WHERE part_id = ?";
            PreparedStatement updatePartStatement = connection.prepareStatement(updatePartSql);
            for (Part part : parts.values()) {
                updatePartStatement.setInt(1, part.getPartId());
                updatePartStatement.executeUpdate();
            }

            // saving transaction
            Transaction transaction = new Transaction(
                customLaptop.getComputerId(),
                ComputerStoreController.ANONYMOUS_USER_ID,
                customLaptop.getAmount()
            );
            PreparedStatement insertTransactionStatement = createSaveTransactionStatement(transaction);
            insertTransactionStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Transaction rolled back", e);
        }
    }

    private PreparedStatement createSaveTransactionStatement(Transaction transaction) throws SQLException {
        String insertTransactionSql = "INSERT INTO transaction(computer_id, user_id, amount) " +
                "VALUES(?, ?, ?)";
        PreparedStatement insertTransactionStatement = connection.prepareStatement(insertTransactionSql);
        insertTransactionStatement.setInt(1, transaction.getComputerId());
        insertTransactionStatement.setInt(2, transaction.getUserId());
        insertTransactionStatement.setInt(3, transaction.getAmount());
        return insertTransactionStatement;
    }


}
