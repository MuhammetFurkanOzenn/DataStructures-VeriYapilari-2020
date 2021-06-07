/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev_02;

/**
 *
 * @author Ozen
 */
public class Node <T>{
    
    
    static void ekle (Node eleman){
        if (eleman.data.equals("hizlan")){       // gelen data hizlan ise
            //Node newNode = new Node ();
            kuyruk.dequeue();
            kuyruk.dequeue();
            kuyruk.dequeue();
            if(front == null){              // eğer hizlan yapildiğinda 3ten az eleman varsa kuyruk sıfırlanır.
                //front = newNode;
                //rear  = newNode;
                kuyruk.enqueue(eleman);     // eleman eklendi.
            }
            else                            
                //kuyruk.rear.next = newNode;
                kuyruk.enqueue(eleman);
            }
        else  {                             // hizlan değil ise
            if (size < 5){
                kuyruk.enqueue(eleman);     // size 5'ten küçük ise eleman eklendi.
            }
            else                            // size 5 ise kuyruktan eleman çıkarıp, yeni eleman eklenir
                kuyruk.dequeue();
                kuyruk.enqueue(eleman);
        
        
        }
    
    }
}
