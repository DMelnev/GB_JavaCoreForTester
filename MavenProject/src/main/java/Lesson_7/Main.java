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
    private static final StringBuilder INDENT = new StringBuilder("    "); //отступ
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

    private static String formatString(String string) {
        StringBuilder temp = new StringBuilder(string);
        StringBuilder tempIndent = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {
            switch (temp.charAt(i)) {
                case '{' -> {
                    temp.insert(i + 1, "\n" + tempIndent);
                    if (i != 0) temp.insert(i, "\n" + tempIndent);
                    i += tempIndent.length() + 1;
                    tempIndent.append(INDENT);
                }
                case '}' -> {
                    if (i < (temp.length() - 1)) {
                        tempIndent = new StringBuilder(tempIndent.substring(INDENT.length()));
                        if (i > 0) temp.insert(i, "\n" + tempIndent);
                        i += tempIndent.length() + ((temp.charAt(i + 1) == ',') ? 2 : 1);
                    }
                }
                case ',' -> {
                    if ((temp.charAt(i - 1) == '"' || (temp.charAt(i + 1) == '"' || temp.charAt(i - 1) == ']'))) {
                        temp.insert(i + 1, "\n" + tempIndent.substring(INDENT.length()));
                    }
                }
                case ']' -> {
                    temp.insert(i, "\n" + tempIndent);
                    i += tempIndent.length() + 1;
                }
            }
        }
        return temp.toString();
    }

}