import java.util.Scanner;

class Employee{
    int empId;
    String name;
    String department;

    Employee(int empId, String name, String department){
        this.empId=empId;
        this.name=name;
        this.department=department;
    }

    void display(){
        System.out.printf("Employee details: \nEmpID:%d \t Name:%s \t Department:%s ",this.empId, this.name, this.department);
    }

    double calculateSalary(){
        return 0.0;
    }
}

class FullTimeEmployee extends Employee{
    double basicSalary;
    double bonus;
    FullTimeEmployee(int empId, String name, String department, double basicSalary, double bonus){
        super(empId, name, department);
        this.basicSalary=basicSalary;
        this.bonus=bonus;
    }

    FullTimeEmployee(Employee emp,double basicSalary, double bonus){
        super(emp.empId, emp.name, emp.department);
        this.basicSalary=basicSalary;
        this.bonus=bonus; 
    }

    double calculateSalary(){
        return this.basicSalary + this.bonus;
    }
}
class PartTimeEmployee extends Employee{
    double hoursWorked;
    double hourlyRate;
    PartTimeEmployee(int empId, String name, String department ,double hoursWorked, double hourlyRate){
        super(empId, name, department);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    
    PartTimeEmployee(Employee emp ,double hoursWorked, double hourlyRate){
        super(emp.empId, emp.name, emp.department);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    double calculateSalary(){
        return this.hoursWorked*this.hourlyRate;
    }
}
public class lab3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter number of employees");
        int totalEmployee=sc.nextInt();

        Employee[] employees=new Employee[totalEmployee];

        for(int i=0;i<totalEmployee;i++){
           System.out.println("\n Enter Details for Employee " + (i + 1));
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            Employee emp = new Employee(id, name, dept);

            System.out.println("\nSelect Employment Type:");
            System.out.println("1. Full-Time Employee");
            System.out.println("2. Part-Time Employee");
            System.out.println("3. Base Employee");
            System.out.print("Enter choice (1-3): ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Basic Salary: ");
                double basic = sc.nextDouble();
                System.out.print("Enter Bonus: ");
                double bonus = sc.nextDouble();

                emp = new FullTimeEmployee(emp, basic, bonus);

            } else if (choice == 2) {
                System.out.print("Enter Hours Worked: ");
                double hours = sc.nextDouble();
                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();

                emp = new PartTimeEmployee(emp, hours, rate);
            }

            employees[i] = emp;

        }

        System.out.println("\n ALL EMPLOYEE DETAILS ");
        for (int i = 0; i < employees.length; i++) {
            employees[i].display();
            System.out.print("\t Salary: "+ employees[i].calculateSalary());
        }

        sc.close();
    }
}
