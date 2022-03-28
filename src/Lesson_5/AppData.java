package Lesson_5;

public class AppData {
    private String[] header;
    private int[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String... header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(String... data) {
        try{

        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }
}
