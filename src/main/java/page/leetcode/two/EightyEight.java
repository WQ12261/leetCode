package page.leetcode.two;

/**
 * 88题 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EightyEight {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2==null||nums2.length==0){
            return;
        }
        int indexOne=m-1;
        int indexTwo=n-1;
        int i=m+n-1;
        for (;i>=0&&indexOne>=0&&indexTwo>=0;i--){
            if (nums2[indexTwo]>=nums1[indexOne]){
                nums1[i]=nums2[indexTwo];
                indexTwo--;
            }else {
                nums1[i]=nums1[indexOne];
                indexOne--;
            }
        }
        if (indexTwo!=-1){
            for (int j=0;j<=indexTwo;j++){
                nums1[j]=nums2[j];
            }
        }

    }


}
