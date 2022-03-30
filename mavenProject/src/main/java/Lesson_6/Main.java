package Lesson_6;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

/**
 * Class Lesson_6.Main
 *
 * @author Melnev Dmitriy
 * @version 2022-
 **/

public class   Main {
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static void main(String[] args) {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("HTTP")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("295212")
                .addQueryParameter("apikey", "5lG1vkfM5xGuyaM74tQTYAz4eOk8Omel")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(Objects.requireNonNull(response.body()).string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
