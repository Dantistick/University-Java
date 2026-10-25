package Lab2.Employee;

public class EmployeeTest {

    static void main() {

        Employee employee1 = new Employee(
                "Alexei",
                "Zaicico",
                10000
        );

        Employee employee2 = new Employee(
                "Valera",
                "Zabornii",
                1200
        );

        System.out.println(
                employee1.getFirstName() + " " +
                        employee1.getLastName() +
                        " годовая зарплата: " +
                        employee1.getMonthlySalary() * 12
        );

        System.out.println(
                employee2.getFirstName() + " " +
                        employee2.getLastName() +
                        " годовая зарплата: " +
                        employee2.getMonthlySalary() * 12
        );

        employee1.setMonthlySalary(
                employee1.getMonthlySalary() * 1.10
        );

        employee2.setMonthlySalary(
                employee2.getMonthlySalary() * 1.10
        );

        System.out.println();

        System.out.println(
                employee1.getFirstName() + " " +
                        employee1.getLastName() +
                        " годовая зарплата после повышения: " +
                        employee1.getMonthlySalary() * 12
        );

        System.out.println(
                employee2.getFirstName() + " " +
                        employee2.getLastName() +
                        " годовая зарплата после повышения: " +
                        employee2.getMonthlySalary() * 12
        );
    }
}