package lab_6_16;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {

    private static int _idCounter = 1;

    private int _id;
    private String _firstname;
    private String _lastname;
    private String _surname;
    private Address _address;


    public Employee(String surname, String firstname, String lastname, Address address){
        _firstname = firstname;
        _surname = surname;
        _lastname = lastname;
        _address = address.Clone();
        _id = _idCounter++;

    }

    public Address GetAddress() {
        return _address;
    }

    public String GetFirstname(){
        return _firstname;
    }

    public String GetLastname() {
        return _lastname;
    }

    public String GetSurname() {
        return _surname;
    }
    public Employee Clone(){
        var emp = new Employee(_surname,_firstname,_lastname,_address.Clone());
        emp._id = this._id;
        return emp;
    }

    public static ArrayDeque<Employee> TestInitialize(){
        ArrayDeque<Employee> employees = new ArrayDeque<>();

        employees.add(new Employee("firstname_1","surname_1","lastname_1",
                new Address("street_1","house_1","flat_1")));
        employees.add( new Employee("firstname_2","surname_2","lastname_2",
                new Address("Red","house_2","flat_2")));
        employees.add(new Employee("firstname_3","surname_3","lastname_3",
                new Address("street_3","house_3","flat_3")));
        employees.add(new Employee("firstname_4","surname_4","lastname_4",
                new Address("street_4","house_4","flat_4")));
        employees.add(new Employee("firstname_5","surname_5","lastname_5",
                new Address("street_5","house_5","flat_5")));
        employees.add(new Employee("firstname_6","surname_6","lastname_6",
                new Address("Red","house_6","flat_6")));
        employees.add(new Employee("firstname_7","surname_7","lastname_7",
                new Address("street_7","house_7","flat_7")));
        employees.add(new Employee("firstname_11","surname_11","lastname_11",
                new Address("Red","house_11","flat_11")));
        employees.add(new Employee("firstname_9","surname_9","lastname_9",
                new Address("Red","house_9","flat_9")));
        employees.add(new Employee("firstname_10","surname_10","lastname_10",
                new Address("street_10","house_10","flat_10")));
        employees.add( new Employee("firstname_11","surname_11","lastname_11",
                new Address("Red","house_11","flat_11")));
        employees.add(new Employee("firstname_12","surname_12","lastname_12",
                new Address("street_12","house_12","flat_12")));
        employees.add(new Employee("firstname_13","surname_13","lastname_13",
                new Address("Red","house_13","flat_13")));
        employees.add(new Employee("firstname_14","surname_14","lastname_14",
                new Address("street_14","house_14","flat_14")));
        employees.add(new Employee("firstname_15","surname_15","lastname_15",
                new Address("Red","house_15","flat_15")));
        return employees;
    }
    public int GetUniqueId(){
        return _id;
    }
    public String GetFullName(boolean toLoweCase){
        if(toLoweCase){
            return new String(_surname + " " + _firstname + " " + _lastname).toLowerCase(Locale.ROOT);
        }
        return new String(_surname + " " + _firstname + " " + _lastname);

    }

    public static ArrayDeque<Employee> SortByName(ArrayDeque<Employee> employees){
        return employees.stream().sorted(Comparator.comparing(Employee::GetFirstname)).collect(Collectors.toCollection(ArrayDeque::new));
    }

    public static String[] ParseFullName(String fullname){
        var result = fullname.split(" ");
        if(result.length == 3){
            return result;
        }
        return null;
    }

    public int GetId() {
        return _id;
    }
}
