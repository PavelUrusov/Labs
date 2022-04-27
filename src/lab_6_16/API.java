package lab_6_16;

import java.util.ArrayDeque;
import java.util.Scanner;

public class API {
    private String _input = new String();
    private Company _company = new Company("Google",Employee.TestInitialize());
    private Scanner _in = new Scanner(System.in);

    public void Run(){
        System.out.println("Employee management interface. To view commands, type \"help\"");
        while(true){
            _input = _in.nextLine();
            switch (_input){
                case "show":{
                    API.PrintEmployees(_company.GetEmployees());
                    break;
                }
                case "add":{
                    System.out.print("Enter your full name through spaces (Urusov Pavel Ivanovich): ");
                    var fullName = _in.nextLine();
                    System.out.print("Enter your address through spaces (Yuzhnaya 20 102): ");
                    var Address = _in.nextLine();
                    if(_company.AddEmployee(CreateEmployee(fullName,Address))){
                        System.out.println("Successfully");
                        break;
                    }
                    System.out.println("Failed");
                    break;

                }
                case "delete":{
                    System.out.print("Enter Employee ID: ");
                    var id = _in.nextInt();
                    if(_company.DeleteEmployee(id)){
                        System.out.println("Successfully");
                        break;
                    }
                    System.out.println("Failed: Id not found");
                    break;
                }
                case "sort":{
                    System.out.print("Enter the street to sort(Yuzhnaya): ");
                    var street = _in.next();
                    API.PrintEmployees(Employee.SortByName(_company.FindByStreet(street)));
                    break;

                }
                case "help":{
                    System.out.println("show - employee screening");
                    System.out.println("add - creation and adding of the new employee to the company");
                    System.out.println("delete - deleting of the employee to the company");
                    System.out.println("exit - close the application");
                    break;
                }
                case "exit":{
                    System.out.println("Completion of the programme...");
                    return;
                }
                default:{
                    System.out.println("Unknown command type \"help\" to view commands");
                    break;
                }
            }
        }

    }

    private Employee CreateEmployee(String fullname,String address){

        var parsedFullname = Employee.ParseFullName(fullname);
        if(parsedFullname == null)
            throw new RuntimeException("Invalid format fullname");
        var parsedAddress = Address.ParseAddress(address);
        if(parsedAddress == null)
            throw new RuntimeException("Invalid format address");

        return new Employee(parsedFullname[0],parsedFullname[1],parsedFullname[2],new Address(parsedAddress[0],parsedAddress[1],parsedAddress[2]));
    }

    private static void PrintEmployees(ArrayDeque<Employee> employees){
        for (var emp:employees) {
            System.out.println("Employee FullName:" + emp.GetFullName(false) +" Employee Id: "
                    +  emp.GetUniqueId() + ",address: " + emp.GetAddress().GetAddress());
        }
    }
}
