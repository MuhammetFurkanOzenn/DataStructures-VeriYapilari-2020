/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders03;

import java.util.Scanner;

/**
 *
 * @author Ozen
 */
public class quizStructures {

    public static void main(String[] args) {

        
        System.out.print("Enter a three-digit integer :");
        Scanner scan = new Scanner (System.in);
        int input = scan.nextInt();
        int temp = input;
        int pal = 0;
        int sum =0;

        while (temp != 0) {
            pal=0;
            pal = temp % 10;
            //pal *= 10;
            sum += pal;         // sum=(sum*10)+r;    
            sum*=10;
            
            temp /= 10;
        }   
        sum /= 10;              // üstteki satırı kullanırsak bu satır iptal

        if (input == sum) {
            System.out.println(input + " is a palindrome");
        } else {
            System.out.println(input + " is not a palindrome");
        }

        //**************************
        int x = 6, y = 8;

        System.out.println("Binary form of " + x + ":" + Integer.toBinaryString(x));
        System.out.println("Binary form of " + y + ":" + Integer.toBinaryString(y));

        System.out.println("x&y = > " + (x & y));
        System.out.println("x|y = > " + (x | y));
        System.out.println("x^y = > " + (x ^ y));
        System.out.println("~x  = > " + (~x));
        System.out.println("~y  = > " + (~y));

        //***********************
        int s = 10;

        if (s % 5 == 0 && s % 6 == 0) {
            System.out.println("Is " + s + " divisible by 5 and 6, true");
        } else {
            System.out.println("Is " + s + " divisible by 5 and 6, false");
        }

        if (s % 5 == 0 || s % 6 == 0) {
            System.out.println("Is " + s + " divisible by 5 or 6, true");
        } else {
            System.out.println("Is " + s + " divisible by 5 or 6, false");
        }

        if (s % 5 == 0 ^ s % 6 == 0) {
            System.out.println("Is " + s + " divisible by 5 and 6, but not both true");
        } else {
            System.out.println("Is " + s + " divisible by 5 and 6, but not both false");
        }
    }

}
