package Lesson_8;

import java.time.Instant;
import java.util.Date;

public class TempData {
    private double minTemp;
    private double maxTemp;
    private  String dayPhrase;
    private Date date;

    public void setDayPhrase(String dayPhrase) {
        this.dayPhrase = dayPhrase;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Date.from(Instant.parse(date));
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public String getDayPhrase() {
        return dayPhrase;
    }

    @Override
    public String toString() {

        return String.format("%s%.1f\u00BAC -  %s%.1f\u00BAC %s",
                (minTemp > 0) ? "+" : "",
                minTemp,
                (maxTemp > 0) ? "+" : "",
                maxTemp,
                dayPhrase);
    }
}
