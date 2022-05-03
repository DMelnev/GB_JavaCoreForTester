/**
 * Class Main
 *
 * @author Melnev Dmitriy
 * @version 2022-
 **/
package Lesson_4;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//        exercise one:

        ArrayList<String> list = new ArrayList<>();
        list.add("it");
        list.add("is");
        list.add("a");
        list.add("good");
        list.add("day");
        list.add("this");
        list.add("day");
        list.add("is");
        list.add("a");
        list.add("nice");
        list.add("gorges");
        list.add("day");
        list.add("expect");
        list.add("us");
        list.add("how");
        list.add("nice");
        list.add("is");
        list.add("the");
        list.add("fish");
        list.add("good");
        list.add("good");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : list) {
            if (map.containsKey(word)) map.replace(word, (map.get(word) + 1));
            else map.put(word, 1);
        }

        System.out.println(map);

//        Exercise two:
        System.out.println();

        PhoneGuide phoneGuide = new PhoneGuide();
        phoneGuide.add("Ivanov", "+7900-080-08-08", "+380500-25-46");
        phoneGuide.add("Petrov", "+7900-080-07-07");
        phoneGuide.add("Suvorov", "+7900-080-06-06", "+380502-78-89", "+38087878787");
        phoneGuide.add("Vasin", "+7910-222-02-22", "+38050230-32-56");

        System.out.println("Ivanov " + phoneGuide.get("Ivanov"));
        System.out.println("Petrov " + phoneGuide.get("Petrov"));
        System.out.println("Suvorov " + phoneGuide.get("Suvorov"));
        System.out.println("Vasin " + phoneGuide.get("Vasin"));

        phoneGuide.add("Petrov", "+7900-080-06-06", "+380502-78-89", "+38087878787");
        System.out.println("Petrov " + phoneGuide.get("Petrov"));


    }
}
