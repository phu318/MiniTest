import employee.Employee;
import employee.EmployeeFullTime;
import employee.EmployeePartTime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new EmployeeFullTime(1, "Phu", 19, "075757575", "dhghsgdh@gmail.com", 100, 100, 2000);
        employee[1] = new EmployeeFullTime(2, "anh", 20, "067575774", "guguguggu@gmail.com", 50, 100, 300);
        employee[2] = new EmployeeFullTime(3, "anh", 20, "067575774", "guguguggu@gmail.com", 50, 100, 300);
        employee[3] = new EmployeePartTime(4, "hihih", 32, "95757574", "fuufufuf@gmail.com", 8);
        employee[4] = new EmployeePartTime(5, "hihih", 32, "95757574", "fuufufuf@gmail.com", 7);
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1. Tính trung bình lương cả công ty");
        System.out.println("2. Tính trung bình lương fulltime");
        System.out.println("3. Tính trung bình lương parttime");
        System.out.println("4. Tính tổng lương phải trả cho nhân viên parttime");
        System.out.println("4. Đếm số người có mức lương cao hơn lương trung bình trong của công ty");
        System.out.println("5. Đếm số nhân viên parttime nhập từ bàn phím");
        int choice = scanner.nextInt();
        boolean flag = false;
        switch (choice){
            case 1 :{
                System.out.println(averageSalaryCompany(employee));
                break;
            }
            case 2 : {
                System.out.println(averageSalaryFullTime(employee));
                break;
            }
            case 3 : {
                System.out.println(averageSalaryPartTime(employee));
                break;
            }
//            case 4 : {
//                totalSalaryOfPartTime();
//            }
            default:
                System.out.println("Lua chọn sai chọn lại");
        }



    }

//    private static long totalSalaryOfPartTime(Employee[] employees) {
//        for (Employee employee: employees) {
//
//        }
//    }

    private static long averageSalaryPartTime(Employee[] employees) {
        long count = 0;
        for (Employee employee: employees) {
            if (employee instanceof EmployeePartTime){
                EmployeePartTime employeePartTime = (EmployeePartTime) employee;
                if (employeePartTime != null){
                    count++;
                }

            }
        }
        long total = totalSalaryPartTime(employees);
        long averageSalaryPartTime = total/count;
        return averageSalaryPartTime;
    }


    private static long averageSalaryFullTime(Employee[] employees) {
        long count = 0;
        for (Employee employee: employees) {
            if (employee instanceof EmployeeFullTime){
                EmployeeFullTime employeeFullTime = (EmployeeFullTime) employee;
                if (employeeFullTime != null){
                    count++;
                }

            }
        }
        long total = totalSalaryFullTime(employees);
        long averageSalaryFulltime = total/count;
        return averageSalaryFulltime;
    }

    private static long averageSalaryCompany(Employee[] employees) {

        long totalFullTime = totalSalaryFullTime(employees);
        long totalPartTime = totalSalaryPartTime(employees);
        return (totalFullTime  + totalPartTime)/2;
    }

    public static long totalSalaryFullTime(Employee[] employees) {
        long total = 0;
        for (Employee employee : employees) {
            if (employee instanceof EmployeeFullTime) {
                EmployeeFullTime employeeFullTime = (EmployeeFullTime) employee;

                if (employeeFullTime != null) {
                    total += (employeeFullTime.getHardsalary() + (employeeFullTime.getMoneybonus() - employeeFullTime.getMoneyfined()));
                }
            }

            }

        return total;
    }


    public static long totalSalaryPartTime(Employee[] employees){
        long total = 0;
        for (Employee employee: employees
             ) { if (employee instanceof EmployeePartTime){
            EmployeePartTime employeePartTime = (EmployeePartTime) employee;
            if (employeePartTime != null){
                total += (employeePartTime.getHourwork() * 100000);
            }

        }
    }
        return total;
    }
}
