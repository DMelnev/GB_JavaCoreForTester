package Lesson_7;

import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class Lesson_6.Main
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

        System.out.println();
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy ");
        if (list.size() > 0) {
            System.out.println("Weather for next five days in " + cityName);

            for (TempData element : list) {
                System.out.print(simpleDate.format(element.getDate()) + " ");
                System.out.println(element);
            }
        }

    }
}