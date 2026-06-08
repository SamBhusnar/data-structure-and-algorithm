package graph;

import java.util.Scanner;

public class BreadthFirstSearch {
int adj[][],n,edges;
boolean visited[];


public static void breadthFirstSearch(){
    int sc,de,i,j,v;
    BreadthFirstSearch bfs = new BreadthFirstSearch();
    Scanner inp = new Scanner(System.in);
    System.out.print("Enter total nodes= ");
    bfs.n = inp.nextInt();
    bfs.adj = new int[bfs.n+1][bfs.n+1];
    bfs.visited = new boolean[bfs.n+1];
    System.out.print("Enter total edges= ");
    int edges = inp.nextInt();

    // insert source and destination if they are valid
    for ( i = 1; i <= edges; i++) {
        System.out.println("Enter "+i+"th source");
        sc=inp.nextInt();
        System.out.println("Enter "+i+"th destination");
        de=inp.nextInt();
        if(sc>bfs.n||sc<=0||de>bfs.n||de<=0){
            System.out.println("Invalid source or destination");
            i--;
            continue;
        }else{
            bfs.adj[sc][de]=1;
        }
    }
//    System.out.println("Enter vertex to traverse=");
//    v=inp.nextInt();
//    bfs.bfsMethod(v);
    for (int k = 1; k <=bfs.n; k++) {
        bfs.bfsMethod(k);
        bfs.visited = new boolean[bfs.n+1];
        System.out.println();
    }

}

public void bfsMethod(int v){

    int queue[]=new int[10000];
    int i,front,rear;
    front=rear=-1;
    ++rear;
    queue[rear]=v;
    while (front!=rear){
        ++front;
        v=queue[front];
        if(!visited[v]){
            System.out.print(" "+v);
            visited[v]=true;
            for(i=n;i>=1;i--){
                if(adj[v][i]==1 && !visited[i]){
                    ++rear;
//                    System.out.println("reer val: "+rear);
                    queue[rear]=i;
                }
            }
        }
    }
    System.out.println("reer val : "+rear);

}





}
