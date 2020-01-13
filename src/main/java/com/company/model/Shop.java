package com.company.model;

import java.util.*;

public class Shop {
    private List<Cleaner> cleaners;

    public Shop() {
        geerateCleaners();
    }

    public List<Cleaner> getCleaners() {
        return cleaners;
    }

    private void geerateCleaners() {
        cleaners = new ArrayList<>();
        Random random = new Random();
        int size = random.nextInt(5) + 5;
        for (int i = 0; i < size; i++) {
            int type = random.nextInt(3);
            switch (type) {
                case 0:
                    cleaners.add(new DishesCleaner());
                    break;
                case 1:
                    cleaners.add(new FloorCleaner());
                    break;
                case 2:
                    cleaners.add(new FurnitureCleaner());
                    break;
            }
        }
    }

    public List selectCleaners(int type) {
        switch (type) {
            case 1:
                return filterClenersoOfType("DishesCleaner");
            case 2:
                return filterClenersoOfType("FloorCleaner");
            case 3:
                return filterClenersoOfType("FurnitureCleaner");
            default:
                return cleaners;
        }

    }

    private List filterClenersoOfType(String type) {
        List<Cleaner> lst = new LinkedList<>();
        for (Cleaner cleaner : cleaners) {
            if (cleaner.getClass().getSimpleName().equals(type)) {
                lst.add(cleaner);
            }
        }
        return lst;
    }
}

