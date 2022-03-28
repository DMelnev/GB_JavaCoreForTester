package Lesson_5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data = null;
    private int position = 0;
    private int columns = 0;

    public AppData() {
        position = 0;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String... header) {
        columns = header.length;
        data = new int[columns][16];
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(String... data) {
        if (this.data == null) return;
        checkLines();
        try {
            this.data[++position] = Arrays.stream(data)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    private void checkLines() {
        if (data == null) return;
        int lngth = data[0].length;
        if (position - 1 >= lngth) {
            int[][] temp = new int[columns][lngth * 2];
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < position; j++) {
                    temp[i][j] = data[i][j];
                }
            }
            data = temp;
        }
    }
}
