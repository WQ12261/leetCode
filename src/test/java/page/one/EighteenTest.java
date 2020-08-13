package page.one;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author 1226134406@qq.com
 * @description
 * @create 2020/8/13 21:54
 */
public class EighteenTest {
    private Eighteen eighteen;
    @Before
    public void beforeTest(){
        eighteen=new Eighteen();
    }
    @Test
    public void fourSum() {
        int[] nums={1, 0, -1, 0, -2, 2,3};
        int target=1;
        List<List<Integer>> lists =eighteen.fourSum(nums, target);
        lists.forEach(System.out::println);
    }
}