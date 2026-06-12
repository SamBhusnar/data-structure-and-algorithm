package sorting;

import java.util.Scanner;

public class QuickSort {
    public static void quickSort(){
        int x[],j;
        QuickSort qs = new QuickSort();
        System.out.print("Enter the size of array=");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter "+i+" element=");
            x[i] = sc.nextInt();
        }

        long start = System.nanoTime();
        qs.quick(x,0,n-1);
        long finish = System.nanoTime();
        System.out.println("Time taken: " + (finish - start) + " nanoseconds");
        for (int i=0;i<n;i++){
            System.out.print(x[i]+" ");
        }
        System.out.println();


    }
    public void quick(int z[],int lw, int up){
        int i;
        if(up>lw){
            i = split(z,lw,up);
            quick(z,lw,i-1);
            quick(z,i+1,up);
        }
    }
    public int split(int z[],int lw, int up){
        int pivot,upper,lower,t;
        lower=lw;
        upper=up;
        pivot=z[lw];
        while(upper>lower){
            while (lower<=upper && z[lower]<=pivot){
                lower++;
            }
            while (upper>=lower && z[upper]>pivot){
                upper--;
            }
            if (upper>lower){
                t = z[lower];
                z[lower] = z[upper];
                z[upper] = t;
            }
        }
        t=z[lw];
        z[lw]=z[upper];
        z[upper]=t;
        return upper;

    }
}
