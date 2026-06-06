package LinkedList;

import java.util.Scanner;

class Node1{
    public int info;
    public Node1 next;
}
public class SinglyCircularLinkedList {
    Node1 list;
    public void ins_beginning(int info){
     Node1 p,q;
     p=list;
     if(p==null){
      p=new Node1();
      p.info=info;
      p.next=p;
      list=p;
     }else{
         while (p.next!=list){
             p=p.next;
         }
         q=new Node1();
         q.info=info;
         q.next=p.next;
         p.next=q;
         list=q;
     }
    }
    public void ins_end(int info){
     Node1 p,q;
     p=list;
     if(p==null){
         p=new Node1();
         p.info=info;
         p.next=p;
         list=p;
     }else{
         while (p.next!=list){
             p=p.next;
         }

         q=new Node1();
         q.info=info;
         q.next=p.next;
         p.next=q;
     }


    }
    public void ins_between(int info,int after){
     Node1 p,q;
     p=list;
     if(p==null||p.next==p){
         System.out.println("Insert between not possible");
     }else{
         while (p.next!=list){
             if(p.info==after){
                 q=new Node1();
                 q.info=info;
                 q.next=p.next;
                 p.next=q;
                 break;
             }
             p=p.next;
         }
     }
    }
    public int rem_beginning(){
        Node1 p,temp;
        p=list;
        if(p==null){
            System.out.println("List is empty");
            return -1;
        }else if(p.next==p){
            list=null;
            return  p.info;
        }else {
            while (p.next!=list){
                p=p.next;
            }
           temp=p.next;
           p.next=temp.next;
           list=p.next;
            return temp.info;
        }
    }

    public  int rem_end(){
        Node1 p,temp;
        p=list;
        if(p==null){
            System.out.println("List is empty");
            return -1;
        }else if(p.next==p){
            list=null;
            return p.info;
        }else{
            while (p.next.next!=list){
                p=p.next;
            }
            temp=p.next;
            p.next=temp.next;
            return temp.info;
        }
    }
    public int rem_between(int after){
        Node1 p,temp;
        p=list;
        if(p==null){
            System.out.println("list is empty");
            return -1;
        }else if((p.next==p)||(p.next.next==p)){
            System.out.println("Insert between not possible");
            return  -1;
        }else {
            while (p.next!=list){
                if(p.info==after){
                    temp=p.next;
                    p.next=temp.next;
                    return temp.info;
                }
                p=p.next;
            }
        }
        return -1;
    }

    public void search(int srch){
        Node1 p;
        p=list;
        int t=0;
        if(p==null){
            System.out.println("list is empty");
        }else{
            do{
                if(p.info==srch){
                   t=1;
                   break;

                }
                p=p.next;
            }while (p!=list);
            if(t==1){
                System.out.println("Element found");
            }else{
                System.out.println("Element not found");
            }
        }
    }


    public void count(){
        Node1 p;
        int cnt=0;
        p=list;
        if(p==null){
            System.out.println("Number of node is :"+cnt);
        }else{
            do{
                cnt++;
                p=p.next;
            }while (p!=list);
            System.out.println("Number of node is :"+cnt);
        }
    }


    public  void display(){
        Node1 p;
        p=list;
        if(p==null){
            System.out.println("list is empty");
        }else{
            System.out.print("[");
        do{
            System.out.print(p.info+", ");
            p=p.next;
        }while (p!=list);
            System.out.println("]");
        }
    }

    public  void reverse(){
        Node1 t1,t2,t3=list;
        t1=list;
        if(t3==null){
            System.out.println("list is empty");
        }else{
            do {
                t2=t1.next;
                t1.next=t3;
                t3=t1;
                t1=t2;
            }while (t1!=list);
            list=t3;
            t1.next=t3;
            System.out.println("list reversed");
        }
    }



    public static void eventDrivenProgram() {
        Scanner sc = new Scanner(System.in);
        SinglyCircularLinkedList list = new SinglyCircularLinkedList();
        while (true) {
            System.out.println("\n1.Insert at beginning\n2.Insert at end\n3.Insert between\n4.Remove from beginning\n5.Remove from end\n6.Remove between\n7.Search\n8.Count\n9.Reverse\n10.Display\n11.Exit");
            int inp = sc.nextInt();
            switch (inp) {
                case 1:
                    System.out.println("Enter the value to insert");
                    int value = sc.nextInt();
                    list.ins_beginning(value);
                    break;
                case 2:
                    System.out.println("Enter the value to insert");
                    int value1 = sc.nextInt();
                    list.ins_end(value1);
                    break;
                case 3:
                    System.out.println("Enter the value to insert");
                    int value2 = sc.nextInt();
                    System.out.println("Enter the value after which to insert");
                    int after = sc.nextInt();
                    list.ins_between(value2, after);
                    break;
                case 4:
                    int i = list.rem_beginning();
                    if (i != -1) {
                        System.out.println("Removed value:" + i);
                    }
                    break;
                case 5:
                    int j = list.rem_end();
                    if (j != -1) {
                        System.out.println("Removed value:" + j);
                    }
                    break;
                case 6:
                    System.out.println("Enter value of after ");
                    int after1 = sc.nextInt();

                    int i1 = list.rem_between(after1);
                    if (i1 != -1) {
                        System.out.println("Removed value:" + i1);
                    }
                    break;
                case 7:
                    System.out.println("Enter value to search");
                    int src = sc.nextInt();
                    list.search(src);
                    break;
                case 8:
                    list.count();
                    break;
                case 9:
                    list.reverse();
                    break;
                case 10:
                    list.display();
                    break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");

            }
        }
    }






}
