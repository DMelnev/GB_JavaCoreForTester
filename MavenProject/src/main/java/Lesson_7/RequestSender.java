package Lesson_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class Lesson_7.Main
 *
 * @author Melnev Dmitriy
 * @version 2022-
 **/

public class RequestSender {
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static final String API_KEY = "5lG1vkfM5xGuyaM74tQTYAz4eOk8Omel";
    public static final String SCHEME = "HTTP";
    public static final String HOST = "dataservice.accuweather.com";

    static ArrayList<TempData> getTempForFiveDays(int cityID) {

        ArrayList<TempData> list = new ArrayList<>();
        if (cityID < 0) return list;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(String.valueOf(cityID))
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String str = Objects.requireNonNull(response.body()).string();

            for (int i = 0; i < 5; i++) {
                TempData element = new TempData();
                element.setDate(
                        objectMapper.readTree(str)
                                .at("/DailyForecasts")
                                .get(i)
                                .at("/Date")
                                .asText());
                element.setMinTemp(
                                objectMapper.readTree(str)
                                        .at("/DailyForecasts")
                                        .get(i)
                                        .at("/Temperature/Minimum/Value")
                                        .asDouble()
                        );
                element.setMaxTemp(
                                objectMapper.readTree(str)
                                        .at("/DailyForecasts")
                                        .get(i)
                                        .at("/Temperature")
                                        .at("/Maximum")
                                        .at("/Value")
                                        .asDouble()
                        );
                element.setDayPhrase(
                        objectMapper.readTree(str)
                                .at("/DailyForecasts")
                                .get(i)
                                .at("/Day")
                                .at("/IconPhrase")
                                .asText()
                );
                list.add(element);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return list;
    }

    static int getCityID(String cityName) {

        int cityID = -1;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        boolean res;
        try {
            Response response = okHttpClient.newCall(request).execute();
            String str = Objects.requireNonNull(response.body()).string();
            try {
                if (objectMapper.readTree(str)
                        .at("/Code")
                        .isEmpty()) {
                    System.out.println(objectMapper.readTree(str)
                            .at("/Message")
                            .asText());
                }

            } catch (IOException e) {
//                e.printStackTrace();
            }

            cityID = Integer.parseInt(
                    objectMapper.readTree(str)
                            .get(0)
                            .at("/Key")
                            .asText());

        } catch (IOException | NullPointerException e) {
            System.out.println("Sorry. City \"" + cityName + "\" is not found.");
        }
        return cityID;
    }

//    private static double fahrengeitToCelsius(String fahren) {
//        return ((Double.parseDouble(fahren) - 32) / 1.8);
//    }
}
