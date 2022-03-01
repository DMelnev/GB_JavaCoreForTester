/**
 * abstract class Fruit
 *
 * @author Melnev Dmitry
 * @version 2022-03-02
 */
package Lesson_3;

public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
