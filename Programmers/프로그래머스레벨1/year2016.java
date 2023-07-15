package 프로그래머스레벨1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

// 레벨1 - 2016년
public class year2016 {
    public static void main(String[] args) {
        int a  =5;
        int b = 24;

        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();         
        String answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
        answer = answer.toUpperCase();
        System.out.println(answer); 
    }
}
