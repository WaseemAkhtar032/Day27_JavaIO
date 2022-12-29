package uc1readwriteemployeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    static ArrayList<EmployeePayrollData> employeePayrollDatas = new ArrayList<>();

    public <T> EmployeePayrollService(List<T> asList) {
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee payroll service!");

        Scanner sc = new Scanner(System.in);
        EmployeePayrollService.readEmployeePayrollData(sc);
        EmployeePayrollService.writeEmployeePayrollData();
    }

    private static void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter employee Id : ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter employee Name : ");
        String name = consoleInputReader.next();
        System.out.println("Enter employee Salary : ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollDatas.add(new EmployeePayrollData(id, name, salary));
    }


    public static void writeEmployeePayrollData() {
        System.out.println("Writing Employee payroll data to console " + employeePayrollDatas);
    }

    public long countEntries(Object fileIo) {
        return 0;
    }
}
