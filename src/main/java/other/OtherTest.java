package other;

import page.common.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *@className OtherTest
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/26 22:36
 *@version
 */
public class OtherTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        CompletableFuture.runAsync(()->{
            System.out.println("hell");
        });

        System.out.println(list);
    }
}
