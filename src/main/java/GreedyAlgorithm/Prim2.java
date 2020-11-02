package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author 1226134406@qq.com
 * @className Prim2
 * @description 该类主要目的是再次练习一下Prim算法，具体请看GreedyAlgorithm.Prim
 * @time 2020/10/31 20:53
 */
public class Prim2 {

    public static MGraph2 getMGraph2(){
        MGraph2 mGraph2=new MGraph2(7);
        char[] vertexName={'A','B','C','D','E','F','G'};
        mGraph2.setVertexName(vertexName);
        mGraph2.put('A', 'B', 5);
        mGraph2.put('A', 'C', 7);
        mGraph2.put('A', 'G', 2);
        mGraph2.put('B', 'D', 9);
        mGraph2.put('B', 'G', 3);
        mGraph2.put('C', 'E', 8);
        mGraph2.put('G', 'E', 4);
        mGraph2.put('G', 'F', 6);
        mGraph2.put('E', 'F', 5);
        mGraph2.put('D', 'F', 4);
        mGraph2.show();
        return mGraph2;
    }
    public static MGraph2 prim(MGraph2 mGraph2){
        MGraph2 mGraph=new MGraph2(mGraph2.getVertex());
        int[][] weight2 = mGraph2.getWeight();

        mGraph.setVertexName(mGraph2.getVertexName());
        int [] mark=new int[mGraph.getVertex()];
        //如果标记为1就是已接通
        //如果标记为0就是还为接通
        //如果标记为2就是不用再修路了
        mark[0]=1;
        int con=1;//已修上路的村子的数量
        int col=0;
        int row=0;
        int min=0;
        while (con<mGraph.getVertex()){
            for (int i=0;i<mark.length;i++){
                boolean flag=true;//标记是否已经都修上路的的标记
                if (mark[i]==1){
                    for (int j=0;j<mGraph.getVertex();j++){
                        //如果j还没有修上路，并且vertexName[i]和vertexName[j]有连接
                        if (mark[j]==0&&weight2[i][j]!=0){
                            flag=false;//还有路没修上
                            if (min==0){
                                col=i;
                                row=j;
                                min=weight2[i][j];
                            }else {
                                if (weight2[i][j]<min){
                                    col=i;
                                    row=j;
                                    min=weight2[i][j];
                                }
                            }
                        }
                    }
                    //都修上路了，下一次就不遍历它了
                    if (flag){
                        mark[i]=2;
                    }
                }
            }
            if (min!=0){
                mark[row]=1;//表示row修上了路
                mGraph.put(col, row, min);
                con++;
                col=0;
                row=0;
                min=0;
            }else {
                break;
            }

        }

        return mGraph;
    }

    private static class  MGraph2{
        //顶点数量
        private int vertex;
        //各个顶点的名字
        char[] vertexName;
        //图的邻接矩阵
        int[][] weight;

        public MGraph2(int vertex) {
            this.vertex = vertex;
            weight=new int[vertex][vertex];
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public char[] getVertexName() {
            return vertexName;
        }

        public void setVertexName(char[] vertexName) {
            this.vertexName = vertexName;
        }

        public int[][] getWeight() {
            return weight;
        }

        public void setWeight(int[][] weight) {
            this.weight = weight;
        }

        public void put(char a,char b,int weg){
            int i=a-'A';
            int j=b-'A';
            weight[i][j]=weg;
            weight[j][i]=weg;
        }

        public void put(int i,int j,int weg){
            weight[i][j]=weg;
            weight[j][i]=weg;
        }
        public void show(){
            System.out.println("【顶点名】"+ Arrays.toString(vertexName));
            System.out.println("【邻接矩阵】：");
            for (int[] arr:weight){
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    public static void main(String[] args) {

        /*MGraph2 prim = prim(getMGraph2());
        System.out.println("==============================================");
        prim.show();*/
        char[] chars = new char[2];
        System.out.println(chars[0]);
    }
}
