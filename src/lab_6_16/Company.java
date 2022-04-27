package lab_6_16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

//menu
public class Company {


    private Company(){}
    private ArrayDeque<Employee> _employees = new ArrayDeque<Employee>();
    private String _title;

    public Company(String title, ArrayDeque<Employee> employees){
        _title = title;
        _employees = employees;
    }
    public Company(String title){
        _title = title;
    }

    public void AddEmployees(Employee ... employees)
    {
        for(int i = 0; i < employees.length;++i){
            _employees.add(employees[i]);
        }
    }
    public ArrayDeque<Employee> FindByStreet(String street){
        var emps = new ArrayDeque<Employee>();
        for (var emp : _employees)
        {
            if(emp.GetAddress().GetStreet().equals(street)){
                emps.add(emp.Clone());
            }
        }
        return  emps;
    }

    public Employee FindById(int id){
        for (var emp : _employees)
        {
            if(emp.GetId() == id){
                return emp;
            }
        }
        return null;
    }

    public ArrayDeque<Employee> GetEmployees() {
        return _employees;
    }
    public boolean AddEmployee(Employee employee){
        if(employee != null){
            _employees.add(employee);
            return true;
        }
        return false;
    }

    public boolean DeleteEmployee(int id){
        return _employees.remove(FindById(id));
    }
}
