package lab_6_16;

import java.util.ArrayDeque;
import java.util.Scanner;


public class API {
    private String _input = new String();
    private Company _company = new Company("Google",Employee.TestInitialize());
    private Scanner _in = new Scanner(System.in);

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

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
                    break;

                }
                case "delete":{
                    System.out.print("Enter Employee Id: ");
                    var id = _in.nextLine();
                    int parseId = 0;
                    try {
                        parseId = Integer.parseInt(id);
                    }
                    catch (NumberFormatException e){
                        parseId = -1727382;
                        PrintErrorMessage("Failed: Invalid Id format");
                    }
                    if(_company.DeleteEmployee(parseId)){
                        System.out.println("Successfully");
                        break;
                    }
                    PrintErrorMessage("Failed: Id not found");
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
                    PrintErrorMessage("Unknown command type \"help\" to view commands");
                    break;
                }
            }
        }

    }

    private Employee CreateEmployee(String fullname,String address){

        var parsedFullname = Employee.ParseFullName(fullname);
        if(parsedFullname == null){
            PrintErrorMessage("Failed: Invalid format fullname");
            return null;
        }
        var parsedAddress = Address.ParseAddress(address);
        if(parsedAddress == null){
            PrintErrorMessage("Failed: Invalid format address");
            return null;
        }
        return new Employee(parsedFullname[0],parsedFullname[1],parsedFullname[2],new Address(parsedAddress[0],parsedAddress[1],parsedAddress[2]));
    }

    private static void PrintEmployees(ArrayDeque<Employee> employees){
        for (var emp:employees) {
            System.out.println("Employee FullName:" + emp.GetFullName(false) +" Employee Id: "
                    +  emp.GetUniqueId() + ",address: " + emp.GetAddress().GetAddress());
        }
    }
    private void  PrintErrorMessage(String message){
        System.out.println(ANSI_RED+message+ANSI_RESET);
    }
}
