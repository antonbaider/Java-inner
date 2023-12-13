package jom.com.softserve.s3.task4;


import java.util.Locale;

enum LineType {
     SOLID, DOTTED, DASHED, DOUBLE;

 }
public class Line {

    public static String drawLine(LineType lineType) {
        return "The line is " + lineType.name().toLowerCase(Locale.ENGLISH) + " type";
    }
}
