package employee;

public class EmployeeFullTime extends Employee{
    private long moneybonus;
    private long moneyfined;
    private long hardsalary;

    public EmployeeFullTime(){
    }

    public EmployeeFullTime(long id, String name, long age, String phone, String email) {
        super(id, name, age, phone, email);
    }

    public EmployeeFullTime(long id, String name, long age, String phone, String email, long moneybonus, long moneyfined, long hardsalary) {
        super(id, name, age, phone, email);
        this.moneybonus = moneybonus;
        this.moneyfined = moneyfined;
        this.hardsalary = hardsalary;
    }

    public long getMoneybonus() {
        return moneybonus;
    }

    public void setMoneybonus(long moneybonus) {
        this.moneybonus = moneybonus;
    }

    public long getMoneyfined() {
        return moneyfined;
    }

    public void setMoneyfined(long moneyfined) {
        this.moneyfined = moneyfined;
    }

    public long getHardsalary() {
        return hardsalary;
    }

    public void setHardsalary(long hardsalary) {
        this.hardsalary = hardsalary;
    }
}
