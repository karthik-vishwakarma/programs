package com.kk.structural.flyweight;

import java.util.HashMap;
import java.util.Random;

interface Employee {
    void assignSkill(String skill);

    void task();
}

class Developer implements Employee {

    private final String job;
    private String skill;

    public Developer() {
        job = "Fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with JOB " + job);
    }
}

class Tester implements Employee {

    private final String job;
    private String skill;

    public Tester() {
        job = "Test the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with skill: " + this.skill + " with JOB " + job);
    }
}

class EmployeeFactory {
    private static HashMap<String, Employee> m = new HashMap<>();

    public static Employee getEmployee(String type) {
        Employee p = null;
        if (m.get(type) != null) {
            p = m.get(type);
        } else {
            switch (type) {
                case "Developer":
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("NO SUCH EMPLOYEE");
            }
            m.put(type, p);
        }
        return p;
    }
}

public class Engineering {
    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"JAVA", "C++", ".NET", "PYTHON"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());
            e.assignSkill(getRandSkill());
            e.task();
        }
    }

    private static String getRandSkill() {
        int i = new Random().nextInt(skills.length);
        return skills[i];
    }

    private static String getRandEmployee() {
        int i = new Random().nextInt(employeeType.length);
        return employeeType[i];
    }
}
