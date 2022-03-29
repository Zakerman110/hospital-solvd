package com.solvd.hospital.Classes;

import com.solvd.hospital.Interfaces.IPerson;

import java.util.Date;

public abstract class Person implements IPerson {

    private String firstName;
    private String lastName;
    private String gender;
    private final Date birthDate;
    private String address;
    private String phone;
    private Hospital hospital;

    public Person(String firstName, String lastName, String gender, Date birthDate, String address, String phone,
                  Hospital hospital) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.hospital = hospital;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getDateOfBirth() {
        return null;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getAge() {
        return null;
    }

    @Override
    public String shortInformation() {
        return getFullName() + " is " + getAge() + " years old";
    }

    @Override
    public String detailInformation() {
        return getFullName() + " is " + getAge() + " years old and lives at " + this.address;
    }
}
