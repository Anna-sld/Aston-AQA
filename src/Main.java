import Student.Student;
import StudentManager.StudentManager;
import PhoneBook.PhoneBook;
import java.util.HashSet;
import java.util.Set;

import static StudentManager.StudentManager.printStudents;
import static StudentManager.StudentManager.promoteStudents;

public class Main {
    public static void main(String[] args) {
        newStudent();
        phoneBook();
    }

    public static void newStudent() {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Анна Солодкова", "Группа 1", 1, new int[]{5, 5, 5}));
        students.add(new Student("Кузнецов Олег", "Группа 2", 2, new int[]{3, 4, 5}));
        students.add(new Student("Осипов Игорь", "Группа 3", 1, new int[]{2, 2, 2}));

        System.out.println("Исходный список студентов:");
        for (Student student : students) {
            System.out.println(student);
        }

        StudentManager.removeLowPerformingStudents(students);

        StudentManager.promoteStudents(students);

        System.out.println("\nСписок студентов после удаления неуспевающих и перевода успешно сдавших:");
        for (Student student : students) {
            System.out.println(student);
        }

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
    }

    public static void phoneBook() {
        PhoneBook  phoneBook = new PhoneBook();
        phoneBook.add("Солодков", "375447775567");
        phoneBook.add("Громыко", "375296188641");
        phoneBook.add("Ковальчук", "375447776657");
        phoneBook.add("Солодков", "375447100876");

        System.out.println("\nТелефонный справочник:");
        phoneBook.printAll();

        System.out.println("\nНомера Солодкова: " + phoneBook.get("Солодков"));
        System.out.println("Номера Громыко: " + phoneBook.get("Громыко"));
        System.out.println("Номера Ковальчука: " + phoneBook.get("Ковальчук"));
    }
}














