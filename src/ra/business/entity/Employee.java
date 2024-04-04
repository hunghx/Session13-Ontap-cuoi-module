package ra.business.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Employee implements Serializable { // tuan tu hoa doi tuong
    private int id;
    private String fullName,email,phone,address;
    private LocalDate dob;
    private BigDecimal salary;
    private Gender gender;

    public Employee() {
    }

    public Employee(int id, String fullName, String email, String phone, String address, LocalDate dob, BigDecimal bigDecimal, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.salary = bigDecimal;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void inputData(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten");
        this.fullName = sc.nextLine();
        System.out.println("Nhap email");
        this.email = sc.nextLine();
        System.out.println("Nhap sdt");
        this.phone = sc.nextLine();
        System.out.println("Nhap address");
        this.address = sc.nextLine();
        System.out.println("Nhap ngay sinh");
        while (true){
            try {
                this.dob = LocalDate.parse(sc.nextLine(),dtf);
                break;
            }catch (DateTimeParseException e){
                System.err.println("Dinh dang ko hop le");
            }
        }
        System.out.println("Nhap luong");
        this.salary = new BigDecimal(sc.nextLine());
        System.out.println("Chon gioi tinh");
        System.out.println("1. Nam");
        System.out.println("2. Nu");
        System.out.println("3. Khac");
        while (true){
            System.out.println("Moi ban chon");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice){
                case 1:
                    this.gender = Gender.MALE;
                    break;
                case 2:
                    this.gender = Gender.FEMALE;
                    break;
                case 3:
                    this.gender = Gender.OTHER;
                    break;
                default:
                    System.err.println("nhap ko hop le, nhap lai");;
            }
            if (choice==1||choice==2||choice==3){
                break;
            }
        }
    }

    public void displayData(){
        System.out.printf("|ID : %-3s | Name : %-15s | DOB : %-12s | Salary : %-10s\n",id,fullName,dob.format(DateTimeFormatter.BASIC_ISO_DATE),salary);
    }

}
