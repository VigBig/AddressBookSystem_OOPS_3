package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        boolean bookAgain = true;
        Scanner sc = new Scanner(System.in);

        AddressBookMenu addressBookMenu = new AddressBookMenu();

        while(bookAgain){

            if(addressBookMenu.addressBookMenuOptions() <1 || addressBookMenu.addressBookMenuOptions() >7){
                break;
            }

        }

    }
}