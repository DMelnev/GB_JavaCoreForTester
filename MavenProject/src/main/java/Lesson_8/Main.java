package Lesson_8;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

        WeatherData weatherData = new WeatherData(cityName);

        RequestSender.getTempForFiveDays(weatherData);
        try {
            DbHandler dbHandler = new DbHandler();
            dbHandler.writeToDB(weatherData);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy ");

        if (weatherData.getList().size() > 0) {
            System.out.println("Weather for next five days in " + cityName);

            for (TempData element : weatherData.getList()) {
                System.out.println(simpleDate.format(element.getDate()) + " " + element);
            }
        }

    }
}