package model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс, представляющий подразделение в организации.
 */
public class Subdivision {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private int id;
    private String name;

    /**
     * Создаёт новое подразделение с автоматической генерацией ID.
     *
     * @param name Название подразделения
     */
    public Subdivision(String name) {
        this.id = idCounter.getAndIncrement();
        this.name = name;
    }

    /**
     * Возвращает уникальный ID подразделения.
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название подразделения.
     */
    public String getName() {
        return name;
    }
}
