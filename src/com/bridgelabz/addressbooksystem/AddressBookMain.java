package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        boolean askToAddContact = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook();

        while (askToAddContact) {
            addressBook.addContact();

            System.out.println("Do you wish to add another contact? (Enter Y to add or any key as No)");
            char c = sc.next().charAt(0);

            if (c == 'y' || c == 'Y') {
                continue;
            } else {
                break;
            }
        }


        System.out.println("Your Contacts : ");

        for (Contacts contact : addressBook.contactsArrayList) {
            System.out.println(contact);
        }
    }
}