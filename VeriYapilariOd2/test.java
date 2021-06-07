/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeriYapilariOd2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


/**
* @file 1721221019_MuhammetFurkanÖzen
* @description Dosyadan okunan verilerle BST oluşturup işletmek.
* @assignment Ödev 2
* @date 20.01.2021
* @author Muhammet Furkan Özen muhammetfurkan.ozen@stu.fsm.edu.tr
*/
public class test {

    private static String getName(Scanner nameScanner) {                            
        nameScanner.useDelimiter("=");

        String nameTitle = nameScanner.next();

        return nameScanner.next();
    }

    public static void main(String[] args) {
        BST bst = new BST();
        Scanner scnDevamMi = new Scanner(System.in);
        String DevamMi = "D";                                                       //WHİLE DONGUSU DEVAM KONTROLU
        int macSeriWin1 = 0 , macSeriWin2 = 0;                                      //5 ROUND ÜST ÜSTE KAZANMA DURUMUNDA PROGRAMI BİTİRECEK
        int oyuncu1Skor = 0 , oyuncu2Skor = 0;                                      //OYUNCULARIN TOPLAM SKORLARINI TUTACAK..
        int turSayisi = 1;                                                          //Tur sayısını tutar.
        
        //**********************
        //DOSYADAN OKUMA KISMI
        //**********************
        
        String Dosya1 = "oyuncu1.txt";                                              //***
        String Dosya2 = "oyuncu2.txt";                                              //Dosyaları daha basit isimlendirdik.

        String contents = null;                         
        try {
            contents = new String(Files.readAllBytes(Paths.get(Dosya1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        
        String[] oyuncu1 = contents.split("#");
        for (String oyuncu_1 : oyuncu1) {
            //System.out.println(oyuncu_1);
            bst.oyuncu_1_Ekle(Integer.parseInt(oyuncu_1));                          //OYUNCU 1 EKLE METODU ÇAĞIRILDI.   
        }
        contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get(Dosya2)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String[] oyuncu2 = contents.split("#");
        for (String oyuncu_2 : oyuncu2) {
            //System.out.println(oyuncu_2);
            //OYUNCU 2 EKLE METODU BURADA ÇAĞIRILACAK1!!
            bst.oyuncu_2_Ekle(Integer.parseInt(oyuncu_2));
        }
        
        while ("D".equals(DevamMi) && macSeriWin1 < 5 && macSeriWin2 < 5 && turSayisi != 21 || "d".equals(DevamMi) && macSeriWin1 < 5 && macSeriWin2 < 5 && turSayisi != 21) {
            System.out.println("====================================================="); // Odev içeriği kısmında yoktu fakat görüntüyü güzelliştirmek için koyuldu...
            bst.postorder_oyuncu_1();
            System.out.println("*****************************************************");
            bst.postorder_oyuncu_2();
    
            
            if (bst.sizeOf_1()<bst.sizeOf_2()){                                     //OYUNCU 1 KAZANMA DURUMU
                macSeriWin2 = 0;                                                    //oyuncu2 in kazanma serisi bozuldu
                macSeriWin1++;
                oyuncu1Skor++;
                System.out.println("======Oyuncu 1 bu turu kazandi======");
                bst.oyuncu_1_Ekle(bst.max_oyuncu_2());
                // oyuncu 2 sil Max
                bst.oyuncuSil_2(bst.max_oyuncu_2());
                //bst.oyuncu_2_Ekle(bst.root1.data);
                bst.oyuncu_2_Ekle(bst.root1.data);
                // bst.root1 sil
                bst.oyuncuSil_1(bst.root1.data);
                
            }else if (bst.sizeOf_1()>bst.sizeOf_2()){                               // OYUNCU 2 KAZANMA DURUMU
                macSeriWin1 = 0;                                                    //oyuncu1 in kazanma serisi bozuldu
                macSeriWin2++;
                oyuncu2Skor++;                          
                System.out.println("======Oyuncu 2 bu turu kazandi======");
                bst.oyuncu_2_Ekle(bst.max_oyuncu_1());
                bst.oyuncuSil_1(bst.max_oyuncu_1());
                bst.oyuncu_1_Ekle(bst.root2.data);
                bst.oyuncuSil_2(bst.root2.data);
                
            }else{                                                                  // BERABERLİK DURUMU        
                macSeriWin1 = macSeriWin2 = 0;                                      // iki oyuncu içinde kazanma serisi bozuldu
                System.out.println("======Berabere, bu turun kazanani yok======");
                bst.preorder_1();                                                   // FONKSİYONLAR YARDIMIYLA KÖKLER DEĞİŞİP BST'DEKİ DATALAR DİZİLERE ATILDI..
                bst.preorder_2();                                                   // ******
                //bst.diziKontrol();                                                // DİZİLERİN DEĞERLERİ DOĞRU ALIP ALMADIĞI KONTROL EDİLEBİLİR!!
                bst.bstBerabereEkle();                                              // DİZİDEKİ DEĞERLER YARDIMIYLA BST OLUŞTURULDU...
            }
            
            System.out.println("Tur "+(turSayisi++)+" Toplam Skor \nOyuncu1: "+ oyuncu1Skor+"\nOyuncu2: "+oyuncu2Skor);
            
            // *******************
            // TEKRAR KISMI
            // *******************
            
            bst.resetSizeOfTrees();                                                 // HER TUR SONU STATİC DEĞERLER SIFIRLANIR!
            System.out.println(" Devam Etmek Ister misiniz ? (D/d) ");  
            DevamMi = scnDevamMi.nextLine();                                        // SCANNER YARDIMIYLA KULLANICIDAN DEĞER ALINDI.
        }
        // ******************
        // SON ÇIKTI KISMI
        // ******************
        
        System.out.println("======Mac Sonucu======");
        
        if (turSayisi == 21){                                                       //20 TUR SONUNDA HANGİ OYUNCUNUN SKORU BÜYÜKSE O KAZANIR...//son while dongusunde tur sayisi 21 olur ve içeri giremez...
            if (oyuncu1Skor > oyuncu2Skor){                                         // OYUNCU 1 KAZANMA DURUMU
                System.out.println("20 tur sonunda kazan : Oyuncu 1 ");
            }else if (oyuncu2Skor > oyuncu1Skor){                                   // OYUNCU 2 KAZANMA DURUMU
                System.out.println("20 tur sonunda kazan : Oyuncu 2 ");
            }else {                                                                 // BERABERLİK DURUMU
                System.out.println("20 tur sonunda skorlar eşit. Berabere...");
            }
        }else if (macSeriWin1 == 5){                                                    // ÜST ÜSTE 5 DEFA KAZANILIP KAZANILMADIĞI KONTROL EDİLİR..
            System.out.println("5 tur ust uste kazanma sonucunda kazanan: oyuncu 1");   // ******
        }else if (macSeriWin2 == 5){                                                    // ******
            System.out.println("5 tur ust uste kazanma sonucunda kazanan: oyuncu 2");   // ******
        }else {                                                                     // ÜSTTEKİ İF VE ELSE E GİRMEMESİ DURUMUNDA ERKEN BİR ÇIKIŞ OLDUĞU ANLAŞILIR VE 
            System.out.println("Erken cıkış yapıldı..");                            // SKORU YÜKSEK OLAN OYUNCU OYUNU KAZANIR.
            if(oyuncu1Skor > oyuncu2Skor){
                System.out.println("Kazanan : Oyuncu 1");
            }else if(oyuncu2Skor > oyuncu1Skor){
                System.out.println("Kazanan : Oyuncu 2");
            }else{                                                                  // BERABERLİK DURUMUNDA KAZANAN OLMAZ.
                System.out.println("Berabere..");
            }
        }
        System.out.println("======Oyun Bitti======");                               // OYUN SONU ÇIKTISI...

    }

}
