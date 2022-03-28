package Lesson_5;

import java.util.Scanner;

/**
 * class parserCSV
 *
 * @author Melnev Dmitry
 * @version 2022
 */
public class ParserCSV {

    public AppData stringToData(String string) {
        Scanner scanner = new Scanner(string);
        AppData data = new AppData();

        //first line is header
        String next = scanner.nextLine().trim();
        if (next.equals("")) return null;
        String[] arrHeader = next.split(";");
        data.setHeader(arrHeader);
        int length = arrHeader.length;

        //body
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine().trim();
            if (nextLine.equals("")) continue;
            String[] array = nextLine.split(";");
            data.setData(array);
        }
        return data;
    }

    public String dataToString(AppData data) {
        return null;
    }
}
