package page.leetcode.one;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Seventeen {
    private static Map<Character,List<String>> digitsMap=new HashMap<>();
    static {
        digitsMap.put('2', Arrays.asList("a","b","c"));
        digitsMap.put('3',Arrays.asList( "d","e","f"));
        digitsMap.put('4', Arrays.asList("g","h","i"));
        digitsMap.put('5', Arrays.asList("j","k","l"));
        digitsMap.put('6', Arrays.asList("m","n","o"));
        digitsMap.put('7', Arrays.asList("p","q","r","s"));
        digitsMap.put('8',Arrays.asList("t","u","v"));
        digitsMap.put('9', Arrays.asList("w","x","y","z"));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if (digits!=null&&!"".equals(digits)){
            char[] charArray = digits.toCharArray();
            for (char c:charArray){
                List<String> digitList = digitsMap.get(c);
                if (list.size()==0){
                    for (String string:digitList){
                        list.add(string);
                    }
                }else {
                    List<String> resultList=new ArrayList<>();
                    for (String string:list){
                        for (String str:digitList){
                            resultList.add(string+str);
                        }
                    }
                    list=resultList;
                }

            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

}
