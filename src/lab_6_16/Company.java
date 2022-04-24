package lab_6_16;

import java.util.ArrayList;
import java.util.List;

public class Company {


    private Company(){}
    private List<Employee> _employees = new ArrayList<Employee>();
    private String _title;

    public Company(String title,Employee ... employees){
        _title = title;
        AddEmployees(employees);
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
    public List<Employee> FindByStreet(String street){
        var emps = new ArrayList<Employee>();
        for (var emp : _employees)
        {
            if(emp.GetAddress().GetStreet() == street){
                emps.add(emp.Clone());
            }
        }
        return  emps;
    }
}
