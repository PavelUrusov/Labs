package lab_5_21;

public class Academy {
    private Department[] _departments;
    public Academy(Department ... Departments){
        this._departments = new Department[Departments.length];
        for(int i = 0;i < _departments.length;++i){
            _departments[i] = new Department(Departments[i].GetEmployees());
        }
    }

    public Department[] GetDepartments() {
        return _departments;
    }

    public void SortAcademy(){
        QuickSortFlats(0, _departments.length - 1);
    }
    private void QuickSortFlats(int leftBorder, int rightBorder){
        var leftMarker = leftBorder;
        var rightMarker = rightBorder;
        var pivot = _departments[(leftMarker + rightMarker) / 2];
        do {
            while (_departments[leftMarker].CountTeachers() < pivot.CountTeachers()) {
                leftMarker++;
            }
            while (_departments[rightMarker].CountTeachers() > pivot.CountTeachers()) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    var tmp = _departments[leftMarker];
                    _departments[leftMarker] = _departments[rightMarker];
                    _departments[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            QuickSortFlats(leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            QuickSortFlats(leftBorder, rightMarker);
        }
    }

    public void PrintAcademy(){
        for(int i = 0; i < _departments.length;++i){
            var emps = _departments[i].GetEmployees();
            System.out.println("Department[" + i + "]");
            for(int j = 0;j < emps.length;++j){
                System.out.print("[" + emps[j] + "]");
            }
            System.out.println();
        }
    }
}

