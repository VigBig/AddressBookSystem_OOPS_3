package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        boolean askToAddContact = true;
        boolean askToEditContact = true;
        boolean askToDeleteContact = true;

        boolean menuAgain = true;
        boolean bookAgain = true;
        Scanner sc = new Scanner(System.in);
        Map<String, AddressBook> map = new HashMap<>();

        while(bookAgain){
            AddressBook addressBook = new AddressBook();
            System.out.println("Enter Address Book Name:");
            String addressBookName = sc.next();
            if(addressBook.addAddressBook(map,addressBookName))
                menuAgain = false;
            else
                menuAgain = true;

            start:
            while(menuAgain){

                System.out.println("Select options(1 to 5) below:");
                System.out.println("1. Add Contact");
                System.out.println("2. Edit Contact");
                System.out.println("3. Delete Contact");
                System.out.println("4. View Contacts");
                System.out.println("5. Exit Contacts Menu");
                int choice = sc.nextInt();

                switch (choice){
                    case 1:
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
                        break;
                    case 2:
                        while(askToEditContact){
                            addressBook.editContact();

                            System.out.println("Do you wish to edit another contact? (Enter Y to edit or any key as No)");
                            char c2 = sc.next().charAt(0);

                            if(c2== 'y'|| c2=='Y'){
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

                        break;
                    case 3:
                        while(askToDeleteContact){
                            addressBook.deleteContact();

                            System.out.println("Do you wish to delete another contact? (Enter Y to delete or any key as No)");
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

                        break;
                    case 4:
                        System.out.println("Your Contacts : ");

                        for(Contacts contact: addressBook.contactsArrayList){
                            System.out.println(contact);
                        }
                        break;
                    case 5:
                        System.out.println("Exiting Contacts menu");
                        break;
                    default:
                        System.out.println("Incorrect Input. Please enter options between 1 to 5.");
                        continue start;
                }

                map.put(addressBookName,addressBook);
                if(choice ==5) {
                    break;
                }else{
                    System.out.println("Do you wish to return to menu? (Enter Y as Yes or any key as No)");
                    char c = sc.next().charAt(0);

                    if(c== 'y'|| c=='Y'){
                        continue;
                    }
                    else{
                        System.out.println("Exiting Contacts menu");
                        break;
                    }

                }

            }


            System.out.println("Do you wish to add another Address Book? (Enter Y as Yes or any key as No)");
            char c = sc.next().charAt(0);

            if(c== 'y'|| c=='Y'){
                continue;
            }
            else{

                break;
            }

        }

        System.out.println("Displaying All Address books with its contacts:");
        for (Map.Entry<String, AddressBook> pair : map.entrySet()) {
            System.out.println("Address Book Name is: "+ pair.getKey() +" and its Contacts are :"+ pair.getValue().contactsArrayList);
        }

        System.out.println("Exiting Program...");


    }

}