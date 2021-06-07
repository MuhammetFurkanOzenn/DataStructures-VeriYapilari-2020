/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odev_01;

/**
* @file Kuyruk
* @description Kuyruk yapısının kodlandığı kısımdır. (Ekle - Cıkar - Göster Metodları yazılmıstır.)
* @assignment Odev -1-
* @date 10/12/2020
* @author Muhammet Furkan ÖZEN muhammetfurkan.ozen@stu.fsm.edu.tr
*/
public class Kuyruk {

    Node head_0 = null, head_1 = null, head_2 = null, tail_0 = null, tail_1 = null, tail_2 = null, temp = null;

    void addLast(String ad, int sure, int oncelik) {
        Node newNode = new Node();                                  // Değişkenler tanımlnıyor
        newNode.ad_soyad = ad;                                      // ...
        newNode.oncelik = oncelik;                                  // ...
        newNode.sure = sure;                                        // ...

        if (oncelik == 0) {                                         // EĞER 0. ONCELİĞE SAHİPSE 
            if (head_0 == null) {                                   // head_0 null ise
                head_0 = newNode;                                   // head_0 ve 
                tail_0 = newNode;                                   // tail_0'e newNode atılır.
            } else {                                                // head_0 NULL DEĞİL ise
                tail_0.next = newNode;                              // Kuyruğun next node'unu newNode yapıyoruz.
                tail_0 = newNode;                                   // Kuyruğu güncelliyoruz.       
            }
            if (head_1 != null)                                     // Öncelik sırası 1 olan dizi dolu ise 0. linked list'in kuyruğunun
            tail_0.next = head_1;                                   //  sonraki düğümünü 1. listenin başı olarak güncelleriz.
            else {                                                  // EĞER head_1 null ise 1. önceliğe sahip eleman yoktur ve
                tail_0.next = head_2;                               // tail_0'ı head_2'ye bağlamız gerekir.
            }
        } else if (oncelik == 1) {                                  // EĞER 1. ÖNCELİĞE SAHİPSE
            if (head_1 == null) {                                   // head_1 null ise (liste boşsa)
                head_1 = newNode;                                   // head_1 ve 
                tail_1 = newNode;                                   // tail_1 'e newNode atılır.
            } else {                                                // head_1 NULL DEĞİL ise
                tail_1.next = newNode;                              
                tail_1 = newNode;
            }
            if (head_0 != null) {                                   // 0. Önceliğe sahip liste dolu ise
                tail_0.next = head_1;                               //  0. listenin tail'inin next node'unu 1. önceliğe 
            }                                                       //  sahip listenin head'i olarak güncelledik.
            if (head_2 != null) {                                   // 2. Önceliğe sahip liste dolu ise
                tail_1.next = head_2;                               // 1. önceliğe sahip listenin tail'inin next node'u 2. önceliğe
            }                                                       // sahip listenin head'i olarak güncellenir.
        } else if (oncelik == 2) {
            if (head_2 == null) {                                   // head_2 null ise (liste boşsa)
                head_2 = newNode;                                   // head_2 ve 
                tail_2 = newNode;                                   // tail_2 'e newNode atılır.
            } else {                                                // head_2 NULL DEĞİL ise
                temp = head_2;                                      // head_2 temp' atılıyor.
                tail_2.next = newNode;
                tail_2 = newNode;

            }

        } else {
            System.out.println("yanlış değer..1!");
        }

    }

    Node remove() {
        Node temp = null;
        if (head_0 != null) {                                       // Önce 0. öncelikten çıkarmaya başlıyoruz.
            temp = head_0;
            if (head_0 != tail_0) {                                 //tail ve head eşit değilse head'i bir arttır.
                //head_0.next = head_0          yanlış yazılan kod
                head_0 = head_0.next;
            } else {                                                // tail ve head eşitse ikisini de null yap
                head_0 = null;                                  
                tail_0 = null;
            }
        } else if (head_1 != null) {                                // 0. Öncelik eleman kalmadıysa 1. öncelikten elemanlar çıkarılır
            temp = head_1;
            if (head_1 != tail_1) {                                 //tail ve head eşit değilse head'i bir arttır.
                //head_1.next = head_1         yanlış yazılan kod
                head_1 = head_1.next;
            } else {                                                // tail ve head eşitse ikisini de null yap
                head_1 = null;
                tail_1 = null;
            }

        } else if (head_2 != null) {                                // 1. Öncelik eleman kalmadıysa 2. öncelikten elemanlar çıkarılır
            temp = head_2;
            if (head_2 != tail_2) {                                 //tail ve head eşit değilse head'i bir arttır.
                //head_2.next = head_2;         yanlış kod
                head_2 = head_2.next;
            } else {                                                // tail ve head eşitse ikisini de null yap
                head_2 = null;
                tail_2 = null;
            }
        } else {
            System.out.println("Kuyruk boş... Kuyruktan musteri silinemedi...");
        }
        return temp;
    }

    Node anlikNode() {                                              // Anlık düğümü geri döndüren metot
        Node anlik = null;
        if (head_0 != null) {
            anlik = head_0;
        } else if (head_1 != null) {
            anlik = head_1;
        } else if (head_2 != null) {
            anlik = head_2;
        } else {
            System.out.println("Kuyruk bos... Anlik müsteri gösterilemedi...");
        }

        return anlik;
    }

    void print() {
        Node tempPrint;
        if (head_0 != null) {
            tempPrint = head_0;

            while (tempPrint != null) {
                System.out.println("isim :  " + tempPrint.ad_soyad + " öncelik :    " + tempPrint.oncelik + " sure :  " + tempPrint.sure);

                tempPrint = tempPrint.next;
            }
        } else if (head_1 != null) {
            tempPrint = head_1;

            while (tempPrint != null) {
                System.out.println("isim :  " + tempPrint.ad_soyad + " öncelik :    " + tempPrint.oncelik + " sure :  " + tempPrint.sure);

                tempPrint = tempPrint.next;
            }
        } else if (head_2 != null) {
            tempPrint = head_2;
            while (tempPrint != null) {
                System.out.println("isim :  " + tempPrint.ad_soyad + " öncelik :    " + tempPrint.oncelik + " sure :  " + tempPrint.sure);

                tempPrint = tempPrint.next;
            }

        }

    }

    String printUst() {                                                         //1. textArea'ya kuyruğu yazdıran metot
        String s = "";                                                          //=("[(" +  + ")(" + sonucAd + "-" + sonucSure + ")] -> ");
        Node tempPrint;
        if (head_0 != null) {
            tempPrint = head_0;

            while (tempPrint != null) {
                s += ("[(" + tempPrint.oncelik + ")(" + tempPrint.ad_soyad + "-" + tempPrint.sure + ")] -> ");

                tempPrint = tempPrint.next;
            }
        } else if (head_1 != null) {
            tempPrint = head_1;

            while (tempPrint != null) {
                s += ("[(" + tempPrint.oncelik + ")(" + tempPrint.ad_soyad + "-" + tempPrint.sure + ")] -> ");

                tempPrint = tempPrint.next;
            }
        } else if (head_2 != null) {
            tempPrint = head_2;
            while (tempPrint != null) {
                s += ("[(" + tempPrint.oncelik + ")(" + tempPrint.ad_soyad + "-" + tempPrint.sure + ")] -> ");

                tempPrint = tempPrint.next;
            }
        }
        s += "null";
        return s;
    }
}
