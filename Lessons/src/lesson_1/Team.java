/**
 * class Team
 *
 * @author Melnev Dmitry
 * @version 2022-02-
 */
package lesson_1;

import java.util.ArrayList;
import java.util.HashSet;

public class Team {
    private String name;
    HashSet<Member> list = new HashSet<>();

    public Team(String name, HashSet<Member> list) {
        this.name = name;
        this.list = list;
    }
    public Team(String name){
        this.name = name;
    }

    public void addMember(Member member){
        list.add(member);
    }
    public void delMember(Member member){
        list.remove(member);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
