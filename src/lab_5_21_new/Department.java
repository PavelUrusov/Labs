package lab_5_21_new;

import java.util.ArrayList;
import java.util.Arrays;

public class Department {

    private ArrayList<BasePost> _employees;

    public Department(BasePost... basePosts){
        _employees = new ArrayList<>(Arrays.stream(basePosts).toList());
    }


    public ArrayList<BasePost> get_employees() {
        return _employees;
    }
}
