package page.leetcode.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class OneHundredAndNineteen {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        if (rowIndex>=0){
            list.add(1);
            while (rowIndex>0){
                int pre=0;
                for (int i=1;i<list.size();i++){
                    if (i==1){
                        pre=1;
                    }
                    int curr=list.get(i);
                    int value=pre+curr;
                    list.set(i, value);
                    pre=curr;
                }
                list.add(1);
                rowIndex--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
