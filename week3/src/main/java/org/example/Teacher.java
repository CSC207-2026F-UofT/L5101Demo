package org.example;

public class Teacher extends Person {
    private final String employeeId;

    public Teacher(String name, String employeeId) {
        super(name);
        this.employeeId = employeeId;
    }

    @Override
    public String getId() {
        return employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}