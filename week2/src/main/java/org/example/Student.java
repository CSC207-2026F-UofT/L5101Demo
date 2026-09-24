package org.example;

public class Student extends Person {
    private String studentNumber;
    public int test;

    Student(String name, int age, String studentNumber) {
        super(name, age);
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return str + "[stu#: " + studentNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (obj instanceof Student) {
            Student other = (Student) obj;
            return this.studentNumber.equals(other.studentNumber);
        }

        return false;
    }
}
