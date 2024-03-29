package page.leetcode.one;

import java.util.*;

/**
 * @author 1226134406@qq.com
 * @className FortyNine
 * @description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @time 2020/11/20 13:44
 */
public class FortyNine {
    /**
     *@description: groupAnagrams方法是
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *@param: [strs]
     *@retrun: java.util.List<java.util.List<java.lang.String>>
     *@auther: 1226134406@qq.com
     *@date: 2020/11/20 13:46
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists=new ArrayList<>();
        if (strs==null||strs.length==0){
            return lists;
        }else {
            Map<String,List<String>> map=new HashMap<>();
            for (String string:strs){
                char[] chars = string.toCharArray();
                Arrays.sort(chars);
                String s=new String(chars);
                if (!map.containsKey(s)){
                    List<String> list=new ArrayList<>();
                    list.add(string);
                    lists.add(list);
                    map.put(s, list);
                }else {

                    List<String> list = map.get(s);
                    list.add(string);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

}
