package business.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Employee {
    public static  int currentEmployeeId = 0;
    private int employeeId;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;
    private Department department;
    private boolean status = true;

    public Employee() {
        this.employeeId = ++currentEmployeeId;
    }

    public Employee(int employeeId, String fullName, String address, String phone, LocalDate dateOfBirth, Department department, boolean status) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, List<Department> departmentList){
        this.fullName = getInputFullName(scanner);
        this.address = getInputAddress(scanner);
        this.phone = getInputPhone(scanner);
        this.dateOfBirth = getInputBirthDay(scanner);
        this.department = getInputDepartment(scanner,departmentList);
    }

    private String getInputFullName(Scanner scanner) {
        while (true){
            System.out.println("Nhập tên nhân viên");
            String employeeNameInput = scanner.nextLine();
            if (!employeeNameInput.trim().isEmpty()){
                return employeeNameInput;
            }else {
                System.out.println("Không được để trống tên nhân viên");
            }
        }
    }

    private String getInputAddress(Scanner scanner) {
        while (true){
            System.out.println("Nhập địa chỉ nhân viên");
            String employeeAddressInput = scanner.nextLine();
            if (!employeeAddressInput.trim().isEmpty()){
                return employeeAddressInput;
            }else {
                System.out.println("Không được để trống địa chỉ nhân viên");
            }
        }
    }

    private String getInputPhone(Scanner scanner) {
        final String phoneRegex = "((^(\\+84|84|0|0084){1})(3|5|7|8|9))+([0-9]{8})$";
        while (true){
            System.out.println("Nhập số điện thoại nhân viên");
            String employeePhoneInput = scanner.nextLine();
            if (!employeePhoneInput.trim().isEmpty()){
                if (employeePhoneInput.matches(phoneRegex)){
                    return employeePhoneInput;
                }else{
                    System.out.println("Số điện thoại không khớp với đinh dạng, vui lòng nhập lại");
                }
            }else {
                System.out.println("Không được để trống, vui lòng nhập lại");
            }
        }
    }

    private LocalDate getInputBirthDay(Scanner scanner) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            System.out.println("Nhập ngày sinh dd/MM/yyyy");
            String employeeBirthDayInput = scanner.nextLine();
            try {
                return LocalDate.parse(employeeBirthDayInput,dtf);
            }catch (DateTimeParseException e){
                System.err.println("Không đúng định dạng dd/MM/yyyy");
            }
        }
    }

    private Department getInputDepartment(Scanner scanner, List<Department> departmentList) {
        System.out.println("Danh sách phòng ban");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.printf("Mã phòng: %d | Tên phòng: %s",departmentList.get(i).getDepartmentId(),departmentList.get(i).getDepartmentName());
        }
        while (true){
            System.out.println("Nhập mã phòng ban");
            int inputID = Integer.parseInt(scanner.nextLine());
            int indexID = findIndexById(inputID,departmentList);
            if (indexID >= 0 && indexID <= departmentList.size()){
                Department department1 = departmentList.get(indexID);
                department1.setNumberEmployee(department1.getNumberEmployee()+1);
                return department1;
            }
            System.err.println("Vị trí nhập không hợp lệ, vui lòng nhập giá trị hợp lệ!");
        }
    }
    public int findIndexById(int id,List<Department> departmentList){
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentId() == id){
                return i;
            }
        }
        return -1;
    }

    public void displayData(){
        System.out.printf("| ID : %-2d | Name : %-15s | DoB : %-10s | Phone : %-10s |\n",
                employeeId,fullName,dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),phone);
        System.out.printf("| Address : %-15s | Department : %-15s | Status : %s |\n",address,department.getDepartmentName(),this.status?"Đang hoạt động":"Không hoạt động");
        System.out.println("------------------------------------------------------------------");

    }
}
