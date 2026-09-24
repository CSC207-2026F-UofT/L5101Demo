package org.example;

public abstract class Person {
    private String name;

    protected Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getId();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " +
                name + ", id=" + getId();
    }
}
