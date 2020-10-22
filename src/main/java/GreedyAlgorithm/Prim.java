package GreedyAlgorithm;

/**
 *@className Prim
 *@description 普利姆算法解决修路问题
 *@author 1226134406@qq.com
 *@time 2020/10/21 20:30
 *@version
 */
public class Prim {
    private MGraph getMGraph(){
        MGraph mGraph=new MGraph(7);
        mGraph.setVer(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'});
        mGraph.put('A', 'B', 5);
        mGraph.put('A', 'C', 7);
        mGraph.put('A', 'G', 2);
        mGraph.put('B', 'D', 9);
        mGraph.put('B', 'G', 3);
        mGraph.put('C', 'E', 8);
        mGraph.put('G', 'E', 4);
        mGraph.put('G', 'F', 6);
        mGraph.put('E', 'F', 5);
        mGraph.put('D', 'F', 4);
        mGraph.show();
        return mGraph;
    }
    /**
     *@description: prim方法是 修路问题
     *@param: [graph]
     *@retrun: GreedyAlgorithm.MGraph
     *@auther: 1226134406@qq.com
     *@date: 2020/10/21 23:35
     */
    public MGraph primA(MGraph graph){
        MGraph mGraph=new MGraph(graph.getVertex());
        mGraph.setVer(graph.getVer());
        char[] chars=graph.getVer();
        int [] connected=new int[graph.getVertex()];
        //0表示未修路
        //1表示已修路
        //2表示该节点所有的连接节点已被修到了路
        connected[0]=1;
        int con=1;
        int min=0;
        int row=0;
        int col=0;
        while (con<graph.getVertex()){
            for (int i=0;i<connected.length;i++){
                //如果char[i]节点以修上路
                if (connected[i]==1){
                    boolean flag=true;//判断一个节点的能连的节点都上了路,默认是都修上了
                    for (int j=0;j<connected.length;j++){
                        if (j!=i&&connected[j]==0&&graph.getWeight()[i][j]>0){//若干j还没修上路
                            //找最短的还没修上的
                            if (min==0){
                                row=i;
                                col=j;
                                min=graph.getWeight()[i][j];
                            }else {
                                if (min>graph.getWeight()[i][j]){
                                    min=graph.getWeight()[i][j];
                                    row=i;
                                    col=j;
                                }
                            }
                            flag=false;//还有没修上的
                        }

                    }
                    if (flag){
                        connected[i]=2;
                    }
                }
            }
            if (row!=col){
                mGraph.put(chars[row],chars[col],min);
                connected[col]=1;
            }
            row=0;
            col=0;
            min=0;
            con++;
        }
        return mGraph;
    }
    public static void main(String[] args) {
        Prim prim=new Prim();
        MGraph mGraph = prim.getMGraph();
        MGraph mGraph1 = prim.primA(mGraph);
        System.out.println("==============================");
        mGraph1.show();
    }
}
