package presentation;

import business.implement.EmployeeImplement;

import java.util.Scanner;

public class EmployeeManagement {
    static EmployeeImplement employeeImplement = new EmployeeImplement();
    Scanner scanner =new Scanner(System.in);
    public void displayEmployeeMenu() {
        while (true) {
            System.out.println("================Employee Menu===================");
            System.out.println("1. Hiển thị tất cả employee \n" +
                    "2. Thêm mới employee\n" +
                    "3. Sửa thông tin employee\n" +
                    "4. Thay đổi trạng thái employee \n" +
                    "5. Tìm kiếm nhân viên theo tên nhân viên \n" +
                    "6. Tìm kiếm nhân viên theo mã phòng ban "+
                    "7. Sắp xếp nhân viên theo tên tăng dần"+
                    "8. Quay lại");
            System.out.println("Nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeImplement.displayAllElement();
                    break;
                case 2:
                    employeeImplement.addNewElement();
                    break;
                case 3:
                    employeeImplement.editElement();
                    break;
                case 4:
                    employeeImplement.changeStatusElement();
                    break;
                case 5:
                    employeeImplement.searchEmployeeByName();
                    break;
                case 6:
                    employeeImplement.searchEmployeeByDepartment();
                    return;
                case 7:
                    employeeImplement.sortEmployeeByName();
                case 8:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }
}
