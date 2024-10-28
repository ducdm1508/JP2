package Service;

import Entity.Department;
import Entity.Employee;
import IGeneric.IGeneral;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeService implements IGeneral<Employee> {
    private Set<Employee> employees;

    public EmployeeService(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Set<Employee> searchByName(String name) {
        return employees.stream()
                .filter(emp -> emp.getDepartment().getName()
                        .toLowerCase()
                        .contains(name.toLowerCase()))
                .collect(Collectors.toSet());
    }
    @Override
    public Map<String, Set<Employee>> groupByDepartmentName() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getDepartment().getName(),
                        Collectors.toSet()
                ));
    }

    @Override
    public Map<String, Long> countTotalEmployees() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        employee ->
                            employee.getDepartment().getName(),
                        Collectors.counting()
                ));
    }

}
