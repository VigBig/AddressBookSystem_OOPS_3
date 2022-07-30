package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        boolean askToAddContact = true;
        boolean askToEditContact = true;
        Scanner sc = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book Program");

        while (askToAddContact){
            addressBook.addContact();

            System.out.println("Do you wish to add another contact? (Enter Y to add or any key as No)");
            char c = sc.next().charAt(0);

            if(c== 'y'|| c=='Y'){
                continue;
            }
            else{
                break;
            }
        }

        System.out.println("Your Contacts : ");

        for(Contacts contact: addressBook.contactsArrayList){
            System.out.println(contact);
        }

        System.out.println("Do you wish to edit contact? (Enter Y to add or any key as No)");
        char c2 = sc.next().charAt(0);
        if(c2== 'y'|| c2=='Y'){
            while(askToEditContact){
                addressBook.editContact();

                System.out.println("Do you wish to edit another contact? (Enter Y to add or any key as No)");
                char c3 = sc.next().charAt(0);

                if(c3== 'y'|| c3=='Y'){
                    continue;
                }
                else{
                    break;
                }
            }
            System.out.println("Your Updated Contacts : ");

            for(Contacts contact: addressBook.contactsArrayList){
                System.out.println(contact);
            }
        }

    }
}