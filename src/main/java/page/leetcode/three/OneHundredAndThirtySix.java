package page.leetcode.three;

/**
 * @author 1226134406@qq.com
 * @className OneHundredAndThirtySix
 * @description 136题
 * @time 2020/11/20 14:46
 */
public class OneHundredAndThirtySix {
    /**
     *@description: singleNumber方法是 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 考察点:
     * 1. 任何数和0做异或运算得到的值都是自身：a^0=a;
     * 2. 任何数自身做异或运算得到的值都是0：a^a=0;
     * 3. 异或运算满足交换律和接合律：a^b^a=b^a^a=b^(a^a)=b^0=b
     *@param: [nums]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/11/20 14:48
     */
    public int singleNumber(int[] nums) {
        int result=0;
        for (int number:nums){
            result^=number;
        }
        return result;
    }

}
