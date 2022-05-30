package lab_5_21_new;

public class Teacher extends BasePost {
    public Teacher(String fullName){
        set_fullName(fullName);
        set_departmentPost(DepartmentPost.Teacher);
    }

    public Teacher(){

    }

}
