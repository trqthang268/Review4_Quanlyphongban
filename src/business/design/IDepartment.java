package business.design;

import business.entity.Department;

public interface IDepartment extends IGenericDesign<Department,String>{
    void searchDepartmentByName();
}
