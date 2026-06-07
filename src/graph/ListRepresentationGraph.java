package graph;


import java.util.Scanner;

class  Node{
    int info;
    Node next;
    Edge adj;

}
class Edge{
    int dest;
    Edge right;

}






public class ListRepresentationGraph {
     Node start;
     public void insert(int element){
         Node p,temp;
         p=new Node();
         p.next=null;
         p.adj=null;
         p.info=element;
         if(start==null){
             start=p;
         }else{
             temp=start;
             while(temp.next!=null){
                 temp=temp.next;
             }
             temp.next=p;
         }
     }

     public void display(){
         Node p=start;
         while(p!=null){
             System.out.print(p.info+" ");
             p=p.next;
         }
         System.out.println();
     }

     public void search(int srch){
         Node p;
         int t=0;
         p=start;
         while (p!=null){
             if(p.info==srch){
              t=1;
              break;

             }
             p=p.next;
         }
         if(t==1){
             System.out.println("Element found");
         }else{
             System.out.println("Element not found");
         }







     }

     public void insertEdge(int sc,int de){

         Node p,q;
         int t=0,k=0;
         p=start;
         q=start;
         while (p!=null){
             if(p.info==sc){
                 t=1;
                 break;
             }
             p=p.next;
         }

         while (q!=null){
             if(q.info==de){
                 k=1;
                 break;
             }
             q=q.next;
         }

         if(t==1 && k==1){
             Edge r,z;
             r=new Edge();
             r.dest=de;
             r.right=null;
             if(p.adj==null){
                 p.adj=r;
             }else{
                 z=p.adj;
                 while(z.right!=null){
                     z=z.right;
                 }
                 z.right=r;
             }
         }else{
             System.out.println("Invalid source or destination");
         }

     }
    public void findAdjacentVertices(int srch){

         Node p;
         int f=0;
         p=start;
         while (p!=null){
             if(p.info==srch){
                 f=1;
                 break;
             }
             p=p.next;
         }
         if(f==1){
             if(p.adj==null){
                 System.out.println("Entered vertex has no adjacent vertices");
             }
             else
             {
                 Edge r;
                 r=p.adj;
                 while(r!=null){
                     System.out.print(r.dest+" ");
                     r=r.right;
                 }



             }




         }else{
             System.out.println("Vertex not found");
         }



    }
    public void displayGraph(){
        Node p=start;
        Edge r;
        while (p!=null){
            System.out.print(p.info);
            r=p.adj;
            while (r!=null){
                System.out.print("-->"+r.dest);
                r=r.right;
            }
            System.out.println();
            p=p.next;
        }
    }

    public static void eventDrivenMethod(){
     ListRepresentationGraph list=new ListRepresentationGraph();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("\n\n1.Insert vertex\n2.Search\n3.Insert Edge\n4.Find Adjacent Vertices\n5.Display Graph\n6.Exit");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.print("Enter vertex= ");
                    int vertex=sc.nextInt();
                    list.insert(vertex);
                    break;
                case 2:
                    System.out.print("Enter vertex :");
                    int srch=sc.nextInt();
                    list.search(srch);
                    break;
                case 3:
                    System.out.print("Enter source : ");
                    int source=sc.nextInt();
                    System.out.print("Enter destination : ");
                    int destination=sc.nextInt();
                    list.insertEdge(source,destination);
                    break;
                case 4:
                    System.out.print("Enter Vertext : ");
                    int adjVertext=sc.nextInt();
                    list.findAdjacentVertices(adjVertext);
                    break;
                case 5:
                    list.displayGraph();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;



            }
        }





    }



}
