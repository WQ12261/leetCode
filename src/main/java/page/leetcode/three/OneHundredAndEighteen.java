package page.leetcode.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class OneHundredAndEighteen {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists=new ArrayList<>();
        if (numRows>0){
            List<Integer> list=new ArrayList<>();
            list.add(1);
            lists.add(list);
             while (numRows>1){
                 List<Integer> currList=new ArrayList<>();
                 currList.add(1);
                 for (int i=1;i<list.size();i++){
                     currList.add(list.get(i)+list.get(i-1));
                 }
                 currList.add(1);
                 list=currList;
                 lists.add(list);
                 numRows--;
             }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
}
