package Lesson_5;

/**
 * class Main
 *
 * @author Melnev Dmitry
 * @version 2022
 */

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
        else System.out.println("Файл "+FILE_NAME_RESULT + " успешно сохранен.");

    }
}
