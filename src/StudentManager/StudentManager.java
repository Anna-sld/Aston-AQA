package StudentManager;
import Student.Student;

import java.util.Iterator;
import java.util.Set;

public class StudentManager {

    public static void removeLowPerformingStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            student.promoteStudent();
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\nСтуденты на " + course + " курсе:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
