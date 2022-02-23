/**
 * class Member
 *
 * @author Melnev Dmitry
 * @version 2022-02-24
 */
package lesson_1;

public class Member extends Human implements Comparable<Member> {
    private int place = 0;
    private boolean result = false;

    public Member(String name, int age, int speed, int jumpHeight) {
        super(name, age, speed, jumpHeight);
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public int compareTo(Member o) {
        return (o.getSpeed() - this.getSpeed());
    }

    @Override
    public String toString() {
        return "Member " +
                "name ='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ((this.isResult()) ? (", place=" + this.getPlace()) : " not finished");
    }
}
