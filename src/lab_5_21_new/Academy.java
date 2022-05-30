package lab_5_21_new;

import java.util.ArrayList;
import java.util.Arrays;

public class Academy {
    private ArrayList<Department> _departments;

    public Academy(Department... departments){
        _departments = new ArrayList<>(Arrays.stream(departments).toList());
    }

    public Academy(ArrayList<BasePost> basePosts){
        var amountDeans = AmountPost(basePosts,DepartmentPost.Dean);
        var amountChair = AmountPost(basePosts,DepartmentPost.Chair);
        var amountTeachers = AmountPost(basePosts,DepartmentPost.Teacher);

    }

    private long AmountPost(ArrayList<BasePost> basePosts,DepartmentPost post){
       return basePosts.stream().filter(e->e.get_departmentPost() == post).count();
    }
}
