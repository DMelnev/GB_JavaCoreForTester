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

public class Main {
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final StringBuilder INDENT = new StringBuilder("    "); //отступ

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
            System.out.println(formatString(Objects.requireNonNull(response.body()).string()));
        } catch (IOException e) {
            e.printStackTrace();
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
                    if ((temp.charAt(i - 1) == '"' || temp.charAt(i - 1) == ']')) {
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
