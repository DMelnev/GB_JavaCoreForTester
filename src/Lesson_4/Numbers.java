/**
 * class Numbers
 *
 * @author Melnev Dmitry
 * @version 2022
 */
package Lesson_4;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class Numbers {
    private ArrayList<String> numbers = new ArrayList<>();

    public Numbers(String... number) {
        for (String n : number)
            numbers.add(n);
    }

    public void addNumber(String... number) {
        for (String i : number)
            numbers.add(i);
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n");
        for (String i : numbers) {
            result.append(i).append("\n");
        }
        return result.toString();
    }
}
