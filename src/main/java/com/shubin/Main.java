package com.shubin;

import com.shubin.controller.ComputerStoreController;
import com.shubin.locator.ServiceLocator;
import com.shubin.locator.ServiceLocatorImp;
import com.shubin.model.computer.*;
import com.shubin.model.store.Cart;
import com.shubin.model.store.Delivery;
import com.shubin.model.store.Service;
import com.shubin.model.store.Warranty;
import com.shubin.service.LaptopService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // get laptop from db
            ServiceLocator service = new ServiceLocatorImp();
            LaptopService laptopService = (LaptopService) service.getService("LaptopService");
            List<Laptop> gamingLaptops = laptopService.findByConfiguration(LaptopConfiguration.Gaming);
            Laptop firstGamingLaptop = gamingLaptops.get(0);

            // generate order with warranty
            AbstractComputer warrantyLaptop = new Warranty(firstGamingLaptop);

            // generate order with service and delivery
            Computer serviceAndDeliveryLaptop = new Service(new Delivery(firstGamingLaptop));

            // add these orders to cart
            Cart<Computer> laptopCart = new Cart<>();
            laptopCart.add(firstGamingLaptop); // basic
            laptopCart.add(warrantyLaptop);
            laptopCart.add(serviceAndDeliveryLaptop);

            laptopCart.printConfigs();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
