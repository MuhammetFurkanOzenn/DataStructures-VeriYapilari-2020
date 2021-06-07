/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odev_01;

/**
* @file Node
* @description Düğüm yapısının kodlandığı kısımdır.
* @assignment Odev -1-
* @date 10/12/2020
* @author Muhammet Furkan ÖZEN muhammetfurkan.ozen@stu.fsm.edu.tr
*/

public class Node {
    public Node next;

    public Node() {                                                             // Gerekli tanımlamalar yapıldı.
    }
    public int oncelik;
    public int sure;
    public String ad_soyad;

    public Node getNext() {
        return next;
    }

    public int getOncelik() {
        return oncelik;
    }

    public int getSure() {
        return sure;
    }
    
    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public void setOncelik(int oncelik) {
        this.oncelik = oncelik;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }
    
    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }
    
}
