package sorting;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(){

        Scanner sc=new Scanner(System.in);
        int x[],n,i,j;
//        System.out.print("Enter the size of array=");
//        n = sc.nextInt();
        x = new int[1_000_0];
        for(i=1_000_0-1;i>=0;i--){
//            System.out.println("Enter "+i+" element");
            x[1_000_0-(1+i)] = i;
        }


        long start = System.nanoTime();
        // bubble sort
        for(i=0;i<1_000_0-1;i++){
        // if array already sorted then break;
        boolean isSorted = false;
            for(j=0;j<1_000_0-1-i;j++){
                if(x[j]>x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                    isSorted = true;
                }
            }

            if(!isSorted){
                break;
            }
        }


        long finish = System.nanoTime();
//        for (i=0;i<n;i++){
//             System.out.print(x[i]+" ");
//            }
        System.out.println();
        System.out.println("Time taken: " + (finish - start) + " nanoseconds");
    }
}
