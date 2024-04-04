package ra.business.design;

import ra.business.entity.Employee;

import java.util.List;

public interface IDesignEmployee {
    void addNewEmployee(Employee employee);
    List<Employee> findAll();
    void updateEmployee(Employee employee);
    Employee findById(int id);
    void deleteById(int id);
    int getNewId();
}
