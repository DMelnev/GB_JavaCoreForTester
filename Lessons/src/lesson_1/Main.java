/**
 * class Main
 *
 * implementation of running competitions with barriers
 *
 * @author Melnev Dmitry
 * @version 2022-02-24
 */
package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Course c = new Course("First", new ArrayList<>(Arrays.asList(12,13,10,8,18,16)));
        Team team = new Team("Dream");
        team.addMember(new Member("Poll Barry",28,19,20));
        team.addMember(new Member("Shone Risen",25,18,19));
        team.addMember(new Member("Ivan Schultz",22,21,16));
        team.addMember(new Member("Khan Solo",26,17,17));
        team.addMember(new Member("Jorge Lanky",25,16,23));

        c.doIt(team);
        team.showResults();
    }
}
