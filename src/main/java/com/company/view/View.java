package com.company.view;

import com.company.controller.*;
import com.company.model.Cleaner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View() {
        controller = new ControllerImpl();
        menu = new LinkedHashMap<>();
        menu.put("1", " 1 - Print Shop products");
        menu.put("2", " 2 - Select cleaners");
        menu.put("3", " 3 - Go to the new Shop");
        menu.put("Q", " Q - Exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::PressButton1);
        methodsMenu.put("2", this::PressButton2);
        methodsMenu.put("3", this::PressButton3);
    }

    private void PressButton1() {
        System.out.format("%-20s %-20s %-20s %-20s\n", "Type", "Name", "Producer", "Price");
        List<Cleaner> lst = controller.getShopProducts();
        for (Object cleaner : lst) {
            System.out.println(cleaner);
        }
    }

    private void PressButton2() {
        System.out.println("input type ( '1' - Dishes, '2' - Floor, '3' - Furniture ): ");
        int type = Integer.parseInt(input.nextLine());
        System.out.format("%-20s %-20s %-20s %-20s\n", "Type", "Name", "Producer", "Price");
        try {
            List<Cleaner> lst = controller.sortSelectedCleaners(type);
            for (Object cleaner : lst) {
                System.out.println(cleaner);
            }
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }

    private void PressButton3() {
        controller.goToTheNewShop();
    }

    private void outputMenu() {
        System.out.println("\nMenu:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.err.println("Invalid input");
            }
        } while (!keyMenu.equals("Q"));
    }

}
