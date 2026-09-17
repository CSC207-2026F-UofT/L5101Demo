package org.example;

public class Person {
    public String name;
    public int age;

    public static int count = 0;
    public static final int max = 67;

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.name);
        System.out.println(p.age);
        System.out.println(p);
    }
}
