package business.design;

import business.entity.Employee;

public interface IGenericDesign<T,E> {
    void addNewElement();
    void displayAllElement();
    void editElement();
    void changeStatusElement();
    T findElementByName(E name);
    T findById(int id);
}
