/**
 * class Main
 *
 * @author Melnev Dmitry
 * @version 2022-03-02
 */
package Lesson_3;

public class Main {

    // first exercise.
    public <T> void changeElements(T[] array, int element1, int element2) {
        try {
            T buf = array[element1];
            array[element1] = array[element2];
            array[element2] = buf;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}


