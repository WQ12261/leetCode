package page.leetcode.eight;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class FourHundredAndFiftyOne {
    public String frequencySort(String s) {
        if (s==null||"".equals(s)){
            return s;
        }
        char[] chars = s.toCharArray();
        int maxCount=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<chars.length;i++){
            Integer count = map.get(chars[i]);
            count=count==null? 1:count+1;
            maxCount=Math.max(count, maxCount);
            map.put(chars[i],count);
        }
        StringBuilder[] stringBuilders=new StringBuilder[maxCount+1];
        Set<Map.Entry<Character, Integer>> entries =map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            StringBuilder builder=stringBuilders[value];
            builder= builder==null? new StringBuilder():builder;
            for (int i=0;i<value;i++){
                builder.append(key.charValue());
            }
            stringBuilders[value]=builder;
        }
        StringBuilder stringBuilder=stringBuilders[maxCount];
        for (int i=maxCount-1;i>=0;i--){
            if (stringBuilders[i]!=null){
                stringBuilder.append(stringBuilders[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FourHundredAndFiftyOne fourHundredAndFiftyOne=new FourHundredAndFiftyOne();
        String string = fourHundredAndFiftyOne.frequencySort("treeasdfa;oirujqepworijfapdsofihjaskrlkasdjhfipd");
        System.out.println(string);
    }
}
