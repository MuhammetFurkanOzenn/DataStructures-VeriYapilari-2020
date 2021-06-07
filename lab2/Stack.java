/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Ozen
 */
public class Stack {

    Node head1 = null;
    Node head2 = null;
    Node tail1 = null;
    Node tail2 = null;

    void push1(int data) {
        Node newNode = new Node(data);
        newNode.nextNode = head1;
        head1 = newNode;
    }

    void push2(int data) {
        Node newNode = new Node(data);
        newNode.nextNode = head2;
        head2 = newNode;
    }

    int pop1() {
        if (head1 == null) {
            System.out.println("Stack Boş...");
            return 0;
        } else {
            int data = head1.data;
            head1 = head1.nextNode;
            return data;
        }
    }

    int pop2() {
        if (head2 == null) {
            System.out.println("Stack Boş...");
            return 0;
        } else {
            int data = head2.data;
            head2 = head2.nextNode;
            return data;
        }
    }
    
    void swapItems (int s1, int s2){
        int i = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        Node d1 = head1;
        Node d2 = head2;
        while (i!=s1){
            temp1 = temp1.nextNode;
            i++;
        }
        i=1;
        while (i != s2){
            temp2 = temp2.nextNode;
            i++;
        }
        temp1.nextNode = temp2.nextNode;
        temp2 = temp1;
        
        
        while (d1 != null){
            d1 =d1.nextNode;
            System.out.println(d1.data);
        }
        System.out.println("-----------");
        while (d2 != null){
            d2 = d2.nextNode;
            System.out.println(d2.data);
        }
        
    }

}
