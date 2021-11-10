package enums;

public enum PriorityType {
    TEACHER(1),
    SENIOR(2),
    OTHERS(3);
    private int designation;

    PriorityType(int designation) {
        this.designation = designation;
    }
}
