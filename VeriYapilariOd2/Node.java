/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeriYapilariOd2;

/**
* @file 1721221019_MuhammetFurkanÖzen
* @description Dosyadan okunan verilerle BST oluşturup işletmek.
* @assignment Ödev 2
* @date 20.01.2021
* @author Muhammet Furkan Özen muhammetfurkan.ozen@stu.fsm.edu.tr
*/

public class Node {
    Node leftChild;                         // BİR BST NODU'U İÇİN GEREKLİ OLAN ;
    Node rightChild;                        // SOL VE SAĞ ÇOCUK
    int data;                               // DATA
    int soy;                                // VE SOY SAYISI DEĞERLERİ OLUŞTURULDU...

    public Node(int data) {                 // PARAMETRELİ YAPICI FONKSİYON OLUŞTURULDU...
        this.data = data;
    }
    public Node() {                         // BOŞ YAPICI FONKSİYON DA OLUŞTURULDU...
    }
    
}
