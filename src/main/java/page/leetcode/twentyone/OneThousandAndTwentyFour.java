package page.leetcode.twentyone;

import array.util.TowDimension;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import page.leetcode.three.OneHundredAndFortyThree;

import javax.naming.PartialResultException;

/**
 * @author 1226134406@qq.com
 * @className OneThousandAndTwentyFour
 * @description 第1024题
 * @time 2020/10/24 13:59
 */
public class OneThousandAndTwentyFour {
    /**
     * @description: videoStitching方法是
     * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一
     * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
     * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
     * 示例 1：
     * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
     * 输出：3
     * 解释：
     * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
     * 然后，按下面的方案重制比赛片段：
     * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
     * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/video-stitching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param: [clips, T]
     * @retrun: int
     * @auther: 1226134406@qq.com
     * @date: 2020/10/24 14:04
     */
    //我想的解决办法时将所有的数组进行排序，但是该方法用时超时
   /* public int videoStitching(int[][] clips, int T) {
        TowDimension towDimension = new TowDimension();
        towDimension.heapSort(clips);
        if (clips[0][0] != 0) {
            return -1;
        }
        int maxIndex = 0;
        int i = 0;
        while (i < clips.length && clips[i][0] == 0) {
            if (clips[i][1] > clips[maxIndex][1]) {
                maxIndex = i;
            }
            i++;
        }
        int count = 1;
        if (clips[maxIndex][1] > T) {
            return count;
        }
        int flag = maxIndex;
        for (; i < clips.length; i++) {


            while (i < clips.length && clips[i][0] >= clips[maxIndex][0] && clips[i][0] <= clips[maxIndex][1]) {
                if (clips[i][1] > clips[flag][1]) {
                    flag = i;
                }
                i++;
            }
            if (clips[flag][0] != clips[maxIndex][0]) {
                count++;
            }
            maxIndex = flag;
            if (clips[maxIndex][1] >= T) {
                return count;
            }
            i = i - 1;
        }

        return -1;
    }*/
    public int videoStitching(int[][] clips, int T) {
        if (T<=0){
            return -1;
        }
        int[]arr=new int[T];
        for (int i=0;i<clips.length;i++){
            if (clips[i][0]<T){
                int index=clips[i][0];
                arr[index]=arr[index]>clips[i][1]? arr[index]:clips[i][1];
            }
        }
        if (arr[0]<=0){
            return -1;
        }
        int count=1;
        int maxIndex=0;
        if (arr[maxIndex]>=T){
            return count;
        }
        int flag=maxIndex;
        for (int i=1;i<T;i++){

            while (i<=arr[maxIndex]&&i<T){
                if (arr[i]>arr[flag]){
                    flag=i;
                }
                i++;
            }
            if (flag==maxIndex){
                return -1;
            }
            count++;
            maxIndex=flag;
            if (arr[maxIndex]>=T){
                return count;
            }
            i--;
        }
        return -1;
    }

    public static void main(String[] args) {
        OneThousandAndTwentyFour thousandAndTwentyFour=new OneThousandAndTwentyFour();
        /*int[] arr1={0,2};
        int[]arr2={4,6};
        int[]arr3={6,10};
        int[]arr4={1,9};
        int[]arr5={1,5};
        int[]arr6={5,9};
        int[][]clips={arr1,arr2,arr3,arr4,arr5,arr6};*/
        int[] arr1={0,4};
        int[]arr2={2,8};
        int[]arr3={2,3};
        int[][]clips={arr1,arr2,arr3};
        int i = thousandAndTwentyFour.videoStitching(clips, 6);
        System.out.println(i);
    }
}
