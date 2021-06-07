/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veri_yapilari_2020;

/**
 *
 * @author Ozen
 */
public class recursive_fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // recursive fib karmasıklarını bul 
        int maxFibDegeri = 50;
        
        long startTime = System.nanoTime();
        for (int i = 0; i <= maxFibDegeri; i++) {
            System.out.println("--------------------------------------");
            System.out.println( i + ". fibonacci sayisi: " + fib(i));
            
            // Başlangıç Zamanı
            long endTime = System.nanoTime();
            // bitiş zamanı
            long estimatedTime = endTime - startTime; // Geçen süre nanosaniye cinsinden elde edilir
            double seconds = (double) estimatedTime / 1000000000; // saniyeye çevirm
            System.out.println("Gecen sure : "+seconds+" saniyedir...");
            System.out.println("--------------------------------------");
        }

    }

    public static long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
