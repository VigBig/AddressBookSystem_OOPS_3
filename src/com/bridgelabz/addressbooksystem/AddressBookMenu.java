package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMenu {
    static Scanner sc = new Scanner(System.in);
    Map<String, AddressBook> map = new HashMap<>();

    public int addressBookMenuOptions() {

        AddressBook addressBook = new AddressBook();
        System.out.println("Select Address Book menu options(1 to 6) below. Entering anything else option will exit the menu:");
        System.out.println("1. Add Address Book");
        System.out.println("2. Search Contacts by City or State");
        System.out.println("3. View Contacts by City or State");
        System.out.println("4. Count Contacts by City or State");
        System.out.println("5. Sort Contacts by Name,City, State or Zip");
        System.out.println("6. View Address Book and Contacts");
        int addressBookMenuChoice = sc.nextInt();

        switch (addressBookMenuChoice) {

            case 1:

                System.out.println("Enter Address Book Name:");
                String addressBookName = sc.next();

                if (addressBook.addAddressBook(map, addressBookName))
                    break;
                else{
                        while(true) {
                            if (contactsMenu(addressBookName, addressBook) == false)
                                break;
                        }
                    }
                break;
            case 2:
                addressBook.SearchPersonByCityOrState(map);
                break;

            case 3:
                addressBook.ViewPersonByCityOrState(map);
                break;
            case 4:
                addressBook.CountPersonByCityOrState(map);
                break;
            case 5:
                addressBook.SortPersonByNameOrCityOrStateOrZip(map);
                break;

            case 6:

                System.out.println("Displaying All Address books with its contacts:");
                for (Map.Entry<String, AddressBook> pair : map.entrySet()) {
                    System.out.println("Address Book Name is: " + pair.getKey() + " and its Contacts are :" + pair.getValue().contactsArrayList);
                }

                break;

            case 7:
                System.out.println("Exiting Address Book menu");
                break;
            default:

        }

        return addressBookMenuChoice;

    }

    public boolean contactsMenu(String addressBookName, AddressBook addressBook) {

        System.out.println("Select Contacts Menu options(1 to 4) below. Entering anything else will exit the contacts menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. View Contacts");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addressBook.addContact();

                System.out.println("Your Contacts : ");

                for (Contacts contact : addressBook.contactsArrayList) {
                    System.out.println(contact);
                }
                break;
            case 2:
                addressBook.editContact();

                System.out.println("Your Updated Contacts : ");

                for (Contacts contact : addressBook.contactsArrayList) {
                    System.out.println(contact);
                }

                break;
            case 3:
                addressBook.deleteContact();

                System.out.println("Your Updated Contacts : ");

                for (Contacts contact : addressBook.contactsArrayList) {
                    System.out.println(contact);
                }

                break;
            case 4:
                System.out.println("Your Contacts : ");

                for (Contacts contact : addressBook.contactsArrayList) {
                    System.out.println(contact);
                }
                break;
            default:
                System.out.println("Exiting Contacts menu");
                break;
        }

        map.put(addressBookName, addressBook);
        if(choice <1 || choice >4){
            return false;
        }else{
            return true;
        }

    }
}




