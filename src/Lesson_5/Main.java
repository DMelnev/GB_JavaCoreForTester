package Lesson_5;

public class Main {
    private final static String FILE_NAME = "file.csv";
    private final static String FILE_NAME_RESULT = "fileResult.csv";


    public static void main(String[] args) {

        AppData data = new AppData();
        ParserCSV parser = new ParserCSV();
        FileWorker.setCharSet(Encoding.UTF8);

        String textFile  = FileWorker.loadFile(FILE_NAME);
        System.out.println(textFile);

        parser.stringToData(textFile);

    }
}
