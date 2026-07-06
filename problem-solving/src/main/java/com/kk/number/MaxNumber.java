package com.kk.number;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxNumber {
    public static void main(String[] args) {
        List<Employee> list = Stream.iterate(new Employee("E1", 100, "D1"), emp -> {
            long salary = emp.getSalary() + 1;
            return new Employee("E".concat(String.valueOf(salary)), salary, "D".concat(String.valueOf(salary)));
        }).limit(100).collect(Collectors.toList());
        Employee employee = getEmpMaxSalary(list);
        System.out.println(employee);
    }

    static Employee getEmpMaxSalary(List<Employee> list) {
        return list.stream()
                .max(Comparator.comparingLong(Employee::getSalary))
                .orElse(null);
    }
}

class Employee {
    private String name;
    private long salary;
    private String dept;

    public Employee(String name, long salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", dept='" + dept + '\'' + '}';
    }
}
