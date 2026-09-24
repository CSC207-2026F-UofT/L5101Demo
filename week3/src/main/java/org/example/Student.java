package org.example;

public class Student extends Person {
    private final int studentNumber;

    public Student(String name, int studentNumber) {
        super(name);
        this.studentNumber = studentNumber;
    }

    @Override
    public String getId() {
        return Integer.toString(studentNumber);
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void study() {
        System.out.println(getName() + " is studying.");
    }
}
