package DivideAndConquer;

/**
 *@className TowerOfHanol
 *@description 分支算法：汉诺塔
 *@author 1226134406@qq.com
 *@time 2020/10/18 20:40
 *@version
 */
public class TowerOfHanoi {
    public void move(char a,char b,char c,int plates){
        if (plates<=0){//如果没有盘子或者盘子小于0直接返回
            return;
        }else if (plates==1){//如果a上只有一个盘子就直接移动到c上
            System.out.println(a+"→"+c);
        }else {
            //如果a上有2个或以上的盘子就先借助c,将plates-1个盘子移动到b上
            move(a, c, b, plates-1);
            //将plates-1个盘子从a移动到b上之后就将a上的这最后的一个盘子移动到c上
            System.out.println(a+"→"+c);
            //这时将b上的plates-1一个盘子借助a,移动到c上
            move(b, a, c,plates-1);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi=new TowerOfHanoi();
        towerOfHanoi.move('a', 'b', 'c', 4);
    }

}
