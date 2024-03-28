package presentation;

import business.implement.DepartmentImplement;

import java.util.Scanner;

public class DepartmentManagement {
    static DepartmentImplement departmentImplement = new DepartmentImplement();
    Scanner scanner =new Scanner(System.in);
    public void displayDepartmentMenu() {
        while (true) {
            System.out.println("================Department Menu===================");
            System.out.println("1. Hiển thị tất cả department \n" +
                    "2. Thêm mới department\n" +
                    "3. Sửa thông tin department\n" +
                    "4. Thay đổi trạng thái department\n" +
                    "5. Tìm kiếm phòng ban theo tên \n"+
                    "6. Quay lại");
            System.out.println("=======================================");
            System.out.println("Nhập lựa chọn :");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    departmentImplement.displayAllElement();
                    break;
                case 2:
                    departmentImplement.addNewElement();
                    break;
                case 3:
                    departmentImplement.editElement();
                    break;
                case 4:
                    departmentImplement.changeStatusElement();
                    break;
                case 5:
                    departmentImplement.searchDepartmentByName();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }

}
