package page.leetcode.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NinetySeven {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int [] charCount=new int[26];
        addCount(s1.toCharArray(), charCount,true);
        addCount(s2.toCharArray(), charCount,true);

        System.out.println(Arrays.toString(charCount));
        for (int count:charCount){
            if (count!=0){
                return false;
            }
        }

        return true;
    }
    private static void addCount(char[] chars,int[] charCount,boolean add){
        for (char c:chars) {
            int index=(int)c-(int)'a';
            if (add){
                charCount[index]=charCount[index]+1;
            }else {
                charCount[index]=charCount[index]-1;
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        /*String string = "a ";
        String substring = string.substring(0, string.length() - 1);

        System.out.println(substring);
        StringBuilder stringBuilder=new StringBuilder("aaaaa;");
        System.out.println(stringBuilder.substring(0,(stringBuilder.length()-1)).toString());
        *//*String str= "18810403871";
        System.out.println(Integer.parseInt(str));*//*
        String s=null;


        BigDecimal bigDecimal1=new BigDecimal(10);
        System.out.println(bigDecimal1.add(BigDecimal.ZERO));

        System.out.println(Long.valueOf("124"));

        System.out.println("aa;aaa;a");
        System.out.println("aa;aaa;a".replaceAll("aaa", ""));
        System.out.println("aa;aaaT".replaceAll("aaaz", "").replaceAll(";;",";"));
        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(" ".getBytes()));
        System.out.println(Arrays.toString(" ".getBytes()));
        System.out.println("aa;aaa;a".substring(0, "aa;aaa;a".lastIndexOf(";")));
        System.out.println("aa;aaa;a".substring("aa;aaa;a".lastIndexOf(";")+1, "aa;aaa;a".length()));
        System.out.println(Arrays.toString("aa;aaa;a".split(";")));*/

        Calendar calendar=Calendar.getInstance();
        Date time1 = calendar.getTime();
        calendar.add(Calendar.SECOND, -30);
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));
        System.out.println(simpleDateFormat.format(time1));
    }
    private static Date localDateToDate(LocalDate localDate,String format) throws ParseException {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        String localDateString = localDate.format(fmt);
        return simpleDateFormat.parse(localDateString);
    }
}
