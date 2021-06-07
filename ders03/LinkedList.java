/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders03;

import java.io.*;

/**
 *
 * @author Ozen
 */
public class LinkedList <T>{
    
    Node head;
    
    
    void addLast (int data){
        Node newNode = new Node(data);
        Node temp = head;
        if (head == null){
            head = newNode;
        }else{
            temp = head;
            while(temp.nextNode == newNode){
                temp = temp.nextNode;
            }
        
        }
        
    }
    
    void removeFirst (){
    
        if (head == null){
            System.out.println("Listede silinecek eleman yok.");
        
        }else{
            System.out.println("");
            head = head.nextNode;
            
        }
    
    }
    
    void removeLast (){
    
        if (head == null){
            System.out.println("Listede silinecek eleman yok.");
        
        }else{
            Node temp = head;
            while(temp.nextNode!=null){
            temp = temp.nextNode;
            }
            temp=null;
        }
    
    }
    
    void remove (T data){
        if (head == null){
            System.out.println("Listede silinecek eleman yok.");
        }else if (head.data == data){
            head = head.nextNode;
        
        }
    
    }
    
    
}
