package binary;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BinaryUtil {
    public static String intToBinary(int a){
        return Integer.toBinaryString(a);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(intToBinary(7));
        String dateString="2020-03-15";
        String[] split = dateString.split("-");
        LocalDate localDate=LocalDate.of(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        LocalDate localDate1 = localDate.plusDays(1);
        String string = localDate1.toString();
        System.out.println(string);

        System.out.println(LocalDateTime.now());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat1.parse(dateString);
        String dateString1="2020-03-15 23:59:59";
        Date parse1 = simpleDateFormat.parse(dateString1);
        System.out.println(simpleDateFormat.format(parse));
        System.out.println(simpleDateFormat.format(parse1));

        StringBuilder stringBuilder=new StringBuilder("a,");
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder);

        System.out.println(Integer.MAX_VALUE);
    }
}
