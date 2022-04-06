package Lesson_8;

import org.sqlite.JDBC;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DbHandler {
    public static final String DB_PATH = "jdbc:sqlite:javaTest.db";
    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(DB_PATH);
    }

    public void writeToDB(WeatherData weatherData) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "REPLACE INTO CityNames (cityID, cityName) VALUES (?,?)"
        )) {
            preparedStatement.setObject(1, weatherData.getCityId());
            preparedStatement.setObject(2, weatherData.getCityName());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "REPLACE INTO tempData (cityID, date, minTemp, maxTemp, dayPhrase) " +
                        "VALUES (? , ?, ?, ?, ?)"
        )) {
            for (TempData entry : weatherData.getList()) {
                preparedStatement.setObject(1, weatherData.getCityId());
                preparedStatement.setObject(2, simpleDate.format(entry.getDate()));
                preparedStatement.setObject(3, entry.getMinTemp());
                preparedStatement.setObject(4, entry.getMaxTemp());
                preparedStatement.setObject(5, entry.getDayPhrase());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getCityID(String name){
        try(Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(
                    "SELECT cityID FROM CityNames WHERE cityName = '" + name + "'"
            );
            int res = resultSet.getInt("cityID");
            if (res >0) return res;
        }catch (SQLException e){

        }
        return -1;
    }

}
