package business.design;

import business.entity.Employee;

public interface IEmployee extends IGenericDesign<Employee,String>{
void searchEmployeeByName();
void searchEmployeeByDepartment();
}
