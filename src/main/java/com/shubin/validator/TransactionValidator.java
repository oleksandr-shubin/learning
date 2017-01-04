package com.shubin.validator;

import java.util.List;
import com.shubin.model.computer.Laptop;

public class TransactionValidator {
    public boolean validLaptopAmount(List<Laptop> laptops,
                                              int requestedId,
                                              int requestedAmount) {

        for (Laptop laptop : laptops) {
            if (laptop.getComputerId() == requestedId && laptop.getAmount() >= requestedAmount) {
                return true;
            }
        }
        return false;
    }
}
