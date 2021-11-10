package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import enums.PriorityType;

public class User {
    private final String fullname;
    private final int requestNo;
    private final PriorityType designation;
    private int priority;
    private Map<String, Integer> borrowedBooks = new HashMap<>();



    public User(String name, int requestNo, PriorityType designation) {
        this.fullname = name != null && name.length() > 3 ? name : "No Name";
        this.requestNo = requestNo;
        this.designation = designation != null ? designation : PriorityType.TEACHER;

        setPriority();
    }

    private void setPriority() {
        if(designation == PriorityType.TEACHER){
            this.priority = 1;
        } else if (designation == PriorityType.SENIOR){
            this.priority = 2;
        } else {
            this.priority = 3;
        }
    }

    public String getFullname() {

        return fullname;
    }

    public int getRequestNo() {
        return requestNo;
    }

    public PriorityType getDesignation() {

        return designation;
    }

    public int getPriority() {
        return priority;
    }

    public Map<String, Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<String, Integer> borrowedBooks) {
    }

    public void getInfo(){
        System.out.println( getRequestNo() + ", " + getFullname() +", " + getDesignation() +", " + getPriority());

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return requestNo == user.requestNo && fullname.equals(user.fullname) && designation.equals(user.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, requestNo, designation);
    }

    @Override
    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", requestNo=" + requestNo +
                ", designation=" + designation +
                ", priority=" + priority +
                '}';
    }
}

