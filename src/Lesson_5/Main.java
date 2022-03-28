package Lesson_5;

import java.io.File;
import java.io.IOException;

public class Main {
    private final static String FILE_NAME = "file.csv";
    private final static String FILE_NAME_RESULT = "fileResult.csv";


    public static void main(String[] args) {

        AppData data;
        ParserCSV parser = new ParserCSV();
        FileWorker.setCharSet(Encoding.UTF8);

        String textFile = FileWorker.loadFile(FILE_NAME);

        System.out.println("\nfile: " + FILE_NAME);
        System.out.println(textFile);

        data = parser.stringToData(textFile);
        String result = parser.dataToString(data);

        System.out.println("\ndata: ");
        System.out.println(result);

        if (!FileWorker.saveFile(result, FILE_NAME_RESULT))
            System.out.println("Не удалось записать в файл!");

    }
}
