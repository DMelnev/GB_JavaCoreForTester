package Lesson_9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> group = new ArrayList<>();
        List<Course> stream = new ArrayList<>();
        stream.add(new Course("Biology"));
        stream.add(new Course("Geography"));
        stream.add(new Course("History"));
        stream.add(new Course("Literature"));
        stream.add(new Course("Chemistry"));
        stream.add(new Course("Botany"));
        stream.add(new Course("Physics"));
        stream.add(new Course("Computer Science"));

        group.add(new Student("Ivanov", {}));

    }
}
