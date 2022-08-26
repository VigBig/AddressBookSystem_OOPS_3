package com.bridgelabz.addressbooksystem;

import java.util.*;

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


                contacts.setFirstName(firstName);


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

    }


    public void editContact() {
        System.out.println("Enter to search contact of First Name:");
        String firstName = scanner.next();

        boolean isContactThere = false;

        for(Contacts contact:contactsArrayList){

            if(firstName.equals(contact.getFirstName())){

                isContactThere =true;
                System.out.println("Contact Found! Edit contact details now :");
                contact.editContact();
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

        System.out.print(" Enter option to search by city or state: ");
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

        System.out.print(" Enter option to view by city or state: ");
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


        }else
            System.out.println("Incorrect selection. Please select City or State");

    }

    public void CountPersonByCityOrState(Map<String, AddressBook> map) {

        System.out.print(" Enter option to count by city or state: ");
        String searchChoice = scanner.next();

        if(searchChoice.equalsIgnoreCase("City")){

            System.out.print(" Enter city : ");
            String city = scanner.next();

            int cityCount = 0;

            for (AddressBook addBook : map.values()) {

                cityCount += addBook.contactsArrayList.stream().filter((contact) ->

                        contact.getCity().equalsIgnoreCase(city)

                ).count();

            }

            System.out.println(" Total count: " + cityCount);


        } else if (searchChoice.equalsIgnoreCase("State")) {

            System.out.print(" Enter state : ");
            String state = scanner.next();

                int stateCount = 0;

                for (AddressBook addBook : map.values()) {

                    stateCount += addBook.contactsArrayList.stream().filter((contact) ->

                            contact.getState().equalsIgnoreCase(state)

                    ).count();

                }

                    System.out.println(" Total count: " + stateCount);

        }else
            System.out.println("Incorrect selection. Please select City or State");


    }

    public void SortPersonByNameOrCityOrStateOrZip(Map<String, AddressBook> map) {
        System.out.print(" Enter option to sort by name,city, state or zip: ");
        String searchChoice = scanner.next();

        if (searchChoice.equalsIgnoreCase("Name")) {


            for (Map.Entry<String, AddressBook> pair : map.entrySet()) {

                System.out.println("Sorting entries for AddressBook '"+pair.getKey()+"' by Name:"+"\n");

                pair.getValue().contactsArrayList.stream().sorted((contact1, contact2) ->

                         contact1.getFirstName().compareToIgnoreCase(contact2.getFirstName())

                ).forEach(contact -> System.out.println(contact));

            }



        }else if (searchChoice.equalsIgnoreCase("City")) {


            for (Map.Entry<String, AddressBook> pair : map.entrySet()) {

                System.out.println("Sorting entries for AddressBook '"+pair.getKey()+"' by City:"+"\n");

                pair.getValue().contactsArrayList.stream().sorted((contact1, contact2) ->

                        contact1.getCity().compareToIgnoreCase(contact2.getCity())

                ).forEach(contact -> System.out.println(contact));

            }

        } else if (searchChoice.equalsIgnoreCase("State")) {


            for (Map.Entry<String, AddressBook> pair : map.entrySet()) {

                System.out.println("Sorting entries for AddressBook '"+pair.getKey()+"' by State:"+"\n");

                pair.getValue().contactsArrayList.stream().sorted((contact1, contact2) ->

                        contact1.getState().compareToIgnoreCase(contact2.getState())

                ).forEach(contact -> System.out.println(contact));

            }

        } else if (searchChoice.equalsIgnoreCase("Zip")) {

            for (Map.Entry<String, AddressBook> pair : map.entrySet()) {

                System.out.println("Sorting entries for AddressBook '"+pair.getKey()+"' by Zip:"+"\n");

                pair.getValue().contactsArrayList.stream().sorted((contact1, contact2) ->

                        contact1.getZip().compareToIgnoreCase(contact2.getZip())

                ).forEach(contact -> System.out.println(contact));

            }

        } else
            System.out.println("Incorrect selection. Please select Name,City,State or Zip");
    }

}