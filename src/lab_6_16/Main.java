package lab_6_16;

//16. Дана очередь данных о работниках фирмы: ФИО и адрес (улица, дом, квартира). Во второй
//массив записать только тех из них, которые живут на улице Красной. Вывести их на экран в алфавитном
//порядке.


import java.util.ArrayDeque;

//menu + use methods sort.
public class Main {
    public static void main(String[] args) {

/*        ArrayDeque<Employee> employees = Employee.TestInitialize();
        Company company = new Company("Google",employees);
        var result = company.FindByStreet("Red");
        var sortedResult = Employee.SortByName(result);
        for (var emp:sortedResult) {
            System.out.println("Employee FullName:" + emp.GetFirstname() +" Employee Id: " +  emp.GetUniqueId() + ",address: " + emp.GetAddress().GetAddress());
        }*/

        var host = new API();
        host.Run();

    }
}
