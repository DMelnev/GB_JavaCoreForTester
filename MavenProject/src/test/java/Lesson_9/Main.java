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
                        new Course("Botany"),
                        new Course("Chemistry"),
                        new Course("Physics")
                ))));
        group.add(new Student("Petrov",
                new ArrayList<>(List.of(
                        new Course("History"),
                        new Course("Computer Science")
                ))));
        group.add(new Student("Sidorov",
                new ArrayList<>(List.of(
                        new Course("Literature"),
                        new Course("Biology"),
                        new Course("Chemistry"),
                        new Course("Computer Science")
                ))));
        group.add(new Student("Suslov",
                new ArrayList<>(List.of(
                        new Course("Biology"),
                        new Course("Botany")
                ))));
        group.add(new Student("Pechkin",
                new ArrayList<>(List.of(
                        new Course("Geography")
                ))));
        group.add(new Student("Pontryagin",
                new ArrayList<>(List.of(
                        new Course("Literature"),
                        new Course("Chemistry"),
                        new Course("Computer Science")
                ))));

        System.out.println(getStream(group).size());
        System.out.println(getBestsStudents(group));
        System.out.println(getSpecificStudents(group, new Course("Botany")));

    }

    static List<Course> getStream(List<Student> list) {
        List<Course> result = new ArrayList<>();
        for (Student student : list) {
            result.addAll(student.getAllCourses());
        }
        return result.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    static List<Student> getBestsStudents(List<Student> list) {
        ArrayList<Student> result = new ArrayList<>(list);
        return result.stream()
                .sorted((a, b) -> b.getAllCourses().size() - a.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    static List<Student> getSpecificStudents(List<Student> list, Course course) {
        ArrayList<Student> result = new ArrayList<>(list);
        return result.stream()
                .filter((a) -> {
                    for (Course e : a.getAllCourses()) {
                        if (e.equals(course)) return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
