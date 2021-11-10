package Service;

import model.User;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LibraryRegistrationPoint {

    private final static Set<User>  registeredUsers = new LinkedHashSet<>();
    private final static Queue <User> userQueue = new LinkedList<>();
    private final static Queue <User> priorityQueue = new PriorityQueue<>((user1, user2) -> {

         if( user1.getPriority() < user2.getPriority()){
             return -1;

         } else if ( user1.getPriority() > user2.getPriority()){
                return 1;
         } else {
             return 0;
         }
    });

    public Consumer<User> registerForLibraryCard = user -> {
        //Validation
        if(user != null){                   //If User exist then add user to queue
            addUserToQueue.accept(user);
        } else {

            System.out.println("Error adding user to queue");
            throw new NullPointerException();
        }
    };

   static Consumer<User> addUserToQueue = user -> {
        try {

            if (!userQueue.contains(user)){
                userQueue.add(user);
            }

            if (!priorityQueue.contains(user)){
                priorityQueue.add(user);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            System.out.println("User was not added to the queue. Library card not found");
        }
    };

    public Queue<User> getUserQueue(){
        return userQueue;
    }

    public Queue<User> getPriorityQueue(){
        return priorityQueue;
    }

    public Supplier<Set <User>> registerUser = () -> {

        if(!userQueue.isEmpty()){

            final User  registeredUser = userQueue.remove(); //FIFO

            registeredUsers.add(registeredUser);

            System.out.println(registeredUsers);
        }

        return registeredUsers;
    };

    public Supplier<List <User>> printRegisteredUser = () -> {

        List<User> users = new ArrayList<>(1);

        for (User user: registeredUsers) {

            System.out.println(user);

            users.add(user);

        }

      return users;
    };

    public Supplier<Set <User>> registerUserWithPriority = () -> {

        if(!priorityQueue.isEmpty()){

            final User  priorityUSer = priorityQueue.remove();

            registeredUsers.add(priorityUSer);

            System.out.println(registeredUsers);
        }

        return registeredUsers;
    };
}

