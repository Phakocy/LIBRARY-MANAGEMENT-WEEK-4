package Service;

import model.User;
import java.util.HashMap;
import java.util.Map;


public class LibraryRequest {

    private static HashMap<String, Integer> books = new HashMap<>();
    private static Map<String, Integer> getLibraryRecordMap() {
        return books;
    }


    public  void addBook(String title, Integer noOfCopies){
        books.put(title, noOfCopies);
    }


    public static String borrowBook(User user, String title, Integer noOfCopies){

        if(books.containsKey(title)) {

            Integer copies = books.get(title);
            if (copies != 0) {
                Map<String, Integer> borrowedBooks = new HashMap<>();
                if (noOfCopies < copies) {
                    borrowedBooks.put(title, noOfCopies);
                    user.setBorrowedBooks(borrowedBooks); // show the record of books borrowed by person in person obj
                    books.put(title, copies - noOfCopies ); //update book in the library
                    return noOfCopies + " copies of Book titled, " + title + " is borrowed out to " + user.getFullname();
                } else {
                    borrowedBooks.put(title, 1);
                    user.setBorrowedBooks(borrowedBooks); // show books borrowed by person in person obj
                    books.put(title, copies - 1); //update the number of book in the library
                    return "A copy of Book titled, " + title + " is borrowed out to" + " " + user.getFullname();
                }
            } else {

                return "Book not available at the moment " + user.getFullname();
            }
        }else{

            return "Book not found "+user.getFullname();
        }
    }
}