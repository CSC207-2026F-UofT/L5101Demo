package org.example;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " (age: " + age + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;
        return other.name.equals(name) && other.age == age;

    }
}
