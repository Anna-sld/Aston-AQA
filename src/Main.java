import Student.Student;
import StudentManager.StudentManager;
import java.util.HashSet;
import java.util.Set;

import static StudentManager.StudentManager.printStudents;
import static StudentManager.StudentManager.promoteStudents;

public class Main {
    public static void main(String[] args) {
        newStudent();
    }

    public static void newStudent () {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Анна Солодкова", "Группа 1", 1, new int[]{5,5,5}));
        students.add(new Student("Кузнецов Олег", "Группа 2", 2, new int[]{3,4,5}));
        students.add(new Student("Осипов Игорь", "Группа 3", 1, new int[]{2,2,2}));

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

}











