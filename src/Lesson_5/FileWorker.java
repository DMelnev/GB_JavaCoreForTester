package Lesson_5;
/**
 * class fileWorker
 *
 * @author Melnev Dmitry
 * @version 2022
 */

import java.io.*;

public class FileWorker {
    private static final int BUFFER_SIZE = 1024;
    private static Encoding charSet = Encoding.UTF8;

    public static void setCharSet(Encoding charset) {
        charSet = charset;
    }

    public static StringBuilder readFile(String fileName) {
        StringBuilder fileString = new StringBuilder();

        try (InputStream inputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charSet.getCharset());) {
            BufferedReader reader = new BufferedReader(inputStreamReader);
            char[] buffer = new char[BUFFER_SIZE];
            int num = 0;
            while ((num = reader.read(buffer)) != -1) {
                fileString.append(String.valueOf(buffer, 0, num));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileString;
    }


    public static boolean writeFile(String string, String fileName) {

        try (FileOutputStream outputStream = new FileOutputStream(fileName);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charSet.getCharset())) {
            outputStreamWriter.write(string.toString());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}