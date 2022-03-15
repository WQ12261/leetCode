package page.leetcode.five;

import java.util.Arrays;

public class FiveHundredAndThirtySeven {
    public static String complexNumberMultiply(String num1, String num2) {
        int[] number1 = getNumberArray(num1);
        int[] number2 = getNumberArray(num2);
        return calculate(number1, number2);
    }

    public static int[] getNumberArray(String num1) {
        int[] number = new int[2];
        int length = num1.length();
        if (length == 1) {
            if (num1.equals("i")) {
                number[1] = 1;
            } else {
                number[0] = Integer.parseInt(num1);
            }
            return number;
        }
        int i = num1.indexOf('+');

        String firstNumber = num1.substring(0, i);
        String secondNumber = num1.substring(i + 1,length -1);
        number[0] = Integer.parseInt(firstNumber);
        number[1] = Integer.parseInt(secondNumber);
        return number;
    }

    private static String calculate(int[] number1, int[] number2) {
        int realNumber = number1[0] * number2[0] - number1[1] * number2[1];
        int complexNumber = number1[0] * number2[1] + number2[0] * number1[1];
        return realNumber + "+" + complexNumber + "i";
    }

    public static void main(String[] args) {
        String s = "1+-1i";
        System.out.println(Arrays.toString(s.split("\\+|i")));;
        System.out.println(complexNumberMultiply("1+-1i", "0+0i"));
    }


}
