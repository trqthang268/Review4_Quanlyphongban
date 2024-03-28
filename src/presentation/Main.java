package presentation;

import java.util.Scanner;

public class Main {
    private static EmployeeManagement employeeManagement = new EmployeeManagement();
    private static DepartmentManagement departmentManagement = new DepartmentManagement();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("================MENU===================");
            System.out.println("1- Quản trị department : \n" +
                    "2- Quản lý employee \n" +
                    "3- Thoát ");
            System.out.println("=========================================");
            System.out.println("Nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    departmentManagement.displayDepartmentMenu();
                    break;
                case 2:
                    employeeManagement.displayEmployeeMenu();
                    break;
                case 3:
                    System.out.println("Thoát");
                    return;
                default:
                    System.err.println("Vui lòng nhập từ 1-3");
            }
        }

    }
}