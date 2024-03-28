package business.entity;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Department {
    public static int currentDepartmentId = 0;
    private int departmentId;
    private String departmentName;
    private int numberEmployee = 0;
    private boolean departmentStatus;

    public Department() {
        this.departmentId = ++currentDepartmentId;
        this.departmentStatus = true;
    }

    public Department(int departmentId, String departmentName, int numberEmployee, boolean departmentStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberEmployee = numberEmployee;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    public boolean isDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public void inputData(Scanner scanner, List<Department> departmentList) {
        this.departmentName = getInputDepartmentName(scanner, departmentList);
    }

    private String getInputDepartmentName(Scanner scanner, List<Department> departmentList) {
        do {
            System.out.println("Nhập tên phòng ban");
            String departmentNameInput = scanner.nextLine();
            if (!departmentNameInput.trim().isEmpty()) {
                if (departmentList.stream().noneMatch(name -> name.getDepartmentName().equals(departmentNameInput))) {
                    return departmentNameInput;
                } else {
                    System.err.println("Tên phòng ban đã tồn tại, vui lòng nhập lại");
                }
            } else {
                System.err.println("Không được để trống tên phòng, vui lòng nhập lại");
            }
        } while (true);
    }

    public void displayData(){
        System.out.printf("|Mã phòng ban : %d | Tên phòng ban : %s | Số nhân viên : %d | Trạng thái : %s\n",this.departmentId,this.departmentName,this.numberEmployee,this.departmentStatus?"Đang hoạt động":"Không hoạt động");
        System.out.println("---------------------------------------------------------------------");
    }


}
