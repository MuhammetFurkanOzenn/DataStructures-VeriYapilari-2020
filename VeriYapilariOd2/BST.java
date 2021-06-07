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
public class BST {

    Node root1, root2;
    int root1DataTemp, root2DataTemp;
    String fileName1 = "oyuncu1.txt";
    String fileName2 = "oyuncu2.txt";

    static int[] dizi  = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] dizi2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int i = 0;
    
    void diziKontrol (){                                                            // BERABERLİK DURUMUNDA BST'LERİ PREORDER GEZEREK DATA'LAR DİZİLERE ATILDI.
        System.out.println("====oyuncu1 dizisi====");                               // DEĞERLERİN DİZİLERE DOĞRU ŞEKİLDE GELİP GELMEDİĞİ KONTROL EDİLİYOR.
        for (int j = 0; j < 10; j++) {                                     
            System.out.println(dizi[j]);
        }
        
        System.out.println("");
        System.out.println("====oyuncu2 dizisi====");
        for (int j = 0; j < 10; j++) {
            System.out.println(dizi2[j]);
        }
        
    }
    void preorder_1() {

        root1DataTemp = root1.data;                                                 // BERABERLİK DURUMUNDA ROOT DEĞERLERİ TEMPROOT'LAR YARDIMIYLA YER DEĞİŞTİRİR.
        root2DataTemp = root2.data;                                                 //****
        root1.data = root2DataTemp;                                                 //****
        root2.data = root1DataTemp;                                                 //****
        i = 0;                                                                      // STATİC İ DEĞERİ DİZİ İNDİSLERİNİ TUTARKEN KULLANILIR. FONKSİYON RECURSİVE OLDUĞU İÇİN 
        preorderFor_1(root1);                                                       // STATİC BİR İNTEGER DEĞER YARDIMIYLA KONTROL EDİLİR.
    }

    void preorder_2() {
        i = 0;
        preorderFor_2(root2);
    }

    private void preorderFor_1(Node node) {                                         // DİZİLERİ BST'DEKİ DEĞERLERİ PREORDER OLARAK GEZEREK DOLDURMA İŞLEMİ...
        if (node != null) {  
            dizi[i++] = node.data;
            preorderFor_1(node.leftChild);
            preorderFor_1(node.rightChild);
        }
    }

    private void preorderFor_2(Node node) {                                         // DİZİLERİ BST'DEKİ DEĞERLERİ PREORDER OLARAK GEZEREK DOLDURMA İŞLEMİ...
        if (node != null) {    
            dizi2[i++] = node.data;
            preorderFor_2(node.leftChild);
            preorderFor_2(node.rightChild);
        }
    }

    void bstBerabereEkle() {                                                        // BERABERLİK DURUMUNDA DİZİLERDEN GELEN DEĞERLER İLE SIFIRDAN BST OLUŞTURMA... 
        root1=root2=null;                                                           // TÜM DATALAR DİZİLERDE OLDUĞU İÇİN root1 ve root2 LERİ NULL YAPIYORUZ...
        for (int j = 0; j < 10; j++) {                                              // VE DİZİLERDEKİ DEĞERLER DÖNGÜ YARDIMIYLA root1 ve root2 YE BST OLACAK ŞEKİLDE EKLENİR...
            int newData = dizi[j];
            Node newNode = new Node(newData);

            if (root1 == null) {
                root1 = newNode;
            } else {
                Node temp = root1;

                while (temp != null) {
                    if (newData > temp.data) {                                      // yeni değer node'dan büyükse sağ alt nodu olur..
                        if (temp.rightChild == null) {
                            temp.rightChild = newNode;
                            break;
                        }
                        temp = temp.rightChild;
                    } else if (newData <= temp.data) {                              //yeni değer node'a eşit YADA küçükse sol alt nodu olur..
                        if (temp.leftChild == null) {
                            temp.leftChild = newNode;
                            break;
                        }
                        temp = temp.leftChild;
                    } else {
                        break;
                    }

                }
            }
        }

        for (int j = 0; j < 10; j++) {                                              // OYUNCU 2 BST'Sİ İÇİN DÖNGÜ VE İŞLEMLER...
            int newData = dizi2[j];
            Node newNode = new Node(newData);

            if (root2 == null) {
                root2 = newNode;
            } else {
                Node temp = root2;

                while (temp != null) {
                    if (newData > temp.data) {
                        if (temp.rightChild == null) {
                            temp.rightChild = newNode;
                            break;
                        }
                        temp = temp.rightChild;
                    } else if (newData <= temp.data) {
                        if (temp.leftChild == null) {
                            temp.leftChild = newNode;
                            break;
                        }
                        temp = temp.leftChild;
                    } else {
                        break;
                    }
                        
                }
            }
        }
    }

    void postorder_oyuncu_1() {                                                     // MENU ÇIKTISINDAKİ İLGİLİ FONKSİYON..
        System.out.println("oyuncu1 ağacı post order gezinti sonucu : ");
        postorder(root1);
        System.out.println();
        System.out.println("oyuncu1 ağaci toplam soy sayisi : " + sizeOf_1());      // TOPLAM SOY SAYISI GÖSTERİLMEKTE.
    }

    void postorder_oyuncu_2() {                                                     // MENU ÇIKTISINDAKİ İLGİLİ FONKSİYON..
        System.out.println("oyuncu2 ağacı post order gezinti sonucu : ");
        postorder(root2);
        System.out.println();
        System.out.println("oyuncu2 ağaci toplam soy sayisi : " + sizeOf_2());      // TOPLAM SOY SAYISI GÖSTERİLMEKTE.
    }
    static int size_1 = 0;                                                          // 
    static int size_2 = 0;

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            node.soy = postorderForSize(node);                                      // ALTTAKİ postorderForSize FONKSİYONUNDAN GELEN DEĞERİ İLGİLİ NODE'UN SOY DEĞİŞKENİNE ATAR.
            System.out.print("[" + node.data + "," + node.soy + "]-");
            sizee = -1;                                                             // FONKSİYON HER ÇAĞRILDIĞINDA DEĞİŞKEN -1 YAPILIR. 
        }                                                                           // SOY SAYISINI BULABİLMEK İÇİN POSTORDER DOLAŞILIR VE HER DOLAŞMADA sizee BİR ARTAR.
    }                                                                               // SUBTREEsi OLMAYAN BİR NODE İÇİN 1 DEFA POSTORDER DOLAŞILIR VE sizee -1 DEN 0 A GÜNCELLENİR.
    static int sizee = -1;                                                          // EĞER SUBTREEsi VARSA DA KENDİSİ HARİÇ DİĞER NODEları SOY SAYISINDA TUTAR.

    int postorderForSize(Node node) {                                               // HER BİR NODE'UN SUBTREE'SİNDEKİ NODELARIN SAYISINI DÖNDÜRÜR.
        if (node != null) {
            postorderForSize(node.leftChild);
            postorderForSize(node.rightChild);
            sizee++;                                                                
        }
        return sizee;
    }

    int sizeOf_1() {                                                                // ALTTAKİ RECURSİVE postorder_1 FONKSİYONUNA root1 BAŞLANGIÇ DEĞERİ VERİLİR.
        return postorder_1(root1);
    }

    int sizeOf_2() {                                                                // ALTTAKİ RECURSİVE postorder_2 FONKSİYONUNA root2 BAŞLANGIÇ DEĞERİ VERİLİR.
        return postorder_2(root2);
    }

    private int postorder_1(Node node) {                                            // SOY SAYISINI BULMAK İÇİN DÜZENLENMİŞ BİR POSTORDER.
        if (node != null) {
            postorder_1(node.leftChild);
            postorder_1(node.rightChild);

            size_1 += node.soy;                                                     // HER BİR NODE'UN SOY SAYILARINI TOPLAYARAK HER TUR SONU TOPLAM SOY SAYISINI GERİ DÖNDÜRÜR.
        }
        return size_1;
    }

    private int postorder_2(Node node) {                                            // SOY SAYISINI BULMAK İÇİN DÜZENLENMİŞ BİR POSTORDER.
        if (node != null) {
            postorder_2(node.leftChild);
            postorder_2(node.rightChild);

            size_2 += node.soy;                                                     // HER BİR NODE'UN SOY SAYILARINI TOPLAYARAK HER TUR SONU TOPLAM SOY SAYISINI GERİ DÖNDÜRÜR.

        }
        return size_2;
    }

    void resetSizeOfTrees() {                                                       // STATİC TANIMLANMIŞ DEĞERLER HER TUR SONU ÇAĞRILAN BU METOTLA SIFIRLANIR.
        size_1 = 0;
        size_2 = 0;
    }

  
    void oyuncu_1_Ekle(int newData) {                                               // BST'YE DÜĞÜM EKLEME METODU
        Node newNode = new Node(newData);

        if (root1 == null) {
            root1 = newNode;
        } else {
            Node temp = root1;

            while (temp != null) {
                if (newData > temp.data) {                                          // yeni değer node'dan büyükse sağ alt nodu olur..
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        return;
                    }
                    temp = temp.rightChild;
                } else if (newData <= temp.data) {                                  //yeni değer node'a eşit yada küçükse sol alt nodu olur..
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        return;
                    }
                    temp = temp.leftChild;
                } else {
                    return;
                }

            }
        }

    }

    void oyuncu_2_Ekle(int newData) {                                               // BST'YE DÜĞÜM EKLEME METODU
        Node newNode = new Node(newData);

        if (root2 == null) {
            root2 = newNode;
        } else {
            Node temp = root2;

            while (temp != null) {
                if (newData > temp.data) {
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        return;
                    }
                    temp = temp.rightChild;
                } else if (newData <= temp.data) {
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        return;
                    }
                    temp = temp.leftChild;
                } else {
                    return;
                }

            }
        }

    }

    int max_oyuncu_1() {                                                            /// OYUNCU 1 VE 2 İÇİN ÖZELLEŞTİRİLMİŞ MAX DEĞER BULMA METOTLARI
        return max(root1);                                                          /// *****
    }

    ;
    int max_oyuncu_2() {                                                            /// *****
        return max(root2);
    }

    ;
    
    int max(Node root) {                                                            // BİR DÜĞÜMÜN NULL DEĞER GELENE KADAR SÜREKLİ SAĞ ALTINA GİDİLİRSE MAX DEĞERDEKİ DÜĞÜMÜ BULUNUR.
        Node temp = root;
        int maxV = root.data;
        while (temp.rightChild != null) {
            maxV = temp.rightChild.data;
            temp = temp.rightChild;
        }
        return maxV;
    }

    void oyuncuSil_1(int silinecekData) {                                           // OYUNCU 1 VE 2 İÇİN ÖZELLEŞTİRİLMİŞ SİLME METOTLARI
        root1 = deleteRec(root1, silinecekData);                                    //*****
    }                                                                               //*****
                                                                                    
    void oyuncuSil_2(int silinecekData) {                                           //*****                                    
        root2 = deleteRec(root2, silinecekData);                                    //*****
    }

    Node deleteRec(Node root, int silinecekData) {
        
        if (root == null) {
            return root;
        }
        if (silinecekData < root.data) {
            root.leftChild = deleteRec(root.leftChild, silinecekData);
        } else if (silinecekData > root.data) {
            root.rightChild = deleteRec(root.rightChild, silinecekData);
        } 
        else {
            if (root.leftChild == null) {                                           //SOL ÇOCUĞU YOKSA; SAĞ ÇOCUĞU DA YOKSA NULL DÖNER, SAĞ ÇOCUĞU VARSA SAĞ ÇOCUĞU DÖNER.
                return root.rightChild;
            } else if (root.rightChild == null) {                                   //SAĞ ÇOCUĞU YOKSA ÖNCEKİ İF'E DE GİRMEDİYSE SOL ÇOCUĞU VAR DEMEKTİR. SOL ÇOCUĞU DÖNER.
                return root.leftChild;                          
            }

            
            root.data = max(root.leftChild);                                         
            root.leftChild = deleteRec(root.leftChild, root.data);
        }

        return root;
    }
}
