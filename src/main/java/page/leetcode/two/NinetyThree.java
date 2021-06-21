package page.leetcode.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 93题 复原ip地址
 */
public class NinetyThree {
    /**
     * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
     *
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        if (s!=null&&isCorrectLength(0, s.length(), 4)){
            restoreIpAddresses(s, 4, 0, "", list);
        }
        return list;
    }
    public void restoreIpAddresses(String str,int count,int startIndex,String s,List<String> list){
        if (count==0){
            return;
        }

        if (count==1){
            String substring=str.substring(startIndex);
            if (inUnSingedByteRange(substring)){
                String string=s+substring;
                list.add(string);
            }
        }else{
            for(int i=1;i<=3&&(i+startIndex<str.length());i++){
                String substring = str.substring(startIndex, startIndex + i);
                if (inUnSingedByteRange(substring)){
                    String string=s+substring;
                    string+=".";
                    if (isCorrectLength(startIndex+i, str.length(), count-1)){
                        restoreIpAddresses(str, count-1, startIndex+i, string, list);
                    }
                }
            }
        }

    }
    public boolean inUnSingedByteRange(String str){
        int i = Integer.parseInt(str);
        Integer value=i;
        if (value.toString().length()!=str.length()){
            return false;
        }
        if (i>=0&&i<=255){
            return true;
        }
        return false;
    }
    public boolean isCorrectLength(int left,int right,int minCount){
        int maxCount=minCount*3;
        int length=right-left;
        if (length<minCount||length>maxCount){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NinetyThree ninetyThree=new NinetyThree();
        List<String> list = ninetyThree.restoreIpAddresses("101023");
        System.out.println(list);
    }


}
