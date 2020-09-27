package page.search;

/**
 * @author 1226134406@qq.com
 * @ClassName BinarySearch
 * @description TODO
 * @time 2020/8/26 15:06
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array={1,6,9,10,12,15,18};
        System.out.println(hasValue(array, -1, 0, array.length-1));
    }
    public static boolean hasValue(int[] array, int value,int start,int end) {
        int left=start;
        int right=end;
        int medium=(right+left)/2;
        while (left<right){

            if (array[medium]==value){
                return true;
            }else if(array[medium]>value){
                right=medium-1;
                medium=(right+left)/2;
            }else {
                left=medium+1;
                medium=(right+left)/2;
            }
        }
        return false;
    }
}
