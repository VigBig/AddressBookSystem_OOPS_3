package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
    static Scanner scanner = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String zip;
    private String city;
    private String state;
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void editContact(){
        System.out.println("Enter First Name:");
        String firstName = scanner.next();
        setFirstName(firstName);

        System.out.println("Enter Last Name:");
        String lastName = scanner.next();
        setLastName(lastName);

        System.out.println("Enter Email:");
        String email = scanner.next();
        setEmail(email);

        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.next();
        setPhoneNumber(phoneNumber);

        System.out.println("Enter Zip Code:");
        String zip = scanner.next();
        setZip(zip);

        System.out.println("Enter City:");
        String city = scanner.next();
        setCity(city);

        System.out.println("Enter State:");
        String state = scanner.next();
        setState(state);

        System.out.println("Enter Address:");
        String address = scanner.next();
        setAddress(address);

    }



    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}