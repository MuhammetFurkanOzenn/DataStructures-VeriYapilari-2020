/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab07;



/**
 *
 * @author Ozen
 */
public class Node <T> {
    T data;
    Node nextNode;
    
    public Node(T data){
        this.data = data;
        this.nextNode = null;
    }
}
