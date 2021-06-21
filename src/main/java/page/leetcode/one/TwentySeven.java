package page.leetcode.one;

public class TwentySeven {
    public static int removeElement(int[] nums, int val) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int left=-1;

        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[++left]=nums[i];
            }
        }
        return left+1;
    }

    public static int removeElement2(int[] nums,int val){
        int length=nums.length;
        int b;
        for(int i=0;i<length;i++){
            if(nums[i]==val)
            {
                for(int j=i+1;j<length;j++)
                {
                    b=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=b;
                }
                length--;
                i--;

            }

        }
        return length;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,3,1,2,6,6,1};
        int i = removeElement(array, 1);
        for (int i1 = 0;i1<i;i1++){
            System.out.printf("%d",array[i1]);
        }

    }
}
