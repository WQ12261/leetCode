package other;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Read {
    private static String sql = "update %s set owner_customer_name = null, owner_customer_tax_id = null where owner_customer_tax_id = '' or owner_customer_name = '';";
    private static String sql1 = "select * from %s where owner_customer_tax_id = '' or owner_customer_name = '';";
    public static void main(String[] args) {
        File file  = new File("F:\\货权方sql.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\货权方sql.txt");
            InputStreamReader reader = new InputStreamReader(fileInputStream,"utf-8");
            BufferedReader br = new BufferedReader(reader,
                    600 * 1024 * 1024);
            String nextLine = null;
            List<String> list = new ArrayList<>();
            Set<String> set = new HashSet<>();
            while ((nextLine = br.readLine())!= null){

                String tableName = getTableName(nextLine);

                if (!set.contains(tableName)){
                    set.add(tableName);
                    String format = String.format(sql1, tableName);
                    list.add(format);
                }
            }
            System.out.println(set.size());
            list.forEach(System.out::println);
        }catch (Exception e){

        }
    }
    public static String getTableName (String line){
        String string = "ALTER TABLE ";
        String tableName = line.substring(string.length(), line.indexOf("ADD"));
        return tableName;
    }
}
