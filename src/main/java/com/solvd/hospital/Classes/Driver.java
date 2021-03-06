package com.solvd.hospital.Classes;

import java.time.LocalDate;

public class Driver extends Employee {

    private String[] categories;
    private Transport transport;

    public Driver(String firstName, String lastName, String gender, LocalDate birthDate, String address, String phone,
                  Hospital hospital, LocalDate joined, String[] education, Department department, String[] categories,
                  Transport transport) {
        super(firstName, lastName, gender, birthDate, address, phone, hospital, joined, education, department);
        this.categories = categories;
        this.transport = transport;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
