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
public class Node <T> {

    public Node(T data) {
        this.data = data;
    }
    T data;
    
    Node <T> next;
    Node <T> prev;
    
   
}
