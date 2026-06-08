package graph;

import java.util.Scanner;

public class  DepthFirstSearch {
    int adj[][],n,edges;
    boolean visited[];


    public static void  depthFirstSearch(){
        int sc,de,i,j,v;
        DepthFirstSearch dfs = new DepthFirstSearch();
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter total nodes= ");
        dfs.n = inp.nextInt();
        dfs.adj = new int[dfs.n+1][dfs.n+1];
        dfs.visited = new boolean[dfs.n+1];
        System.out.print("Enter total edges= ");
        int edges = inp.nextInt();

        // insert source and destination if they are valid
        for ( i = 1; i <= edges; i++) {
            System.out.println("Enter "+i+"th source");
            sc=inp.nextInt();
            System.out.println("Enter "+i+"th destination");
            de=inp.nextInt();
            if(sc>dfs.n||sc<=0||de>dfs.n||de<=0){
                System.out.println("Invalid source or destination");
                i--;
                continue;
            }else{
                dfs.adj[sc][de]=1;
            }
        }
//    System.out.println("Enter vertex to traverse=");
//    v=inp.nextInt();
//    bfs.bfsMethod(v);
        for (int k = 1; k <=dfs.n; k++) {
            dfs.dfsMethod(k);
            dfs.visited = new boolean[dfs.n+1];
            System.out.println();
        }

    }

    public void dfsMethod(int v){

        int top,i;
        int stack[] = new int[30];
        top=-1;
         stack[++top]=v;
        while (top!=-1){

            v=stack[top--];
            if(!visited[v]){
                System.out.print(" "+v);
                visited[v]=true;
                for(i=n;i>=1;i--){
                    if(adj[v][i]==1 && !visited[i]){
                         stack[++top]=i;
                    }
                }
            }
        }
        System.out.println("reer val : "+top);

    }





}
