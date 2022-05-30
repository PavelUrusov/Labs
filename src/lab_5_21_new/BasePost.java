package lab_5_21_new;

public abstract class BasePost {
    private DepartmentPost _departmentPost;
    private String _fullName;
    public DepartmentPost get_departmentPost() {
        return _departmentPost;
    }

    public void set_departmentPost(DepartmentPost _departmentPost) {
        this._departmentPost = _departmentPost;
    }

    public String get_fullName() {
        return _fullName;
    }

    public void set_fullName(String _fullName) {
        this._fullName = _fullName;
    }

    @Override
    public String toString() {
        return "FullName: " + _fullName + "| Post: " + _departmentPost.toString();
    }
}
