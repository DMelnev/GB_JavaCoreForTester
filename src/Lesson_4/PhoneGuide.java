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

        if (list.containsKey(name)) {
            for (String n : numbers) {
                list.get(name).addNumber(n);
            }
        } else {
            list.put(name, new Numbers(numbers));
        }
    }
}
