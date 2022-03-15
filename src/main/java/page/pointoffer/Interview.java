package page.pointoffer;

import java.util.Arrays;

public class Interview {
    public static void main(String[] args) {
        String s = "a,2,a,1,g,1,3,5,a,y,j,i";
        String[] inputArray = s.split(",");
        int maxGap = 0;
        int[] array = new int[2];
        for (int i = 1; i < inputArray.length; i++) {
            int[] sameCountIndex = getSameCountIndex(inputArray, i - 1, i);
            if (sameCountIndex[1] - sameCountIndex[0] > maxGap) {
                maxGap = sameCountIndex[1] - sameCountIndex[0];
                array = sameCountIndex;
            }
        }
        System.out.println(Arrays.toString(array));
        if (maxGap > 0) {
            System.out.println(s.substring(array[0] * 2, array[1] * 2 + 1));
        }
    }

    private static int[] getSameCountIndex(String[] inputString, int leftIndex, int rightIndex) {
        int numberCount = 0;
        int charCount = 0;
        int[] resultArray = new int[2];
        while (leftIndex >= 0 && rightIndex < inputString.length) {
            if (isNumberString(inputString[leftIndex])) {
                numberCount++;
            } else {
                charCount++;
            }
            if (isNumberString(inputString[rightIndex])) {
                numberCount++;
            } else {
                charCount++;
            }
            if (numberCount == charCount) {
                resultArray[0] = leftIndex;
                resultArray[1] = rightIndex;
            }
            leftIndex--;
            rightIndex++;
        }
        return resultArray;
    }

    private static boolean isNumberString(String s) {
        return s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }
}
