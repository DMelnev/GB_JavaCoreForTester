/**
 * class Main
 *
 * @author Melnev Dmitry
 * @version 2022-03-02
 */
package Lesson_3;

import java.util.Arrays;

public class Main {

    // first exercise.
    public static <T> void changeElements(T[] array, int element1, int element2) {
        try {
            T buf = array[element1];
            array[element1] = array[element2];
            array[element2] = buf;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//first test
        String[] text = {"s", "i", "l", "t"};
        changeElements(text, 0, 2);
        System.out.println(Arrays.toString(text));

//second test
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox3 = new Box();
        Box<Apple> appleBox4 = new Box();
        for (int i = 0; i < 10; i++) {
            orangeBox1.addItem(new Orange());
            if (i > 1) orangeBox2.addItem(new Orange());
            if (i > 3) appleBox3.addItem(new Apple());
            if (i > 5) appleBox4.addItem(new Apple());
        }
        System.out.println("box1 weight " + orangeBox1.getWeight());
        System.out.println("box2 weight " + orangeBox2.getWeight());
        System.out.println("box3 weight " + appleBox3.getWeight());
        System.out.println("box4 weight " + appleBox4.getWeight());
        System.out.println();

        orangeBox1.pourTo(orangeBox2);
        appleBox4.pourTo(appleBox4);

        System.out.println("box1 weight " + orangeBox1.getWeight());
        System.out.println("box2 weight " + orangeBox2.getWeight());
        System.out.println("box3 weight " + appleBox3.getWeight());
        System.out.println("box4 weight " + appleBox4.getWeight());
        System.out.println();

        appleBox4.pourTo(appleBox3);
        System.out.println("box3 weight " + appleBox3.getWeight());
        System.out.println("box4 weight " + appleBox4.getWeight());

        appleBox3.pourTo(appleBox4);
        System.out.println("box3 weight " + appleBox3.getWeight());
        System.out.println("box4 weight " + appleBox4.getWeight());

    }
}


