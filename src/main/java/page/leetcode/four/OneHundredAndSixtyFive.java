package page.leetcode.four;

public class OneHundredAndSixtyFive {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int minLength = Math.min(version1Array.length, version2Array.length);
        int index = 0;
        while (index < minLength) {
            int one = Integer.parseInt(version1Array[index]);
            int two = Integer.parseInt(version2Array[index]);
            if (one > two) {
                return 1;
            } else if (one < two) {
                return -1;
            }
            index++;
        }
        if (version1Array.length > version2Array.length) {
            return nextIsNotZero(index, true, version1Array);
        }else if (version1Array.length < version2Array.length){
            return nextIsNotZero(index, false, version2Array);
        }
        return 0;
    }

    public int nextIsNotZero(int index, boolean isVersionOneArray, String[] versionArray) {
        while (index < versionArray.length) {
            int i = Integer.parseInt(versionArray[index]);
            if (i != 0) {
                return isVersionOneArray ? 1 : -1;
            }
            index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        OneHundredAndSixtyFive oneHundredAndSixtyFive = new OneHundredAndSixtyFive();
        System.out.println(oneHundredAndSixtyFive.compareVersion("1.0", "1.0.0"));
    }

}
