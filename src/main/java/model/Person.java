package model;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private String gender;
    private Subdivision subdivision;
    private double salary;
    private LocalDate birthDate;

    public Person(int id, String name, String gender, Subdivision subdivision, double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.subdivision = subdivision;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return name + " (" + gender + "), " + salary + ", родился " + birthDate + ", подразделение: " + subdivision.getName();
    }
}
