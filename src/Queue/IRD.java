package Queue;

public class IRD {
    int items[],left,right;
    int max=5;
    public IRD() {
        items=new int[max];
        left=-1;
        right=-1;
    }
    //  output restricted dequeue
    public void insertRight(int element){
        if(right==max-1){
            System.out.println("Queue is overflow...");
        }else{
            items[++right]=element;
            System.out.println(element+" :Element inserted");
        }
    }
    public boolean isEmpty(){
        return left == right;
    }

    public boolean isFull(){
        return right == max - 1;
    }

    public int removeRight(){
        if(left==right){
            System.out.println("Queue is underflow...");
            return -1;
        }else{
            return items[right--];
        }
    }
    public int removeLeft(){
        if(left==right){
            System.out.println("Queue is underflow...");
            return -1;
        }else{
            return items[++left];
        }
    }
    public void display(){
        for(int i=left+1;i<=right;i++){
            System.out.print(items[i]+" ");
        }
    }
}