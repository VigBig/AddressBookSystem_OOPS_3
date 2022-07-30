package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        boolean askToAddContact = true;
        boolean askToEditContact = true;
        boolean askToDeleteContact = true;

        boolean menuAgain = true;
        Scanner sc = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        start:
        while(menuAgain){
            System.out.println("Welcome to Address Book Program");
            System.out.println("Select options(1 to 5) below:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Exit Program");
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
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Incorrect Input. Please enter options between 1 to 5.");
                    continue start;
            }

            if(choice ==5) {
                break;
            }else{
                System.out.println("Do you wish to return to menu? (Enter Y as Yes or any key as No)");
                char c = sc.next().charAt(0);

                if(c== 'y'|| c=='Y'){
                    continue;
                }
                else{
                    System.out.println("Exiting program");
                    break;
                }

            }


        }


    }

}