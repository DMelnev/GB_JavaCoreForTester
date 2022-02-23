/**
 * class Human
 *
 * @author Melnev Dmitry
 * @version 2022-02-
 */
package lesson_1;

public class Human {
    private String name;
    private int age;
    private int speed;
    private int jumpHeight;

    public Human(String name, int age, int speed, int jumpHeight) {
        this.name = name;
        this.age = age;
        this.speed = speed;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSpeed() {
        return speed;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return (getJumpHeight() == human.getJumpHeight()) && (getSpeed() == human.getSpeed());
    }

    @Override
    public int hashCode() {
        int result = getSpeed();
        result = 31 * result + getJumpHeight();
        return result;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
