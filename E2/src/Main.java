import Controller.EmployeeController;
import Entity.Department;
import Entity.Employee;
import Entity.Gender;
import Service.EmployeeService;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Department> departments = new HashSet<>();
        Set<Employee> employees = new HashSet<>();


        departments.add(new Department(1, "IT"));
        departments.add(new Department(2, "Maketting"));
        departments.add(new Department(3, "Tester"));


        List<Department> departmentsList = new ArrayList<>(departments);


        EmployeeService employeeService = new EmployeeService(employees);
        EmployeeController employeeController = new EmployeeController(employeeService);

        employees.add(new Employee(1, "Nguyễn Văn A", departmentsList.get(0), LocalDate.of(1990, 5, 14), Gender.F, "Hà Nội"));
        employees.add(new Employee(2, "Trần Thị B", departmentsList.get(1), LocalDate.of(1992, 3, 22), Gender.M, "Hà Nội"));
        employees.add(new Employee(3, "Lê Văn C", departmentsList.get(2), LocalDate.of(1991, 8, 30), Gender.M, "Hà Nội"));
        employees.add(new Employee(4, "Phạm Thị D", departmentsList.get(0), LocalDate.of(1989, 12, 5), Gender.F, "Đà Nẵng"));
        employees.add(new Employee(5, "Ngô Văn E", departmentsList.get(1), LocalDate.of(1995, 1, 15), Gender.M, "TP. Hồ Chí Minh"));

        System.out.println("Search");
        Set<Employee> searchResults = employeeController.searchByName("IT");
        searchResults.forEach(System.out::println);

        Map<String, Set<Employee>> groupedByDepartment = employeeController.groupByDepartmentName();
        System.out.println("Group By Department Name: ");
        groupedByDepartment.forEach((deptName, empSet) -> {
            System.out.println("Department Name: " + deptName);
            empSet.forEach(System.out::println);
        });

        System.out.println("Total Employees By Department: ");
        Map<String, Long> coutEmployeeByDepartmentName = employeeController.countTotalEmployees();
        coutEmployeeByDepartmentName.forEach((departmentName, employeeCount) -> {
            System.out.println(departmentName + ": " + employeeCount);
        });
    }
}
