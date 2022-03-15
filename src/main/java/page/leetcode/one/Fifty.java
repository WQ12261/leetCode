package page.leetcode.one;

public class Fifty {
    public  double myPow(double x, int n) {
        boolean ltZero = n < 0;
        boolean min = false;
        if (ltZero) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                min = true;
            } else {
                n = -n;
            }
        }
        double v = positivePow(x, n);
        if (ltZero){
            if (min){
                v=v*x;
            }
            return 1/v;
        }
        return v;
    }
    private double positivePow(double x,int n){
        if (n==0){
            return 1;
        }else if (n==1){
            return x;
        }
        int j = n%2;
        int i = n/2;
        double v = positivePow(x, i);


        if (j==1){
            return v*v*x;
        }else {
            return v*v;
        }

    }

    public static void main(String[] args) {
        Fifty fifty = new Fifty();
        System.out.println(fifty.myPow(2, 2));
    }
}
