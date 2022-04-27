package lab_5_21;


//posts == class

public class Main {
    public static void main(String[] args) {
        var department_1 = new Department(DepartmentPosts.Dean,DepartmentPosts.Teacher,DepartmentPosts.Teacher,
                DepartmentPosts.HeadOfDepartment,DepartmentPosts.HeadOfDepartment,DepartmentPosts.Teacher);

        var department_2 = new Department(DepartmentPosts.Dean,DepartmentPosts.Teacher,DepartmentPosts.Teacher,
                DepartmentPosts.HeadOfDepartment,DepartmentPosts.HeadOfDepartment,DepartmentPosts.Teacher,
                DepartmentPosts.Teacher,DepartmentPosts.Teacher,DepartmentPosts.Teacher);

        var department_3 = new Department(DepartmentPosts.Dean,DepartmentPosts.Teacher,DepartmentPosts.Teacher,
                DepartmentPosts.HeadOfDepartment,DepartmentPosts.HeadOfDepartment,DepartmentPosts.Teacher,
                DepartmentPosts.Teacher);

        var academy = new Academy(department_2,department_1,department_3);
        academy.PrintAcademy();
        System.out.println("SortedAcademy");
        academy.SortAcademy();
        academy.PrintAcademy();

    }
}
