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

        group.add(new Student("Ivanov",
                new ArrayList<>(List.of(
                        new Course("Biology"),
                        new Course("Geography"),
                        new Course("Chemistry"),
                        new Course("Physics")
                        ))));
        group.add(new Student("Petrov",
                new ArrayList<>(List.of(
                        new Course("History"),
                        new Course("Literature"),
                        new Course("Computer Science")
                ))));
        group.add(new Student("Sidorov",
                new ArrayList<>(List.of(
                        new Course("Literature"),
                        new Course("Geography"),
                        new Course("Chemistry"),
                        new Course("Computer Science")
                ))));
        group.add(new Student("Suslov",
                new ArrayList<>(List.of(
                        new Course("Biology"),
                        new Course("Physics"),
                        new Course("Literature"),
                        new Course("Computer Science")
                ))));
        group.add(new Student("Pechkin",
                new ArrayList<Course>(List.of(
                        new Course("Geography")
                ))));
        group.add(new Student("Tryapkin",
                new ArrayList<>(List.of(
                        new Course("Literature"),
                        new Course("Chemistry"),
                        new Course("Computer Science")
                ))));


    }
}
