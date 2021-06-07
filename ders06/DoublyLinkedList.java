/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders06;

/**
 *
 * @author Ozen
 */
public class DoublyLinkedList <T> {
    
    Node header, tail;
    
    DoublyLinkedList(T data){
        Node <T> newNode = new Node(data);
        header = tail = newNode;
    }
    
    void addFirst (T data){
        
    
    }
}
