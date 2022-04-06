package Lesson_8;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Lesson_8.Main
 *
 * @author Melnev Dmitriy
 * @version 2022-
 **/

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the city:");
        String cityName = scanner.next();

        int cityID = RequestSender.getCityID(cityName);

        ArrayList<TempData> list = RequestSender.getTempForFiveDays(cityID);

        SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy ");

        if (list.size() > 0) {
            System.out.println("Weather for next five days in " + cityName);

            for (TempData element : list) {
                System.out.println(simpleDate.format(element.getDate()) + " " + element);
            }
        }

    }
}