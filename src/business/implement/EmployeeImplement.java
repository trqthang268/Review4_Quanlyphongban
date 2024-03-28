package business.implement;

import business.design.IEmployee;
import business.entity.Department;
import business.entity.Employee;

import java.util.*;

import static business.implement.DepartmentImplement.departmentList;

public class EmployeeImplement implements IEmployee {
    static List<Employee> employeeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public Employee findById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addNewElement() {
        if (departmentList.isEmpty()) {
            System.err.println("Chưa có phòng ban nào, hãy thêm phòng ban trước");
            return;
        }
        System.out.println("Nhập số lượng nhân viên muốn thêm");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ " + i);
            Employee newEmployee = new Employee();
            newEmployee.inputData(scanner, departmentList);
            employeeList.add(newEmployee);
        }
        System.out.println("Đã thêm mới nhân viên thành công");
    }

    @Override
    public void displayAllElement() {
        while (true) {
            int pagecount = (employeeList.size() % 4 == 0) ? (employeeList.size() / 4) : (employeeList.size() / 4 + 1);
            int pagedisplay = 1;
            int startIndex = 0;
            int endIndex = startIndex + 4;
            if (employeeList.isEmpty()) {
                System.err.println("Danh sách trống");
            } else {
                System.out.println("Danh sách nhân viên");
                if (employeeList.size() > 4) {
                    for (int i = startIndex; i < endIndex; i++) {
                        if (employeeList.get(i) == null) {
                            return;
                        }
                        employeeList.get(i).displayData();
                    }
                }else {
                    for (int i = 0; i < employeeList.size(); i++) {
                        employeeList.get(i).displayData();
                    }
                }
                System.out.printf("Trang : %d / %d", pagedisplay, pagecount);
                System.out.println("1. Trang trước");
                System.out.println("2. Trang sau");
                System.out.println("3. Thoát");
                System.out.println("Lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        pagedisplay--;
                        startIndex -= 4;
                        if (pagedisplay <= 0) {
                            System.out.println("Không có trang trước");
                            pagedisplay++;
                            startIndex += 4;
                            break;
                        }
                        break;
                    case 2:
                        pagedisplay++;
                        startIndex += 4;
                        if (pagedisplay > pagecount) {
                            System.out.println("Không có trang sau");
                            pagedisplay--;
                            startIndex -= 4;
                            break;
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1-3");
                }
            }
        }
    }

    @Override
    public void editElement() {
        System.out.println("Hãy nhập mã nhân viên muốn chỉnh sửa");
        int editId = Integer.parseInt(scanner.nextLine());
        Employee employeeEdit = findById(editId);
        if (employeeEdit == null) {
            System.err.println("Không tìm thấy nhân viên");
            return;
        }
        System.out.println("Thông tin cũ của nhân viên");
        employeeEdit.displayData();
        Department oldDepartment = employeeEdit.getDepartment();
        oldDepartment.setNumberEmployee(oldDepartment.getNumberEmployee() - 1);
        System.out.println("Nhập thông tin mới của nhân viên");
        employeeEdit.inputData(scanner, departmentList);
        System.out.println("Cập nhật thông tin thành công");
    }

    @Override
    public void changeStatusElement() {
        System.out.println("Nhập mã nhân viên muốn thay đổi trạng thái");
        int changeStatusId = Integer.parseInt(scanner.nextLine());
        Employee statusEmployee = findById(changeStatusId);
        if (statusEmployee == null) {
            System.err.println("Không tìm thấy nhân viên");
            return;
        }
        System.out.println("Trạng thái cũ của phòng ban");
        System.out.println(statusEmployee.isStatus() ? "Đang hoạt động" : "Không hoạt động");
//        phủ định trạng thái cũ
        statusEmployee.setStatus(!statusEmployee.isStatus());
        System.out.println("Trạng thái mới của phòng ban");
        System.out.println(statusEmployee.isStatus() ? "Đang hoạt động" : "Không hoạt động");
    }

    @Override
    public Employee findElementByName(String name) {
        for (Employee employee : employeeList) {
            if (employee.getFullName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void searchEmployeeByName() {
        System.out.println("Nhập tên nhân viên muốn tìm");
        String searchName = scanner.nextLine().toLowerCase();
        System.out.println("Danh sách những người có tên là " + searchName);
        boolean isExist = true;
        for (Employee employee : employeeList) {
            if (employee.getFullName().contains(searchName)) {
                employee.displayData();
                isExist = false;
            }
        }
        if (isExist) {
            System.out.println("Người mang tên này không tồn tại");
        }
    }

    @Override
    public void searchEmployeeByDepartment() {
        System.out.println("Nhập tên phòng ban muốn tìm ");
        String departmentName = scanner.nextLine();
        boolean isExist = true;
        System.out.println("Danh sách nhân viên trong phòng ban đó là");
        for (Employee employee : employeeList) {
            if (employee.getDepartment().getDepartmentName().equals(departmentName)) {
                employee.displayData();
                isExist = false;
            }
        }
        if (isExist) {
            System.out.println("Phòng ban không có nhân viên");
        }
    }

    public void sortEmployeeByName() {
        System.out.println("Danh sách nhân viên đã được sắp xếp");
        employeeList.stream().sorted((Comparator.comparing(Employee::getFullName))).forEach(Employee::displayData);
    }
}
