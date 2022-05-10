package Lesson_8;

import java.sql.SQLException;
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
        if (cityName.trim().equals("/")) cityName = "Tula";

        WeatherData weatherData = new WeatherData(cityName);
        if (weatherData.getCityId() < 0) return;
        RequestSender.getTempForFiveDays(weatherData);
        try {
            DbHandler dbHandler = new DbHandler();
            dbHandler.writeToDB(weatherData);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // read from DB

        try {
            DbHandler dbHandler = new DbHandler();
            ArrayList<TempData> result = dbHandler.getFromDB(weatherData.getCityId());
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy ");

            for (TempData element : result) {
                System.out.println(simpleDate.format(element.getDate()) + " " + element);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}