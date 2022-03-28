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

        if (data == null || data.getHeader().length < 1) return "";
        StringBuilder result = new StringBuilder();
        int length = data.getHeader().length;

        //header
        for (int i = 0; i < length; i++) {
            result.append(data.getHeader()[i]);
            if (i == length - 1) result.append("\n");
            else result.append("; ");
        }
        try {
            for (int i = 0; i < length; i++) {
                int lengthCol = data.getData()[i].length;
                for (int j = 0; j < lengthCol; j++) {
                    result.append(data.getData()[i][j]);
                    if (i == length - 1) result.append("\n");
                    else result.append("; ");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
