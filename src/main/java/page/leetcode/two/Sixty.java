package page.leetcode.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 60. 排列序列
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 提示：
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sixty {
    //错误的
    public String getPermutation(int n, int k) {
        int[] value=new int[n];
        while (n>=1){
            value[n-1]=n;
            n--;
        }
        Map<String,Object> countMap=new HashMap<>();
        countMap.put("count", 0);
        StringBuilder stringBuilder=new StringBuilder();
        fullSort(value, 0, k,countMap, stringBuilder);
        return (String) countMap.get("result");
    }
    private void fullSort(int[] numbers, int start, int k, Map<String,Object> countMap, StringBuilder stringBuilder){
        Integer count = (Integer) countMap.get("count");
        if (count.compareTo(k)>=0){
            return;
        }
        if (start== numbers.length){
            System.out.println(stringBuilder.toString());
            count+=1;
            countMap.put("count", count);
            if (count==k){
                countMap.put("result", stringBuilder.toString());
            }
        }else{
            for (int i = start; i< numbers.length; i++){
                swap(start, i, numbers);
                stringBuilder.append(numbers[start]);
                fullSort(numbers, start+1, k, countMap, stringBuilder);
                swap(start, i, numbers);
                stringBuilder.setLength(stringBuilder.length()-1);
            }
        }
    }
    private void swap(int a,int b,int[] numbers){
        int number=numbers[a];
        numbers[a]=numbers[b];
        numbers[b]=number;
    }

    private void fullSort(int [] numbers,int start,int end,StringBuilder stringBuilder){
        if (start>end){
            System.out.println(stringBuilder);
            return;
        }
        for (int i=start;i<=end;i++){
            swap(start, i, numbers);
            stringBuilder.append(numbers[start]);
            fullSort(numbers, start+1,end, stringBuilder);
            swap(start, i, numbers);
            stringBuilder.setLength(stringBuilder.length()-1);
        }
    }
    public static void main(String[] args) {
        Sixty sixty=new Sixty();
        int[] numbers=new int[]{1,2,3};
        sixty.fullSort(numbers, 0, numbers.length-1, new StringBuilder());
    }

}
