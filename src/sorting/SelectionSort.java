package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array=");
        int n = sc.nextInt();
        int x[] = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter element "+(i+1)+"=");
            x[i] = sc.nextInt();
        }
        System.out.println("Selection Sort");
        long start = System.nanoTime();
        int min,pos;
        for(int i=0;i<n-1;i++){

            min=x[i];
            pos=i;
            for(int j=i+1;j<n;j++){
                if(x[j]<min){
                    min=x[j];
                    pos=j;
                }
            }

            if(pos!=i){
                int temp = x[i];
                x[i] = x[pos];
                x[pos] = temp;
            }

        }
        long finish = System.nanoTime();
        System.out.println("Time taken: " + (finish - start) + " nanoseconds");
        System.out.println(Arrays.toString(x));

    }
}
