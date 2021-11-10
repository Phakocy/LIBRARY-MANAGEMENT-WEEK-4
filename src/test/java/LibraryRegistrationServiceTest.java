import Service.LibraryRegistrationPoint;
import Service.LibraryRequest;
import enums.PriorityType;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryRegistrationServiceTest {
    LibraryRegistrationPoint lib;
    LibraryRequest library;
    User user1;
    User user2;
    User user3;

    @BeforeEach
    void setUp() {
       lib  = new LibraryRegistrationPoint();
       library = new LibraryRequest();
       user1 = new User("Tunde", 001, PriorityType.SENIOR);
       user2 = new User("Balogun", 004, PriorityType.TEACHER);
       user3 = new User("Iyke", 003, PriorityType.OTHERS);
    }

    @Test
    void shouldCheckWhetherUserExistInQueue() {
        lib.registerForLibraryCard.accept(user1);
       assertTrue(lib.getUserQueue().contains(user1));
        assertNotNull(lib.getUserQueue().contains(user1));
    }


    @Test
    void shouldAssignBookBasedOnFIFO() {
        library.addBook("Biology", 2);
        lib.registerForLibraryCard.accept(user2);
        lib.registerForLibraryCard.accept(user1);
        assertEquals("Tunde", lib.getUserQueue().remove().getFullname());
    }

    @Test
    void shouldAssignBookBasedOnPriority() {
        library.addBook("Biology", 2);
        lib.registerForLibraryCard.accept(user1);
        lib.registerForLibraryCard.accept(user2);
        assertEquals("Balogun", lib.getPriorityQueue().remove().getFullname());
    }
}