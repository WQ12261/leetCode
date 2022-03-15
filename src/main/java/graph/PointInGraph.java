package graph;

public class PointInGraph {
    /**
     * 判断点是否在多边形内，x坐标集合必须对应y坐标集合并且集合的顺序对于多边形角的坐标的顺时针或逆时针顺序
     * 基本思想：过点p [x,y]画一条平行于x轴的直线A，如果点p在多边形内，那么线A会与多边形的边相交，特点是：
     * 在点的右边，线A会与多边形相交奇数次；在点的左边，线A会与多边线相交奇数次
     * 如果点p不在多边形内，特点是：
     * 在点的左边或右边，线A会与多边形相交偶数次（进，出）。0也是偶数
     * 因此：可以设置boolean类型的result，线A在点P的右边与多边形每相交一次就将result=!result。
     *
     * 怎样判断过点p[x,y]并且平行于x轴的直线A回与多边形的一个边相交？
     * 答：直线A的表达式为:Ya = y,设多边形的一个边的两个端点分别为P1[x1,y1],P2[x2,y2]
     * 如果直线A与点P1与P2组成的线段相交，则：y>y1&&y<=y2||y>y2&&y<=y1
     *
     * 怎样判断点过点p[x,y]并且平行于x轴的直线A与P1[x1,y1],P2[x2,y2]组成的线段的交点是位于点p[x,y]的左边还是右边？
     * 答：设直线A与P1[x1,y1],P2[x2,y2]组成的线段的交点为P3[x3,y]
     * 则有：(x3-x1)/(y-y1)=(x2-x1)/(y2-y1)即 x3=x1+(x2-x1)/(y2-y1)*(y-y1)
     * 如果x3>x,则交点P3[x3,y]在点p[x,y]的右边，
     * 如果x3=x,则交点P3[x3,y]与点p[x,y]重合
     * 如果x3<x,则交点P3[x3,y]在点p[x,y]的左边
     *
     * @param x 点x坐标
     * @param y 点的y坐标
     * @param xArray 多边形各个角的点的x坐标集合
     * @param yArray 多边形各个角的点的y坐标集合，必须和x坐标相对应
     * @return true：点在多边形内；false：点不在多边形内
     */
    public static boolean isPointInGraph(double x, double y, double[] xArray, double[] yArray) {
        int size = xArray.length;
        boolean result = false;
        for (int i=0,j=size-1;i<size;i++){
            if (yArray[i]<y&&yArray[j]>=y
                ||yArray[j]<y&&yArray[i]>=y){
                if (xArray[i]+(y-yArray[i])/(yArray[j]-yArray[i])*(xArray[j]-xArray[i])<x){
                    result=! result;
                }
            }
            j=i;
        }

        return result;
    }
}
