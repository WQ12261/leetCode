package page.leetcode.four;

public class OneHundredAndSixtyEight {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder=new StringBuilder();
        int remainder;
        while (columnNumber>26){
            remainder =columnNumber%26;
            columnNumber=columnNumber/26;
            if (remainder ==0){
                columnNumber--;
                remainder =26;
            }
            stringBuilder.append(numberToChar(remainder));
        }
        stringBuilder.append(numberToChar(columnNumber));
        return stringBuilder.reverse().toString();
    }
    public char numberToChar(int number){
        return (char) ((int)'A'-1+number);
    }

    public static void main(String[] args) {
        OneHundredAndSixtyEight oneHundredAndSixtyEight=new OneHundredAndSixtyEight();
        System.out.println(oneHundredAndSixtyEight.convertToTitle(754));
    }
}
