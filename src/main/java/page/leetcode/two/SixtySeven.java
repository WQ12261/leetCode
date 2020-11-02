package page.leetcode.two;

/**
 * @author 1226134406@qq.com
 * @className SixtySeven
 * @description 67题
 * @time 2020/11/2 11:09
 */
public class SixtySeven {
    //给你两个二进制字符串，返回它们的和（用二进制表示）。
    //输入为 非空 字符串且只包含数字 1 和 0。
    public String addBinary(String a, String b) {

        char[] chars = a.toCharArray();
        char[] chars1 = b.toCharArray();
        if (chars.length>chars1.length){
            return add(chars, chars1);
        }else {
            return add(chars1, chars);
        }

    }

    private String add(char[] c1,char[] c2){
        StringBuilder stringBuilder=new StringBuilder();
        boolean flag=false;
        for (int i=c2.length-1;i>=0;i--){
            if (flag){
                char c = addChar(c1[i], c2[i]);
                char c3 = addChar('1', c);
                stringBuilder.append(c3);
                if (c1[i]=='1'&&c2[i]==1||c=='1'){
                    flag=true;
                }
            }else {
                char c = addChar(c1[i], c2[i]);
                stringBuilder.append(c);
                if (c1[i]=='1'&&c2[i]=='1'){
                    flag=true;
                }
            }
        }
        int index=c1.length-c2.length-1;
        while (index>=0){
            if (flag){
                if (c1[index]=='1'){
                    stringBuilder.append('0');
                }else {
                    stringBuilder.append('1');
                    flag=false;
                }
            }else {
                stringBuilder.append(c1[index]);
            }
            index--;
        }
        if (flag){
            stringBuilder.append('1');
        }

        return stringBuilder.reverse().toString();
    }

    public char addChar(char c1,char c2){
        if (c1=='1'&&c2=='1'){
            return '0';
        }else {
            if (c1==c2){
                return '0';
            }else {
                return '1';
            }
        }
    }

    public static void main(String[] args) {

        SixtySeven sixtySeven=new SixtySeven();
        String s = sixtySeven.addBinary("1111", "111");
        System.out.println(s);
    }

}
