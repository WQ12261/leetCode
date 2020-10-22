package graph;


import java.util.*;

/**
 *@className Graph
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/9 16:28
 *@version
 */
public class Graph {
    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储图对应的邻接矩阵
    private int[][] edges;
    //边的个数
    private int numberOfEdges;
    //索引为i的节点是否被访问过
    private boolean[] isVisited;
    //顶点的数量
    private int numberOfVertex;
    public Graph(int n){
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        isVisited=new boolean[n];
        numberOfVertex=n;
    }
    /**
     *@description: insertVertex方法是插入顶点
     *@param: [vertex：顶点名]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/9 16:38
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    /**
     *@description: insertEdge方法是插入边
     *@param: [v1, v2, weight：边的权重]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/9 16:39
     */
    public void insertEdge(int v1,int v2,int weight){
        //因为是无向图，所以对称
        if (edges[v1][v2]!=weight){
            numberOfEdges++;
        }
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
    }
    /**
     *@description: getNumberOfVertex方法是返回图的顶点的个数
     *@param: []
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/9 16:44
     */
    public int getNumberOfVertex(){
        return numberOfVertex;
    }
    /**
     *@description: getNumberOfEdges方法是返回图中边的个数
     *@param: []
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/9 16:45
     */
    public int getNumberOfEdges(){
        return numberOfEdges;
    }
    /**
     *@description: nameOfVertexByIndex方法是通过索引获取顶点的名称
     *@param: [index]
     *@retrun: java.lang.String
     *@auther: 1226134406@qq.com
     *@date: 2020/10/9 16:47
     */
    public String nameOfVertexByIndex(int index){
        return vertexList.get(index);
    }
    /**
     *@description: getWeight方法是返回两个顶点边的权值
     *@param: [v1, v2]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/9 16:49
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    /**
     *@description: showEdges方法是打印图的邻接矩阵
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/9 16:51
     */
    public void showEdges(){
        for (int[] arr:edges){
            System.out.println(Arrays.toString(arr));
        }
    }
    /**
     *@description: getFirst方法是得到第n个顶点的第一个没有被访问的临界节点的下标
     *@param: [n]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/11 20:48
     */
    private int getFirst(int n,boolean[] isVisited){
        int[] arr=edges[n];
        for (int i=0;i<arr.length;i++){
            if (i!=n&&!isVisited[i]&&arr[i]>0){
                //如果不是n,并且还没被访问，并且是n的邻接点就返回下标
                return i;
            }
        }

        return -1;
    }
    /**
     *@description: dfs方法是深度优先遍历
     *@param: [n:第n个节点, isVisited：节点是否被访问的数组, str：优先遍历的结果, p:遍历的结果]
     *@retrun: java.lang.String
     *@auther: 1226134406@qq.com
     *@date: 2020/10/11 21:11
     */
    public String dfs(int n,boolean[] isV,String str){
        str+=vertexList.get(n);
        isV[n]=true;
        int index=getFirst(n, isV);
        while (index!=-1){
            str=dfs(index, isV, str);
            index=getFirst(n, isV);
        }
        return str;
    }
    public String BFS(int n){
        String string =vertexList.get(n);
        boolean[] isV=new boolean[vertexList.size()];
        isV[n]=true;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(n);
        String s = BFS(isV, string, queue);
        return s;
    }

    private String BFS(boolean[] isV, String str, Queue<Integer> queue){
        while (!queue.isEmpty()){
            Integer n= queue.remove();
            int index= getFirst(n, isV);
            while (index!=-1){
                queue.add(index);
                isV[index]=true;
                str+=vertexList.get(index);
                index=getFirst(n, isV);
            }
        }
        return str;
    }
    public static void main(String[] args) {
        int n=5;
        Graph graph=new Graph(n);
        String[] vertexValue={"A","B","C","D","E"};
        for (String s:vertexValue){
            graph.insertVertex(s);
        }
        //A-B A-C
        //B-C B-D B-E
        graph.insertEdge('A'-'A', 'B'-'A', 1);
        graph.insertEdge('A'-'A', 'C'-'A', 1);
        graph.insertEdge('B'-'A', 'C'-'A', 1);
        graph.insertEdge('B'-'A', 'D'-'A', 1);
        graph.insertEdge('B'-'A', 'E'-'A', 1);
        graph.showEdges();
        boolean[] isVisited=new boolean[5];
        String dfs = graph.dfs(0, isVisited, "");
        System.out.println(dfs);
        System.out.println(graph.BFS(0));
    }


}
