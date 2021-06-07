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
public class StackList <T> {
    Node <T> head;
    
    void push (T data){
        Node <T> newNode = new Node(data);
        newNode.nextNode= head;
        head = newNode;
    
    }
    
    T pop () {
        if (head == null){
            System.out.println("Empty stack!");
            return null;
        }else{
            T data = head.data;
            head=head.nextNode;
            return data;
        }
    }
    
    T peek (){
        if (head == null){
            return null;
        }else {
            return head.data;
        }
    }
    
    int size (){
        int size = 0;
        Node <T> temp = head;
        while (temp!=null){
            size++;
            temp = temp.nextNode;
        }
        
        return size;
    }
    
    void print (){
        Node <T> temp = head;
        while (temp!= null){
            System.out.println(temp.data);
            temp= temp.nextNode;
        }
    
    }
    
    public static void main(String[] args) {
        
        StackList<Integer> stack = new StackList<>();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(55);
        stack.print();
        System.out.println("-------");
        stack.pop();
        stack.print();
        
        
        
    }
    StackList<Integer> stack = new StackList<>();
    public void smash (int value) {
        StackList<Integer> tempStack = new StackList<>();
        int sayac = 0;
        if (value <= stack.peek()){
            stack.push(value);
        }else{
            while (value>stack.peek()){
                tempStack.push(stack.pop());
                sayac++;
                if (value<=stack.peek()){
                    stack.push(value);
                    break;
                }
            }
            while (sayac != 0){
                stack.push(tempStack.pop());
                sayac--;
            }
        }
        

    }
    
}
