package Lesson_9;

import java.util.ArrayList;
import java.util.List;

public class Student2 implements Student {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student2(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
