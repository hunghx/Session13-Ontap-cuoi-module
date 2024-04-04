package ra.business.designimpl;

import ra.business.design.IDesignEmployee;
import ra.business.entity.Employee;
import ra.util.IOFile;

import java.util.List;

public class EmployeeDesignImpl implements IDesignEmployee {
    private static List<Employee> employees;
    static {
        // khoi tao gia tri
        // doc du lieu tu file
        employees = IOFile.readFromFile(IOFile.EMPLOYEE_PATH);
    }
    @Override
    public void addNewEmployee(Employee employee) {
        employees.add(employee);
        // ghi ra file
        IOFile.writeToFile(IOFile.EMPLOYEE_PATH,employees);
    }

    @Override
    public List<Employee> findAll() {
       return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employees.set(employees.indexOf(findById(employee.getId())),employee);
        // ghi ra file
        IOFile.writeToFile(IOFile.EMPLOYEE_PATH,employees);
    }

    @Override
    public Employee findById(int id) {
        return employees.stream().filter(em->em.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void deleteById(int id) {
        employees.remove(findById(id));
        IOFile.writeToFile(IOFile.EMPLOYEE_PATH,employees);
    }

    @Override
    public int getNewId() {
      int max =  employees.stream().mapToInt(Employee::getId).max().orElse(0);
      return max+1;
    }
}
