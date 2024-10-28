package Controller;

import Entity.Employee;
import Service.EmployeeService;

import java.util.Map;
import java.util.Set;

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Set<Employee> searchByName(String name) {
        return employeeService.searchByName(name);
    }

    public Map<String, Set<Employee>> groupByDepartmentName() {
        return employeeService.groupByDepartmentName();
    }

    public Map<String, Long> countTotalEmployees() {
        return employeeService.countTotalEmployees();
    }
}
