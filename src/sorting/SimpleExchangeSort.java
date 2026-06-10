package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleExchangeSort {
    public static void simpleExchangeSort(){
     int x[],n,i,j,k;
        Scanner sc=new Scanner(System.in);
        System.out.println("How many element you want to enter=");
        int total = sc.nextInt();
        x=new int[total];
        for(i=0;i<total;i++){
            System.out.println("Enter element "+(i+1)+"=");
            x[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(x));
        // simple exchange sort
        for (i = 0; i <total; i++) {

            for (j = i+1; j <=total-1 ; j++) {
                if(x[i]>x[j]){
                    k=x[i];
                    x[i]=x[j];
                    x[j]=k;
                }
            }
        }
        System.out.println(Arrays.toString(x));

    }
}
