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
        int column = data.getHeader().length;

        //header
        for (int i = 0; i < column; i++) {
            result.append(data.getHeader()[i]);
            if (i == column - 1) result.append("\n");
            else result.append("; ");
        }
        //body
        try {
            int lengthLine = data.getPosition();
            for (int i = 0; i < lengthLine; i++) {
                for (int j = 0; j < column; j++) {
                    result.append(data.getData()[i][j]);
                    if (j == column - 1) result.append("\n");
                    else result.append("; ");
                }
            }
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
            System.out.println("File Error");
        }
        return result.toString();
    }
}
