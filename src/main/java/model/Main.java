package model;

import Service.LibraryRegistrationPoint;
import Service.LibraryRequest;
import enums.PriorityType;

public class Main {

    public static void main(String[] args) {


        User user1 = new User("Tunde", 001, PriorityType.SENIOR);

        User user2 = new User("Balogun", 004, PriorityType.TEACHER);

        User user3 = new User("Iyke", 003, PriorityType.OTHERS);

        User user4 = new User("Adigun", 002, PriorityType.TEACHER);

        LibraryRegistrationPoint registrationProcess =  new LibraryRegistrationPoint();

        registrationProcess.registerForLibraryCard.accept(user1);
        registrationProcess.registerForLibraryCard.accept(user2);
        registrationProcess.registerForLibraryCard.accept(user3);
        registrationProcess.registerForLibraryCard.accept(user4);

        System.out.println("***********************************");
        System.err.println("normsl");

       registrationProcess.registerUser.get();
       registrationProcess.registerUser.get();
       registrationProcess.registerUser.get();
       registrationProcess.registerUser.get();


        System.out.println("***********************************");

        registrationProcess.printRegisteredUser.get();

        System.out.println("***********************************");

        System.err.println("priority");
        registrationProcess.registerUserWithPriority.get();
        registrationProcess.registerUserWithPriority.get();
        registrationProcess.registerUserWithPriority.get();
        registrationProcess.registerUserWithPriority.get();

        System.out.println("***********************************");

        registrationProcess.printRegisteredUser.get();

        System.out.println("***********************************");


        LibraryRequest library = new LibraryRequest();
        library.addBook("Pathology", 1);
        library.addBook("Pharmacology", 21);
        library.addBook("Virology", 4);
        library.addBook("Javalogy", 35);
        library.addBook("Analogy", 6);

        System.out.println("***********************************");

        System.out.println(LibraryRequest.borrowBook(user2, "Pharmacology", 2));


        System.out.println("***********************************");
    }
}

