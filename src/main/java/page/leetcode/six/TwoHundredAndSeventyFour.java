package page.leetcode.six;


import java.util.Arrays;

public class TwoHundredAndSeventyFour {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 1;
        for (; count <= citations.length; count++) {
            if (citations[citations.length - count] < count) {
                break;
            }
        }
        return count - 1;
    }

    public static int hIndex2(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        System.out.println(Arrays.toString(counter));
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arrays = {3,0,6,1,5};
        System.out.println(hIndex(arrays));
        System.out.println(hIndex2(arrays));
    }
}
