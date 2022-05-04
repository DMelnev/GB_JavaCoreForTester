package Lesson_5;

/**
 * enum Encoding
 *
 * @author Melnev Dmitry
 * @version 2022-02-
 */

public enum Encoding {

    WINDOWS1251("windows-1251"),
    UTF8("UTF-8"),
    UTF16("UTF-16"),
    KOI8R("KOI8-R");

    private final String charset;

    Encoding(String charset) {
        this.charset = charset;
    }

    public String getCharset() {
        return charset;
    }
}