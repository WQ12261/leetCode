package page.leetcode.one;


/**
 *@className ThirtyThree  第33题
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/12 13:58
 *@version
 */
public class ThirtyThree {
    /**
     *@description: search方法是
     *
     *@param: [nums, t假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/12 14:00
     */
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    /**
     *@description:  假定数组中没有重复值
     *@param: [nums, target, left, right]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/13 13:14
     */
    public int search(int[]nums,int target,int left,int right){

        if (left>right||left<0||right>=nums.length){
            return -1;
        }

        if (nums[left]<nums[right]){//如果数组从左到右都有序
            return binarySearch(nums, target, left, right);
        }else {
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return mid;
            }else {

                if (nums[mid]>nums[left]||mid==left){//从left到mid是有序的
                    if (nums[mid]>target&&nums[left]<=target){
                        return binarySearch(nums, target, left, mid-1);
                    }else {
                        return search(nums, target, mid+1, right);
                    }
                }else {//从mid到right是有序的
                    if (nums[mid]<target&&nums[right]>=target){
                        return binarySearch(nums, target, mid+1, right);
                    }else {
                        return search(nums, target, left, mid-1);
                    }
                }
            }
        }
    }

    public int binarySearch(int[] nums,int target,int left,int right){

        while (left<=right&&left>=0&&right<nums.length){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={10,11,12,3};
        ThirtyThree thirtyThree=new ThirtyThree();
        int search = thirtyThree.search(arr, 3);
        System.out.println(search);
    }
}
