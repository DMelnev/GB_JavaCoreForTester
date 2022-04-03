package Lesson_7;

import java.time.Instant;
import java.util.Date;

public class TempData {
    private double minTemp;
    private double maxTemp;
    private Date date;

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
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

    @Override
    public String toString() {
        return String.format( "%.1f\u00BAC -  %.1f\u00BAC", minTemp,maxTemp);
    }
}
