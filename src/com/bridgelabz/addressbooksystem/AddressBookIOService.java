package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class AddressBookIOService {
    public static final String DIR_PATH = "AddressBookDirectory/";
//    public static final String FILE_PATH = DIR_PATH + "AddressBookData.txt";

    public void writeAddressBookData( Map<String, AddressBook> map ) {

        Path directoryPath = Paths.get(DIR_PATH);
//        Path filePath = Paths.get(FILE_PATH);


        System.out.println("Does "+DIR_PATH+" exist ? " + Files.exists(directoryPath));
//        System.out.println("Does "+FILE_PATH+" exist ? " + Files.exists(filePath));

        if(Files.notExists(directoryPath)){

            try{
                Files.createDirectories(directoryPath);

            }catch(IOException e){
                e.printStackTrace();

            }

        }else{
            try {
                for (Map.Entry<String, AddressBook> pair : map.entrySet()) {

                    String fileName = pair.getKey() + ".txt";
                    Path filePath = Paths.get(DIR_PATH + fileName);

//                      String addressBookPath = DIR_PATH + pair.getKey() + ".txt";
//                      Path filePath = Paths.get(addressBookPath);

                    if(Files.notExists(filePath)) {

                        Files.createFile(filePath);

                        StringBuffer addressBookBuffer = new StringBuffer();

                        for (Contacts contacts : pair.getValue().contactsArrayList) {

//                            addressBookBuffer.append("----------- Contacts under Address Book :"+pair.getKey()+" ------------"+"\n");

//                            addressBookBuffer.append("First Name"+"\t"+"Last Name"+"\t"+"Email"
//                            +"\t"+"Phone Number"+"\t"+"Zip"+"\t"+"City"+"\t"+"State"+"\t"+"Address"+"\n");

                            addressBookBuffer.append(contacts.getFirstName()+"\t"+contacts.getLastName()+"\t"+contacts.getEmail()
                                    +"\t"+contacts.getPhoneNumber()+"\t"+contacts.getZip()+"\t"+contacts.getCity()+"\t"
                                    +contacts.getState()+"\t"+contacts.getAddress()+"\n");

//                            empBuffer.append(emp.getId() + "\t" + emp.getName() + "\t"
//                                    + emp.getSalary() + "\n");
                        }

                        Files.write(filePath, addressBookBuffer.toString().getBytes());




                    }

                }


            } catch (IOException e) {
                e.printStackTrace();

            }



        }

//        System.out.println("Does "+DIR_PATH+" exist ? " + Files.exists(directoryPath));
//        System.out.println("Does "+FILE_PATH+" exist ? " + Files.exists(filePath));



    }

    public void readAddressBookData(Map<String, AddressBook> map) {

        try {

            for (Map.Entry<String, AddressBook> pair : map.entrySet()) {



                String addressBookPath = DIR_PATH + pair.getKey() + ".txt";
                System.out.println("----------- Contacts under Address Book :" + pair.getKey() + " ------------" + "\n");
                Files.lines(new File(addressBookPath).toPath()).forEach(System.out::println);


            }

            }catch (IOException e) {
            e.printStackTrace();
        }





    }

}
