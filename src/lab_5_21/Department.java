package lab_5_21;

public class Department {
    private Department(){}
    public Department(DepartmentPosts ... Employees){
        _employees = Employees.clone();
        return;
    }
    private DepartmentPosts[] _employees;

    public DepartmentPosts[] GetEmployees() {
        return _employees;
    }
    public int CountTeachers(){
        var counter = 0;
        for(int i = 0;i < _employees.length;++i){
            if(_employees[i] == DepartmentPosts.Teacher)++counter;
        }
        return counter;
    }
}
