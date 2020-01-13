package com.company.model;

import java.util.*;

public abstract class Cleaner implements Comparable<Cleaner> {
    private String name;
    private String producer;
    private int price;
    private static final String[] NAMES = {"Fairy", "Gala", "mr. Propper", "Fancy", "Froster"};
    private static final String[] PRODUCERS = {"China", "Ukraine", "Poland", "Germany"};


    Cleaner() {
        generateCleaner();
    }

    public Cleaner(String name, String producer, int price) {
        this.name = name;
        this.producer = producer;
        this.price = price;
    }

    private void generateCleaner() {
        Random rand = new Random();
        name = NAMES[rand.nextInt(NAMES.length)];
        producer = PRODUCERS[rand.nextInt(PRODUCERS.length)];
        price = rand.nextInt(30) + 20;
    }

    @Override
    public String toString() {
//        return this.getClass().getSimpleName() + ' ' + name + ' ' + producer + ' ' + price;
        return String.format("%-20s %-20s %-20s %-20d",this.getClass().getSimpleName(),name,producer,price);
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(Cleaner o) {
        return Integer.compare(this.price, o.price);
    }
}
