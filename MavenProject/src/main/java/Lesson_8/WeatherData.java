package Lesson_8;

import java.util.ArrayList;

public class WeatherData {
    private String cityName;
    private int cityId;
    private ArrayList<TempData> list;

    public WeatherData(String cityName) {
        this.cityName = cityName;
        this.cityId = RequestSender.getCityID(cityName);
        list = new ArrayList<>();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public ArrayList<TempData> getList() {
        return list;
    }

    public void setList(ArrayList<TempData> list) {
        this.list = list;
    }
}
