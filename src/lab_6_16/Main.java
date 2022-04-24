package lab_6_16;

//16. Дана очередь данных о работниках фирмы: ФИО и адрес (улица, дом, квартира). Во второй
//массив записать только тех из них, которые живут на улице Красной. Вывести их на экран в алфавитном
//порядке.

public class Main {
    public static void main(String[] args) {

        Employee[] employees = Employee.TestInitialize();

        Company company = new Company("Google",employees);
        var result = company.FindByStreet("Red");
        for (var emp:result) {
            System.out.println("Employee Id: " +  emp.GetUniqueId() + ",address: " + emp.GetAddress().GetAddress());
        }

    }

}
