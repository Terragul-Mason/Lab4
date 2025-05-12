package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Subdivision {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private int id;
    private String name;

    public Subdivision(String name) {
        this.id = idCounter.getAndIncrement();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
