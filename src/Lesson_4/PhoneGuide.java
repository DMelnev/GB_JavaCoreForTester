/**
 * class PhoneGuide
 *
 * @author Melnev Dmitry
 * @version 2022
 */
package Lesson_4;

import java.util.HashMap;

public class PhoneGuide {
    private String name;
    private HashMap<String, Numbers> list = new HashMap<>();

    public Numbers get(String name) {
        return list.get(name);
    }

    public void add(String name, String... numbers) {
        Numbers number;
        if (list.containsKey(name)) {
            number = list.get(name);
            for (String n : numbers) {
                number.addNumber(n);
            }
        } else {
            number = new Numbers(numbers);
            list.put(name, number);
        }
    }
}
