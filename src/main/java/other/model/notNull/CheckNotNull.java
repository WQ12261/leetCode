package other.model.notNull;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author 1226134406@qq.com
 * @className CheckNotNull
 * @description
 * @time 2020/12/23 16:35
 */
public class CheckNotNull {
    public String notNull(Object simpleBean, List<String> beanFields, Map<String,Object> map){
        Class<?> beanClass = simpleBean.getClass();
        Field[] fields = beanClass.getFields();

        return null;
    }
    private static String percent(BigDecimal min, BigDecimal max) {
        if (max == null || BigDecimal.ZERO.equals(max)) {
            max = new BigDecimal(1);
        }
        BigDecimal decimal = min.multiply(new BigDecimal(100));
        BigDecimal bigDecimal = decimal.divide(max, 2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString() + "%";
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(percent(new BigDecimal("0.069"), new BigDecimal(2)));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        String string="<?xml version=\"1.0\" encoding=\"UTF-8\"?><data><account><user>JiuJanng</user><pwd>d9TeP2PCtTNeNMK4qAPaxQ==+2021-04-16 00:01:40</pwd><enctype>0</enctype></account><msg><webserv>POUND_ZHB</webserv><prop value=\"beginTime\">2021-04-15 23:46:40</prop><prop value=\"endTime\">2021-04-16 00:01:40</prop></msg></data>";
        String string1="<?xml version=\"1.0\" encoding=\"UTF-8\"?><data><account><user>JiuJanng</user><pwd>d9TeP2PCtTNeNMK4qAPaxQ==+2021-04-16 00:01:40</pwd><enctype>0</enctype></account><msg><webserv>POUND_ZHB</webserv><prop value=\"beginTime\">2021-04-15 23:46:40</prop><prop value=\"endTime\">2021-04-16 00:01:40</prop></msg></data>";
        System.out.println(string.equals(string1));
    }


}
