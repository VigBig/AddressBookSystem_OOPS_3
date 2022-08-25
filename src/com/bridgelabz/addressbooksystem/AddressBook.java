package com.bridgelabz.addressbooksystem;

import java.util.*;
import java.util.stream.Stream;

public class AddressBook {

    static Scanner scanner = new Scanner(System.in);

    List<Contacts> contactsArrayList = new ArrayList<>();

    List<Contacts> contactsCityList = new ArrayList<>();
    List<Contacts> contactsStateList = new ArrayList<>();
    Map<String, List> cityPersonMap = new HashMap<>();
    Map<String, List> statePersonMap = new HashMap<>();

    public boolean addAddressBook(Map<String, AddressBook> map, String addressBookName) {

        if (map.get(addressBookName) != null) {

            System.out.println("the Entered address book is already exists");
            return true;
        }else{
            return false;
        }

    }

    public void addContact() {

        System.out.println("Enter First Name:");
        String firstName = scanner.next();

        System.out.println("Enter Last Name:");
        String lastName = scanner.next();

        boolean isContactThere = false;

        for(Contacts contact:contactsArrayList) {

            if (firstName.equals(contact.getFirstName()) && lastName.equals(contact.getLastName())) {

                isContactThere = true;
                break;

            }
        }
        if(isContactThere){
            System.out.println("Contact with First Name :"+firstName+" and Last Name :"+lastName+" already exists in the address book.");
        } else {
                Contacts contacts = new Contacts();

//                System.out.println("Enter First Name:");
//                String firstName = scanner.next();
                contacts.setFirstName(firstName);

//                System.out.println("Enter Last Name:");
//                String lastName = scanner.next();
                contacts.setLastName(lastName);

                System.out.println("Enter Email:");
                String email = scanner.next();
                contacts.setEmail(email);

                System.out.println("Enter Phone Number:");
                String phoneNumber = scanner.next();
                contacts.setPhoneNumber(phoneNumber);

                System.out.println("Enter Zip Code:");
                String zip = scanner.next();
                contacts.setZip(zip);

                System.out.println("Enter City:");
                String city = scanner.next();
                contacts.setCity(city);

                System.out.println("Enter State:");
                String state = scanner.next();
                contacts.setState(state);

                System.out.println("Enter Address:");
                String address = scanner.next();
                contacts.setAddress(address);

                contactsArrayList.add(contacts);
//                contactsCityList.add(contacts);
//                contactsStateList.add(contacts);

                mapCityAndStateToContactsList(cityPersonMap,city,statePersonMap,state,contacts);


                }

    }


    public void mapCityAndStateToContactsList(Map<String, List> cityPersonMap, String city, Map<String, List> statePersonMap, String state, Contacts contacts) {
        if(cityPersonMap.containsKey(city)){
            contactsCityList = cityPersonMap.get(city);
            contactsCityList.add(contacts);
        } else {
            List<Contacts> contactsCityList = new ArrayList<>();
            contactsCityList.add(contacts);
            cityPersonMap.put(city, contactsCityList);
        }

        if(statePersonMap.containsKey(state)){
            contactsStateList = statePersonMap.get(state);
            contactsStateList.add(contacts);
        } else {
            List<Contacts> contactsStateList = new ArrayList<>();
            contactsStateList.add(contacts);
            statePersonMap.put(state, contactsStateList);
        }

        System.out.println("Printing cityPersonMap :");
        System.out.println(cityPersonMap);

        System.out.println("Printing statePersonMap :");
        System.out.println(statePersonMap);
    }


    public void editContact() {
        System.out.println("Enter to search contact of First Name:");
        String firstName = scanner.next();

        boolean isContactThere = false;

        for(Contacts contact:contactsArrayList){

            if(firstName.equals(contact.getFirstName())){

                isContactThere =true;
                System.out.println("Contact Found! Edit contact details now :");
                if(contact.editContact(contactsArrayList)==false)
                    System.out.println("Contact edited successfully!");
                break;

            }

        }

        if(!isContactThere){
            System.out.println("No record of contact with First Name "+firstName+" in the address book.");
        }

    }

    public void deleteContact() {
        System.out.println("Enter to search contact of First Name:");
        String firstName = scanner.next();

        boolean isContactThere = false;

        for(Contacts contact:contactsArrayList){
            if(firstName.equals(contact.getFirstName())){

                isContactThere =true;
                contactsArrayList.remove(contact);
                System.out.println("Contact deleted successfully!");

                break;
            }

        }

        if(!isContactThere){
            System.out.println("No record of contact with First Name "+firstName+" in the address book.");
        }

    }


    public void SearchPersonByCityOrState(Map<String, AddressBook> map) {

        System.out.print(" Enter to view by city or state: ");
        String searchChoice = scanner.next();

        if(searchChoice.equalsIgnoreCase("City")){

            System.out.print(" Enter city : ");
            String city = scanner.next();

            map.values().stream().forEach( (addressBook) -> {

                addressBook.contactsArrayList.stream().filter( contacts ->

                        contacts.getCity().equalsIgnoreCase(city)

                ).forEach(contacts ->

                        System.out.println(contacts));

                }

            );

        } else if (searchChoice.equalsIgnoreCase("State")) {

            System.out.print(" Enter state : ");
            String state = scanner.next();

            map.values().stream().forEach( (addressBook) -> {

                        addressBook.contactsArrayList.stream().filter( contacts ->

                                contacts.getState().equalsIgnoreCase(state)

                        ).forEach(contacts ->

                                System.out.println(contacts));

                    }

            );

        }else
            System.out.println("Incorrect selection. Please select City or State");

    }

    public void ViewPersonByCityOrState(Map<String, AddressBook> map) {

        System.out.print(" Enter to view by city or state: ");
        String searchChoice = scanner.next();

        if(searchChoice.equalsIgnoreCase("City")){

            System.out.print(" Enter city : ");
            String city = scanner.next();

            map.values().stream().forEach( (addressBook) -> {

                    addressBook.cityPersonMap.entrySet().stream().filter((searchCity) ->

                            searchCity.getKey().equalsIgnoreCase(city)

                            ).forEach( (filteredCity) ->
                            System.out.println(filteredCity));

                    }

            );


//            map.values().stream().forEach( (addressBook) ->
//                    System.out.println(addressBook.cityPersonMap.get(city))
//            );

        } else if (searchChoice.equalsIgnoreCase("State")) {

            System.out.print(" Enter state : ");
            String state = scanner.next();

            map.values().stream().forEach( (addressBook) -> {

                        addressBook.statePersonMap.entrySet().stream().filter((searchState) ->

                                searchState.getKey().equalsIgnoreCase(state)

                        ).forEach( (filteredState) ->
                                System.out.println(filteredState));

                    }

            );

//            map.values().stream().forEach( (addressBook) ->
//                    System.out.println(addressBook.statePersonMap.get(state))
//            );

        }else
            System.out.println("Incorrect selection. Please select City or State");

    }
}