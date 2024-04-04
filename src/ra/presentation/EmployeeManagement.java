package ra.presentation;

import ra.business.design.IDesignEmployee;
import ra.business.designimpl.EmployeeDesignImpl;
import ra.business.entity.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    private static IDesignEmployee designEmployee = new EmployeeDesignImpl();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte choice = 0;
        while (choice!=6){
            // hien thi menu
            System.out.println("-----------------MENU------------------");
            System.out.println("1. Them moi");
            System.out.println("2. Hien thi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Sap xep");
            System.out.println("6. Thoat");
            System.out.println("Nhap lua chon");
            choice = new Scanner(System.in).nextByte();
            switch (choice){
                case 1:
                    addNewEmployee(scanner);
                    break;
                case 2:
                    displayAllEmployee();
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Dung chuong trinh");
                    break;
                default:
                    System.err.println("Nhap ko hop le");
            }
        }
        scanner.close();
    }
    protected static void addNewEmployee(Scanner sc){
        System.out.println("Nhap so luong muon them");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <=count ; i++) {
            System.out.println("Hay nhap thong tin cho nhan vien thu "+i);
            Employee employee = new Employee();
            employee.setId(designEmployee.getNewId());
            employee.inputData();
            designEmployee.addNewEmployee(employee);
        }
        System.out.println("Da them moi thanh cong");
    }
    protected static void displayAllEmployee(){
        List<Employee> list = designEmployee.findAll();
        if (list.isEmpty()){
            System.err.println("Ko co phan tu");
        }else {
            System.out.println("Danh sach nhan vien :");
            list.forEach(Employee::displayData);
        }
    }
    protected static void displayAllEmployeeSortByName(){
        List<Employee> list = designEmployee.sortByName();
        if (list.isEmpty()){
            System.err.println("Ko co phan tu");
        }else {
            System.out.println("Danh sach nhan vien :");
            list.forEach(Employee::displayData);
        }
    }
    protected static void updateEmployee(Scanner sc){
        System.out.println("Nhap id nhan vien can sua thong tin");
        int id = Integer.parseInt(sc.nextLine());

        Employee employee = designEmployee.findById(id);
        if (employee == null){
            System.err.println("id ko tim thay ");
        }else {
            System.out.println("hien thi thong tin cu");
            employee.displayData();
            System.out.println("Nhap thong tin moi");
            employee.inputData();
            designEmployee.updateEmployee(employee);
            System.out.println("cap nhat thanh cong");
        }
    }


}
