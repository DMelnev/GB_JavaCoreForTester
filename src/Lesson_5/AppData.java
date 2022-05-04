package Lesson_5;

/**
 * class AppData
 *
 * @author Melnev Dmitry
 * @version 2022-02-
 */

import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data = null;
    private int position = 0;
    private int columns = 0;

    public int getPosition() {
        return position;
    }

    public AppData() {
        position = 0;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String... header) {
        columns = header.length;
        data = new int[16][columns];
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(String... data) {
        if (this.data == null) return;
        checkLines();
        try {
            this.data[position++] = Arrays.stream(data)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    private void checkLines() {
        if (data == null) return;
        int lngth = data.length;
        if (position - 1 >= lngth) {
            int[][] temp = new int[lngth * 2][columns];
            for (int i = 0; i < position; i++) {
                for (int j = 0; j < columns; j++) {
                    temp[i][j] = data[i][j];
                }
            }
            data = temp;
        }
    }
}
