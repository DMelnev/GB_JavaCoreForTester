package Lesson_6;

import okhttp3.*;

import java.io.IOException;

/**
 * Class Lesson_6.Main
 *
 * @author Melnev Dmitriy
 * @version 2022-
 **/

public class Main {
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static void main(String[] args) {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("HTTP")
                .host("gb.ru")
                .addPathSegment("user")
                .addPathSegment("1")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
