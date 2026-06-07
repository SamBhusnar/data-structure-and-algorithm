package graph;

import java.util.Scanner;

public class AdjacencyMatrixDirectedWeightedGraph {

    public static void adjacencyMatrixMethod() {
        int [][]adj;

        int n,edges,sc,de,i,j,wt;
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter total nodes= ");
        n=inp.nextInt();
        System.out.print("\nEnter total edges= ");
        edges=inp.nextInt();
        adj = new int[n+1][n+1];
        for ( i = 1; i <=edges ; i++) {
            System.out.print("\nEnter "+i+"th source node= ");
            sc=inp.nextInt();
            System.out.print("\nEnter "+i+"th destination node= ");
            de=inp.nextInt();
            System.out.print("\nEnter weight of edge= ");
            wt=inp.nextInt();
            if(sc>n||de>n||sc<=0||de<=0){
                System.out.println("Invalid input");
                i--;
                continue;
            }else{
                adj[sc][de]=wt;
            }

        }
        System.out.println("Adjacency Matrix=");
        for (i=1;i<=n;i++){
            for (j=1;j<=n;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }






}
