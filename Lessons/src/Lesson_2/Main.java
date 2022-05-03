/**
 * class Main
 *
 * @author Melnev Dmitry
 * @version 2022-02-28
 */
package Lesson_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String[][]> list = new ArrayList<>();
        list.add(new String[][]{{"1", "1", "2", "3"},
                {"15", "1", "2", "3"},
                {"12", "1", "2", "3"},
                {"1", "1", "2", "3"}});
        list.add(new String[][]{{"1", "2", "3"},
                {"15", "1", "2", "3"},
                {"12", "1", "2", "3"},
                {"1", "1", "2", "3"}});
        list.add(new String[][]{{"1", "1", "2", "3"},
                {"15", "1", "2", "3"},
                {"12", "1", "2", "3"}});
        list.add(new String[][]{{"0", "1", "2", "3"},
                {"15", "1", "a", "3"},
                {"12", "1", "2", "3"},
                {"1", "1", "2", "3"}});
        list.add(new String[0][0]);
        list.add(new String[][]{{"0", "0", "0", "0"},
                {"15", "1", "2", "3"},
                {"12", "1", "2", "3"},
                {"0", "0", "0", "0"}});

        int i = 1;
        for (String[][] array : list) {
            System.out.println("Result " + (i++) + "\n");

            try {
                System.out.println(sum(array));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static int sum(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Array length is not correct");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Element \"" + array[i][j] + "\" array["
                            + i + "][" + j + "] is bad format.");
                }
            }
        }
        return sum;
    }
}
