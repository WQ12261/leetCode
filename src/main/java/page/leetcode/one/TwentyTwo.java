package page.leetcode.one;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class TwentyTwo {
    public List<String> generateParenthesis(int n) {
        return null;
    }
    public void add(StringBuilder stringBuilder,int a,int b){

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

    }
    private static String path(){
        LocalDate localDate=LocalDate.now();
        int year = localDate.getYear();
        int monthValue = localDate.getMonthValue();
        int dayOfMonth = localDate.getDayOfMonth();
        return year+"/"+monthValue+"/"+dayOfMonth;
    }

    private static List<String> listInfo(String string, String sql){
        String[] split = string.split("\n");
        List<String> list=new ArrayList<>();
        for (String str:split){
            String[] s = str.split(" ");
            String format = String.format(sql, s[0], s[1]+" "+s[2]);
            list.add(format);
        }
        return list;
    }

    private static String combinSql(List<String> list ){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i));
            if (i != list.size()-1){
                stringBuilder.append("\n union \n");
            }
        }
        stringBuilder.append(";");
        return stringBuilder.toString();
    }

    public static  String selectById(){
        String s="'13238'\n" +
                "'14310'\n" +
                "'15955'\n" +
                "'15956'\n" +
                "'15958'\n";
        String[] split = s.split("\n");
        String sql = "select * from t_deliver_info where id in (";
        StringBuilder stringBuilder=new StringBuilder(sql);
        for (int i=0;i<split.length;i++){
            stringBuilder.append(split[i].substring(1,split[i].length()-1));
            if (i!=split.length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    private static List<String> dateList(String startTime,String endTime){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start=LocalDate.parse(startTime,fmt);
        LocalDate end=LocalDate.parse(endTime,fmt);
        List<String> list=new ArrayList<>();
        LocalDate st=start;
        while (st.compareTo(end)<=0){
            list.add(st.toString());
            st = st.plusDays(1L);
        }
        return list;
    }







}
