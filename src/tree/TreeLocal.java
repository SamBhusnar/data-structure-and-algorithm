package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node3 {
    public int info;
    public Node3 left;
    public Node3 right;
}

public class TreeLocal {
    Node3 root;

    public void insert(int x) {
        Node3 newnode, temp;
        newnode = new Node3();
        newnode.info = x;
        newnode.left = null;
        newnode.right = null;
        if (root == null) {
            root = newnode;
        } else {
            temp = root;
            while (temp != null) {
                if (newnode.info < temp.info) {
                    if (temp.left == null) {
                        temp.left = newnode;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (newnode.info > temp.info) {
                    if (temp.right == null) {
                        temp.right = newnode;
                        break;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    System.out.println("Duplicate values not allowed");
                    break;
                }
            }
        }

    }

    public void search(int srch) {
        int t = 0;
        Node3 temp;
        temp = root;
        while (temp != null) {
            if (srch == temp.info) {
                t = 1;
                break;
            }
            if (srch < temp.info) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (t == 1) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }


    public Map<String,Node3> searchAndReturn(int srch) {
        int t = 0;
        Node3 temp, parent=null,child=null;
        temp = root;
        while (temp != null) {
            if (srch == temp.info) {
                t = 1;
                child=temp;
                break;
            }
            if (srch < temp.info) {
                parent=temp;
                temp = temp.left;
            } else {
                parent=temp;
                temp = temp.right;
            }
        }
        if (t == 1) {
            Map<String,Node3> map = new HashMap<>();
            map.put("parent",parent);
            map.put("child",child);
            return  map;
        } else {
            return null;
        }
    }


    public int countLeaf(Node3 p) {
        if (p == null) {
            return 0;
        } else if (p.left == null && p.right == null) {
            return 1;
        } else {
            return (countLeaf(p.left) + countLeaf(p.right));
        }

    }

    public int countTotal(Node3 p) {
        if (p == null) {
            return 0;
        } else if (p.left == null && p.right == null) {
            return 1;
        } else {
            return (countTotal(p.left) + countTotal(p.right) + 1);
        }

    }

    public void preOrder(Node3 p) {// visit , left, right
        if (p != null) {
            System.out.print(p.info + " ");
            preOrder(p.left);
            preOrder(p.right);
        }

    }

    public void inOrder(Node3 p) { // left, visit, right
        if (p != null) {
            inOrder(p.left);
            System.out.print(p.info + " ");
            inOrder(p.right);
        }

    }

    public void postOrder(Node3 p) { // left ,right , visit
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.info + " ");
        }


    }

    // three cases of deleting
    public void delLeaf(Node3 parent, Node3 child) {
        if (parent.left == child    ) {
            parent.left = null;
        } else if (parent.right == child   ) {
            parent.right = null;
        }


        System.out.println("Node is deleted");
    }



    public void delOne(Node3 parent, Node3 child ,boolean isRoot) {

        if ( !isRoot && child == parent.right ) {
            if (child.right != null) {
                parent.right = child.right;
            } else {
                parent.right = child.left;
            }
        } else if ( !isRoot && child == parent.left ) {
            if (child.left != null) {
                parent.left = child.left;
            } else {
                parent.left = child.right;
            }
        } else if(isRoot  ) {
            if(child.right!=null){
                root=child.right;
            }else{
                root=child.left;
            }

        } else {
            System.out.println("Invalid relation between parent and child");
        }
        System.out.println("Node is deleted ");


    }

    public void delTwo(Node3 child) {

        Node3 parent = null;
        Node3 lft = child.left;
        while (lft.right != null) {
            parent = lft;
            lft = lft.right;
        }
        child.info = lft.info;
        if (parent == null) {
            parent = child;
        }
        if (lft.left == null && lft.right == null) {
            delLeaf(parent, lft);
        } else {
            delOne(parent, lft,false);
        }
    }

    public  void delete(int value){
        Map<String, Node3> deleted = searchAndReturn(value);
        if(deleted==null){
            System.out.println("Node not found");
            return;
        }
        Node3 parent=deleted.get("parent");
        Node3 child=deleted.get("child");
        if(this.root.info!=value){
            if(child.left==null && child.right==null){
             delLeaf(parent, child);
            }else if((child.left==null)||(child.right==null)){
                delOne(parent, child,false);
            }else{
                delTwo(child);
            }
        }else{
            // root element
            if(root.left==null&&root.right==null){
                root=null;
                System.out.println("Node is deleted");
            }else if(root.left==null||root.right==null){
                delOne(null,root,true);
            }else{
                delTwo(root);
            }

        }





    }

    public static void eventDrivenMethod() {
        Scanner sc = new Scanner(System.in);
        TreeLocal t = new TreeLocal();
        while (true) {
            System.out.println("1]. Insert\n2]. Search\n3]. Delete \n4]. PreOrder\n5]. InOrder\n6]. PostOrder\n7]. Count Total\n8]. Count Leaf\n9].  Exit");
            int inp = sc.nextInt();
            switch (inp) {
                case 1:
                    System.out.println("Enter the value");
                    int inpVal = sc.nextInt();
                    t.insert(inpVal);
                    break;
                case 2:
                    System.out.println("Enter the value");
                    int inpVal2 = sc.nextInt();
                    t.search(inpVal2);
                    break;
                case 3:
                    System.out.println("Enter the value");
                    int inpVal3 = sc.nextInt();
                    t.delete(inpVal3);
                    break;

                case 4:

                    t.preOrder(t.root);
                    System.out.println();
                    break;
                case 5:
                    t.inOrder(t.root);
                    System.out.println();
                    break;
                case 6:
                    t.postOrder(t.root);
                    System.out.println();
                    break;
                case 7:
                    int i = t.countTotal(t.root);
                    System.out.println("Total nodes are " + i);
                    break;
                case 8:
                    int i1 = t.countLeaf(t.root);
                    System.out.println("Leaf nodes are " + i1);
                    break;

                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }


    }


}
