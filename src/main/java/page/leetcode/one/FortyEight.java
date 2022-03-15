package page.leetcode.one;

import java.util.*;

/**
 * 48题 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FortyEight {
    public void rotate() {
        long l1 = System.currentTimeMillis();
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0;i<1200000;i++){
            list1.add(i);
        }
        long l5 = System.currentTimeMillis();
        System.out.println("linked耗时："+(l5-l1));
        Map<Integer, List<Integer>> integerListMap1 = daData(list1);
        long l3 = System.currentTimeMillis();
        System.out.println("linked耗时："+(l3-l5));

        long l = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<1200000;i++){
            list.add(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("arrayList耗时："+(l2-l));
        Map<Integer, List<Integer>> integerListMap = daData(list);
        long l4 = System.currentTimeMillis();
        System.out.println("arrayList耗时："+(l4-l2));



    }
    public <T> Map<Integer, List<T>> daData(List<T> list){
        int count = list.size()/65000;
        int yu = list.size() % 65000;
        Map<Integer, List<T>> map = new HashMap<Integer, List<T>>();
        for (int i = 0; i <= count; i++) {
            List<T> subList = new ArrayList<T>();
            if (i == count) {
                map.put(i, list.subList(i * 65000, 65000 * i + yu));
            } else {
                map.put(i, list.subList(i * 65000, 65000 * (i + 1)-1));
            }

        }
        return map;
    }

    public static void main(String[] args) {
        FortyEight fortyEight = new FortyEight();
        fortyEight.rotate();
    }
}
