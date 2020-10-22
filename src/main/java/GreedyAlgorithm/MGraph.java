package GreedyAlgorithm;

import java.util.Arrays;

/**
 *@className MGraph
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/21 21:06
 *@version
 */
public class MGraph {
    private final int vertex;//顶点的个数
    private char[] ver;//保存各个顶点的数组
    private final int[][] weight;//邻接矩阵
    public MGraph(int vertex){
        this.vertex=vertex;
        ver=new char[vertex];
        weight=new int[vertex][vertex];
    }
    public void put(char a,char b,int value){
        int i=a-'A';
        int j=b-'A';
        weight[i][j]=value;
        weight[j][i]=value;
    }
    public void show(){
        for (int i=0;i<weight.length;i++){
            System.out.println(Arrays.toString(weight[i]));
        }
    }

    public char[] getVer() {
        return ver;
    }

    public void setVer(char[] ver) {
        this.ver = ver;
    }
    public int[][] getWeight(){
        return this.weight;
    }

    public int getVertex() {
        return vertex;
    }
}
