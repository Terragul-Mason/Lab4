package model;

import java.time.LocalDate;

/**
 * Класс, представляющий сотрудника организации.
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Subdivision subdivision;
    private double salary;
    private LocalDate birthDate;

    /**
     * Конструктор создания сотрудника.
     *
     * @param id Уникальный ID, присваиваемый программно
     * @param name Имя сотрудника
     * @param gender Пол сотрудника
     * @param subdivision Подразделение, в котором работает сотрудник
     * @param salary Зарплата сотрудника
     * @param birthDate Дата рождения сотрудника
     */
    public Person(int id, String name, String gender, Subdivision subdivision, double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.subdivision = subdivision;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает ID сотрудника.
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает имя сотрудника.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает пол сотрудника.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Возвращает подразделение сотрудника.
     */
    public Subdivision getSubdivision() {
        return subdivision;
    }

    /**
     * Возвращает зарплату сотрудника.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Возвращает дату рождения сотрудника.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает строковое представление сотрудника.
     */
    @Override
    public String toString() {
        return name + " (" + gender + "), " + salary + ", родился " + birthDate + ", подразделение: " + subdivision.getName();
    }
}
