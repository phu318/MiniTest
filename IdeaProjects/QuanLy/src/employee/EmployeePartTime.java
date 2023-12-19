package employee;

public class EmployeePartTime extends Employee{
    private long hourwork;

    public EmployeePartTime(long id, String name, long age, String phone, String email) {
        super(id, name, age, phone, email);
    }

    public EmployeePartTime(long id, String name, long age, String phone, String email, long hourwork) {
        super(id, name, age, phone, email);
        this.hourwork = hourwork;
    }

    public long getHourwork() {
        return hourwork;
    }

    public void setHourwork(long hourwork) {
        this.hourwork = hourwork;
    }
}
