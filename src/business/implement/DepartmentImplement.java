package business.implement;

import business.design.IDepartment;
import business.entity.Department;
import business.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentImplement implements IDepartment {
    static List<Department> departmentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addNewElement() {
        System.out.println("Nhập số lượng phòng ban muốn thêm mới");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin cho phòng ban thứ " + i);
            Department department = new Department();
            department.inputData(scanner, departmentList);
            departmentList.add(department);
        }
        System.out.println("Đã thêm mới thành công");
    }

    @Override
    public void displayAllElement() {
        if (departmentList.isEmpty()) {
            System.err.println("Danh sách trống");
        } else {
            departmentList.forEach(department -> department.displayData());
        }
    }

    @Override
    public void editElement() {
        System.out.println("Nhập mã phòng ban muốn sửa thông tin");
        int updateId = Integer.parseInt(scanner.nextLine());
        Department updateDepartment = findById(updateId);
        if (updateDepartment == null) {
            System.err.println("Không tìm thấy phòng ban");
            return;
        }
        System.out.println("Thông tin cũ của phòng ban");
        updateDepartment.displayData();
        System.out.println("Nhập thông tin mới :");
        updateDepartment.inputData(scanner, departmentList);
        System.out.println("Cập nhật thông tin thành công");
    }

    @Override
    public void changeStatusElement() {
        System.out.println("Nhập mã phòng ban muốn thay đổi trạng thái");
        int changeStatusId = Integer.parseInt(scanner.nextLine());
        Department statusDepartment = findById(changeStatusId);
        if (statusDepartment == null) {
            System.err.println("Không tìm thấy phòng ban");
            return;
        }
        System.out.println("Trạng thái cũ của phòng ban");
        System.out.println(statusDepartment.isDepartmentStatus() ? "Đang hoạt động" : "Không hoạt động");
//        phủ định trang thái cũ
        statusDepartment.setDepartmentStatus(!statusDepartment.isDepartmentStatus());
        System.out.println("Trạng thái mới của phòng ban");
        System.out.println(statusDepartment.isDepartmentStatus() ? "Đang hoạt động" : "Không hoạt động");

    }

    @Override
    public void searchDepartmentByName() {
        System.out.println("Nhập tên phòng ban");
        String departmentName = scanner.nextLine();
        Department department = findElementByName(departmentName);
        if (department == null) {
            System.err.println("Không tìm thấy phòng ban");
            return;
        }
        System.out.println("Thông tin phòng ban theo tên bạn nhập là");
        department.displayData();
    }

    @Override
    public Department findElementByName(String name) {
        for (Department department : departmentList) {
            if (department.getDepartmentName().equals(name)) ;
            return department;
        }
        return null;
    }

    @Override
    public Department findById(int id) {
        for (Department department : departmentList) {
            if (department.getDepartmentId() == id) {
                return department;
            }
        }
        return null;
    }
}
