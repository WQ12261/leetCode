package page.leetcode.three;

/**
 * 135. 分发糖果
 */
public class OneHundredAndThirtyFive {
    public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0){
            return 0;
        }
        int [] candies=new int[ratings.length];
        int minIndex=0;
        for (int i=0;i<ratings.length;i++){
            if (i==0){
                candies[i]=1;
            }else {
                if (ratings[i]<=ratings[i-1]){
                    candies[i]=candies[i-1]-1;
                }else {
                    candies[i]=candies[i-1]+1;
                }
            }
        }
        return 1;
    }


}
