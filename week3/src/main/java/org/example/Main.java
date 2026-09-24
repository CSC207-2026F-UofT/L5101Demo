package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Person alice = new Student("Alice", 1234567890);
        people.add(alice);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = readCommand(scanner);
                if (command == null) {
                    break;
                }

                if ("add".equals(command)) {
                    addPerson(scanner, people);
                } else if ("list".equals(command)) {
                    listPeople(people);
                } else {
                    System.out.println("Unknown command. Use add or list.");
                }
            }
        }
    }

    private static String readCommand(Scanner scanner) {
        System.out.print("Command (add/list): ");
        if (!scanner.hasNextLine()) {
            return null;
        }

        return scanner.nextLine().trim().toLowerCase();
    }

    private static void addPerson(Scanner scanner, List<Person> people) {
        String type = readRequiredLine(scanner, "Type (S)tudent/(T)eacher: ");
        String name = readRequiredLine(scanner, "Name: ");

        if ("s".equalsIgnoreCase(type)) {
            int studentNumber = readInt(scanner, "Student number: ");
            people.add(new Student(name, studentNumber));
        } else if ("t".equalsIgnoreCase(type)) {
            String employeeId = readRequiredLine(scanner, "Employee id: ");
            people.add(new Teacher(name, employeeId));
        } else {
            System.out.println("Unknown person type. Use 'S' or 'T'.");
        }
    }

    private static void listPeople(List<Person> people) {
        if (people.isEmpty()) {
            System.out.println("No persons added.");
            return;
        }

        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static String readRequiredLine(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                return "";
            }

            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                return 0;
            }

            String value = scanner.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}