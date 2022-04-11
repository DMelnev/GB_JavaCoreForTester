package Lesson_9;

import java.util.ArrayList;
import java.util.List;

public class Student{
    private String name;
    private ArrayList<Course> courses;

    public Student(String name, ArrayList<Course> courses) {
        this.name = name;
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
