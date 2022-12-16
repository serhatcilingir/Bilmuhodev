/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaodevı;

import java.util.Scanner;

/**
 *
 * @author Serhat
 */
public class Javaodevı {

 public static boolean checkMinHeap(int[] dizi, int i)
    {
        
        if (2*i + 2 > dizi.length) { //i yaprak düğüm ise true 
            return true;
        }
        //eğer i içerdeki bir düğüm ise(yaprak değilse)
        boolean left = (dizi[i] <= dizi[2*i + 1]) && checkMinHeap(dizi, 2*i + 1);
 
        boolean right = (2*i + 2 == dizi.length) ||(dizi[i] <= dizi[2*i + 2] && checkMinHeap(dizi, 2*i + 2));
 
        return left && right;
    }
    
    
    
   static void heapify(int dizi[], int N,int i) {
    	
		int parent = i;
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 

		
		if (l < N && dizi[l] < dizi[parent])
			parent = l;

		
		if (r < N && dizi[r] < dizi[parent])
			parent = r;

		if (parent != i) {
			int swap = dizi[i];
			dizi[i] = dizi[parent];
			dizi[parent] = swap;

			heapify(dizi, N, parent);
		}
	}

	
   
 //var olan bir diziyi heap'e çevirmek için
   static void heap_olustur(int dizi[], int N){
       int startIdx = (N / 2) - 1; 
       for (int i = startIdx; i >= 0; i--) {
           heapify(dizi, N, i);
       }
   }

   
   
   static void printHeap(int dizi[], int N){
       System.out.println(
           "min heap olusturulmus hali:");

       for (int i = 0; i < N; ++i)
           System.out.print(dizi[i] + " ");

       System.out.println();
   }

 
   
   
    public static void main(String[] args)
    {
    	int []dizi=new int[6];
       // int[] A = {13, 2, 1, 4, 5, 6};
    	
         for(int i=0;i<6;i++) {
        	 System.out.println("sayi girin:");
        	 Scanner input=new Scanner(System.in);
        	 dizi[i]=input.nextInt();
         }
        
        int index = 0;
 
        if (checkMinHeap(dizi, index)) {
            System.out.println("min heaptir");
        }
        else { 
        	//min heap değilse diziden min heap oluşturma işlemi
            System.out.println("min heap degildir\n");
            int N = dizi.length;
            heap_olustur(dizi, N);
            printHeap(dizi, N);
			
        }
    }
    
}
