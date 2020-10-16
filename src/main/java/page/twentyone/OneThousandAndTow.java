package page.twentyone;

import java.util.*;

/**
 *@className OneThousandAndTow
 *@description 第1002题 来自LeetCode:https://leetcode-cn.com/problems/find-common-characters/
 *@author 1226134406@qq.com
 *@time 2020/10/14 8:54
 *@version
 */
public class OneThousandAndTow {
    /**
     *@description: commonChars方法是:给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-common-characters
     *@param: [A]
     *@retrun: java.util.List<java.lang.String>
     *@auther: 1226134406@qq.com
     *@date: 2020/10/14 8:57
     */
    public List<String> commonChars(String[] A) {
        int[] flag=new int[26];
        int min=A[0].length();
        int index=0;
        Map<Character,Integer> map=new HashMap<>();
        for (char c:A[0].toCharArray()){
            Integer integer = map.get(c);
            if (integer==null){
                integer=1;
            }else {
                integer++;
            }
            map.put(c, integer);
        }
        for (int i=1;i<A.length;i++){
            Map<Character,Integer> temporary=new HashMap<>();
            for (char c:A[i].toCharArray()){
                if (map.containsKey(c)) {
                    Integer integer = temporary.get(c);
                    if (integer==null){
                        integer=1;
                    }else {
                        integer++;
                        Integer count = map.get(c);
                        integer=integer<count? integer:count;
                    }
                    temporary.put(c, integer);
                }
            }
            map=temporary;
        }
        List<String> list=new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            while (value>0){
                list.add(key.toString());
                value--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        OneThousandAndTow oneThousandAndTow=new OneThousandAndTow();
        List<String> list = oneThousandAndTow.commonChars(new String[]{"cool","lock","cook"});
        System.out.println(list);
    }
}
