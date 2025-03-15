package Student;

import java.util.Iterator;
import java.util.Set;

public class Student {
    private String name;
    private String group;
    private int course;
    private int[] grades;

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public void promoteStudent() {
        if (getAverageGrade() >= 3) {
            course++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return name + " (Группа: " + group + ", Курс: " + course + ", Средний балл: " + getAverageGrade() + ")";
    }
}

