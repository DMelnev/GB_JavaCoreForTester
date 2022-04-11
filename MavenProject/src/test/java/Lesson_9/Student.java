package Lesson_9;

import java.util.ArrayList;
import java.util.List;

public class Student{
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}
