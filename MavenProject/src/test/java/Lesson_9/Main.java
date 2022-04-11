package Lesson_9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> group = new ArrayList<>();

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
                        new Course("Botany"),
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

        System.out.println(getStream(group).size());

    }
    static List<Course> getStream(List<Student> list){
        List<Course> result = new ArrayList<>();
        for (Student student : list){
            result.addAll(student.getAllCourses());
        }
        return result.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
