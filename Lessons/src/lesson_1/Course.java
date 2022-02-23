/**
 * class Course
 *
 * @author Melnev Dmitry
 * @version 2022-02-24
 */
package lesson_1;

import java.util.*;
import java.util.stream.Collectors;

public class Course {
    private String name;
    private ArrayList<Integer> barriers = new ArrayList<>();

    public Course(String name, ArrayList<Integer> barriers) {
        this.name = name;
        this.barriers = barriers;
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBarrier(int height) {
        barriers.add(height);
    }

    public void delBarrier(int number) {
        barriers.remove(number);
    }

    public void doIt(Team team) {
        HashSet<Member> list = team.getTeam();

        for (Member person : list) {
            person.setResult(true);
        }

        for (int barrier : barriers) {
            for (Member person : list) {
                if (person.getJumpHeight() < barrier) {
                    person.setResult(false);
                }
            }
        }

        ArrayList<Member> sorted = new ArrayList<>(list.stream()
                .filter(Member::isResult)
                .sorted()
                .collect(Collectors.toList()));

        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).setPlace(i + 1);
            list.add(sorted.get(i));
        }
    }
}
