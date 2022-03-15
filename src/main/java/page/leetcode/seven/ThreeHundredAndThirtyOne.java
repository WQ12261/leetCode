package page.leetcode.seven;

public class ThreeHundredAndThirtyOne {
    public static boolean isValidSerialization(String preorder) {
        if (preorder.equals("")) {
            return true;
        } else if (preorder.equals("#")) {
            return false;
        }
        String[] split = preorder.split(",");
        int i = checkSerialization(split, 0);
        return i == split.length - 1;
    }

    /**
     * 递归遍历数组，模拟组建一颗二叉树
     */
    private static int checkSerialization(String[] nodeValues, int currentIndex) {
        if (nodeValues[currentIndex].equals("#")) {//空节点
            return currentIndex; //空节点没有左右子节点，
        }
        currentIndex++;
        if (currentIndex >= nodeValues.length) {
            return currentIndex;
        }
        currentIndex = checkSerialization(nodeValues, currentIndex);//去当前节点的左节点
        currentIndex++;
        if (currentIndex >= nodeValues.length) {
            return currentIndex;
        }
        return checkSerialization(nodeValues, currentIndex);//去当前节点的右节点
    }

    public static void main(String[] args) {
        String string = "9,3,#,#,#";
        System.out.println(isValidSerialization(string));
    }
}
