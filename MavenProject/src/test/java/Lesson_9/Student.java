package Lesson_9;

import java.util.ArrayList;
import java.util.List;

public class Student{
    private String name;
    private ArrayList<Course> courses;

    public Student(String name2, ArrayList<Course> courses) {
        this.name = name2;
        this.courses = courses;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
