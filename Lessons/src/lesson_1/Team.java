/**
 * class Team
 *
 * @author Melnev Dmitry
 * @version 2022-02-24
 */
package lesson_1;

import java.util.HashSet;

public class Team {
    private String name;
    private HashSet<Member> list = new HashSet<>();

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

    public HashSet<Member> getTeam(){
        return list;
    }
    public void showResults(){
        list.stream()
                .filter(Member::isResult)
                .sorted()
                .forEach(System.out::println);
        list.stream()
                .filter(s->!s.isResult())
                .forEach(System.out::println);
    }
}
