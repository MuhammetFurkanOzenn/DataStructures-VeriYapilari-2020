/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab14;

/**
 *
 * @author Ozen
 */
public class q1 {
    public static void main(String[] args) {
        int min = 10, max = 30, counter = 0;
        
        //  a)  are divisible by7?
        System.out.print("a)");
        for (int i = min ; i<=max; i++){
            if (i%7 == 0){
                System.out.print(i+" ");
                counter++;
            }
        }
        System.out.println("- "+counter);
        
        //  b)  are odd?
        System.out.print("b)");
        counter =0;
        for (int i = min ; i<=max; i++){
            if (i%2 == 1){
                System.out.print(i+" ");
                counter++;
            }
        }
        System.out.println("- "+counter);
        
        //  c)  are divisible by 3 or 4?
        counter =0;
        System.out.print("c)");
        for (int i = min ; i<=max; i++){
            if (i%3 == 0 || i%4 == 0){
                System.out.print(i+" ");
                counter++;
            }
        }
        System.out.println("- "+counter);
        
        //  d)  are not divisible by either 3 or 4?
        counter =0;
        System.out.print("d)");
        for (int i = min ; i<=max; i++){
            if (i%3 != 0 || i%4 != 0){
                System.out.print(i+" ");
                counter++;
            }
        }
        System.out.println("- "+counter);
        
        //  e)  are divisible by 3 but not by 4?
        counter =0;
        System.out.print("e)");
        for (int i = min ; i<=max; i++){
            if (i%3 == 0 & i%4 != 0){
                System.out.print(i+" ");
                counter++;
            }
        }
        System.out.println("- "+counter);
        
    }
}
