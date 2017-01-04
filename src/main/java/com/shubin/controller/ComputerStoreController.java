package com.shubin.controller;

import com.shubin.View.View;
import com.shubin.builder.ComputerBuilderDirector;
import com.shubin.model.computer.Laptop;
import com.shubin.model.computer.LaptopConfiguration;
import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;
import com.shubin.model.store.Transaction;
import com.shubin.service.ComputerStoreService;
import com.shubin.service.LaptopService;
import com.shubin.service.PartService;
import com.shubin.validator.PartValidator;
import com.shubin.validator.TransactionValidator;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.*;

public class ComputerStoreController implements Controller {
    public static final int ANONYMOUS_USER_ID = 5;
    private View view;
    private LaptopService laptopService;
    private ComputerStoreService computerStoreService;
    private TransactionValidator transactionValidator;
    private PartValidator partValidator;
    private PartService partService;
    private ComputerBuilderDirector computerBuilderDirector;

    public ComputerStoreController(LaptopService laptopService,
                                   PartService partService,
                                   ComputerStoreService computerStoreService,
                                   TransactionValidator transactionValidator,
                                   PartValidator partValidator,
                                   View view,
                                   ComputerBuilderDirector computerBuilderDirector) {
        this.laptopService = laptopService;
        this.view = view;
        this.computerStoreService = computerStoreService;
        this.transactionValidator = transactionValidator;
        this.partValidator = partValidator;
        this.partService = partService;
        this.computerBuilderDirector = computerBuilderDirector;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter number, which describes a laptop configuration you need");
                System.out.println("1 - Gaming");
                System.out.println("2 - Travel");
                System.out.println("3 - Custom");
                int configurationId = Integer.parseInt(scanner.nextLine());;

                switch (configurationId) {
                    case 1:
                    case 2:
                        LaptopConfiguration configuration;
                        if (configurationId == 1) {
                            configuration = LaptopConfiguration.Gaming;
                        } else {
                            configuration = LaptopConfiguration.Travel;
                        }
                        List<Laptop> laptops =
                                (ArrayList<Laptop>) laptopService.findByConfiguration(configuration);
                        view.show(laptops);
                        System.out.println("Enter computerId of laptop you want to buy");
                        int laptopId = Integer.parseInt(scanner.nextLine());;
                        System.out.println("Enter quantity you want to buy");
                        int laptopAmount = Integer.parseInt(scanner.nextLine());;
                        if (transactionValidator.validLaptopAmount(laptops, laptopId, laptopAmount)) {
                            Transaction transaction = new Transaction(
                                    laptopId,
                                    ANONYMOUS_USER_ID,
                                    laptopAmount);

                            computerStoreService.buyLaptop(transaction);
                            System.out.println("Transaction succeeded");
                            break;
                        } else {
                            System.out.println("Sorry, but you entered wrong amount");
                            break;
                        }
                    case 3:
                        System.out.println("Step by step questions will guide you " +
                                "to choose parts you want to see in your laptop");
                        List<Part> parts =
                                (ArrayList<Part>) partService.findAllAvailableParts();
                        Map<PartType, Part> choosenParts = new HashMap<>();
                        for (PartType partType : PartType.values()) {
                            List<Part> filteredParts = (ArrayList<Part>) partService
                                    .filterPartsByType(parts, partType);
                            System.out.println("Choose " + partType.toString().toLowerCase());
                            view.show(filteredParts);
                            while (true) {
                                System.out.println("Enter partId of " + partType.name() + " you want to buy");
                                int partId = Integer.parseInt(scanner.nextLine());;
                                if (partValidator.validId(filteredParts, partId)) {
                                    Part part = partService.filterPartsById(filteredParts, partId);
                                    choosenParts.put(partType, part);
                                    break;
                                } else {
                                    System.out.println("You entered wrong id, please try again");
                                    continue;
                                }
                            }
                        }

                        System.out.println("Your computer will have following specs:");
                        Laptop customLaptop = (Laptop) computerBuilderDirector.constructComputer(choosenParts);
                        System.out.println(customLaptop);

                        System.out.println("Do you really want to buy it?");
                        System.out.println("Enter \"y\" to buy or any other key to cancel");
                        if (scanner.nextLine().equals("y")) {
                            computerStoreService.buyCustomLaptop(customLaptop, ANONYMOUS_USER_ID, choosenParts);
                            System.out.println("Transaction successfully completed");
                        }
                        break;
                    default:
                        break;
                }
                System.out.println("Enter q to quit or any other key to continue");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.out.println("Application is shutting down...");
                    break;
                }
            }
        }
    }
}
