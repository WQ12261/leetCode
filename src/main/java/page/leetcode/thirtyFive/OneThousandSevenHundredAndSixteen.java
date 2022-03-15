package page.leetcode.thirtyFive;

public class OneThousandSevenHundredAndSixteen {
    public static int totalMoney(int n) {
        int mod = n % 7;
        int circle = n / 7;
        return circle * 28 + (mod + 1) * mod/2 + (circle - 1) * circle * 7/2 + mod * circle;

    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
    }
}
