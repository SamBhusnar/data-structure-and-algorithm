package LinkedList;

import java.util.Scanner;

public class SinglyLinearLinkedList {
    public int info;
    public static SinglyLinearLinkedList list;
    public SinglyLinearLinkedList next;

   // inserting beginning of linked list
    public void ins_beginning(int info) {
     SinglyLinearLinkedList p,q;
     p=list;
     if(p==null){// if linkedList is empty
         p = new SinglyLinearLinkedList();// new LinkedList is created
         p.info = info;
         p.next = null;
         list=p;
     }else{
         q = new SinglyLinearLinkedList();// new LinkedList is created
         q.info = info;
         q.next = p;
         list = q;
     }

    }
    public  void ins_end(int info){
        SinglyLinearLinkedList p,q;
        p=list;
        if(p==null){ // if linkedList is empty
            p = new SinglyLinearLinkedList();// new LinkedList is created
            p.info = info;
            p.next = null;
            list=p;
        }else{ // if linkedList is not empty

            while (p.next!=null){// traverse to the end of the linkedList
                p=p.next;
            }
            q=new SinglyLinearLinkedList();
            q.info=info;
            q.next=null;
            p.next=q;// insert at the end
        }
    }
    public  void ins_between(int info,int after){
     SinglyLinearLinkedList p,q;
        p=list;
        if(p==null||p.next==null){
            System.out.println("Insert between not possible");
        }else{
            while (p.next!=null){
                if(after==p.info){
                    q=new SinglyLinearLinkedList();
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
     int n;
     SinglyLinearLinkedList p;
     p=list;
     if(p==null){
         System.out.println("List is empty");
         return  -1;
     }else if(p.next==null){
         n=p.info;
         list=null;
         return n;
     }else{
         n=p.info;
         p=p.next;
         list=p;
         return n;
     }
    }
    public int rem_end(){
     int n;
     SinglyLinearLinkedList p,temp;
     p=list;
     if(p==null){
         System.out.println("List is empty");
         return -1;
     }else if(p.next==null){// if list has only one element
         n=p.info;
         list=null;
         return n;
     }else{// if list has more than one element

         while (p.next.next!=null){
             p=p.next;
         }
         temp=p.next;
         p.next=null;
         return temp.info;

     }
    }
    public int rem_between(int after){
     int n;
     SinglyLinearLinkedList p,temp;
     p=list;
     if(p==null){
         System.out.println("list is empty");
     }else if(p.next==null || p.next.next==null){
         System.out.println("Remove between not possible");
     }else{
         while (p.next!=null){
             if(p.info==after){
                 temp=p.next;
                 p.next=temp.next;
                 return temp.info;
             }
             p=p.next;
         }

     }
     return  -1;
    }

    public void search(int info){
        int f=0;
        SinglyLinearLinkedList p;
        p=list;
        while (p!=null){
            if(p.info==info){
                f=1;
                break;
            }
            p=p.next;
        }
        if(f==1){
            System.out.println("Node is found");
        }else{
            System.out.println("Node is not found");
        }
    }
    public  void count(){
        int cnt=0;
        SinglyLinearLinkedList p;
        p=list;
        while (p!=null){
            cnt++;
            p=p.next;
        }
        System.out.println("Total number of Nodes in Linked list:"+cnt);
    }

    public void display(){
        SinglyLinearLinkedList p;
        p=list;
        System.out.print("[");
        while (p!=null){
            System.out.print(p.info+",");
            p=p.next;
        }
        System.out.println("]");
    }
    public void reverse(){
        SinglyLinearLinkedList t1,t2=null,t3=null;
        t1=list;
        while(t1!=null){
            t2=t1.next;
            t1.next=t3;
            t3=t1;
            t1=t2;
        }
        list=t3;
        System.out.println("Linked list is reversed");
    }

    public static void eventDrivenProgram(){
            Scanner sc=new Scanner(System.in);
            SinglyLinearLinkedList list = new SinglyLinearLinkedList();
            while (true){
                System.out.println("\n1.Insert at beginning\n2.Insert at end\n3.Insert between\n4.Remove from beginning\n5.Remove from end\n6.Remove between\n7.Search\n8.Count\n9.Reverse\n10.Display\n11.Exit");
                int inp = sc.nextInt();
                switch (inp){
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
                        list.ins_between(value2,after);
                        break;
                    case 4:
                        int i = list.rem_beginning();
                        if(i!=-1){
                            System.out.println("Removed value:"+i);
                        }
                        break;
                    case 5:
                        int j = list.rem_end();
                        if(j!=-1){
                            System.out.println("Removed value:"+j);
                        }
                        break;
                    case 6:
                        System.out.println("Enter value of after ");
                        int after1 = sc.nextInt();

                        int i1 = list.rem_between(after1);
                        if(i1!=-1){
                            System.out.println("Removed value:"+i1);
                        }
                        break;
                    case 7:
                        System.out.println("Enter value to search");
                        int src=sc.nextInt();
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
