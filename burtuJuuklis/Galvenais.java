package burtuJuuklis;

import java.util.Scanner;

public class Galvenais {
    
    public static void main(String[] args){
        Tabula tb = new Tabula();
        Scanner spiedpogdēlis = new Scanner(System.in);
        Lasitajs ls = new Lasitajs();
        BurtuJuklis bj = new BurtuJuklis(3, 10);
        Adreses ad = new Adreses();
        System.out.println("Ievadi savu vārdu :)");
        Speletajs sp = new Speletajs(spiedpogdēlis.next());
        Interfeis face = new Interfeis();
        Rezultati rez = new Rezultati();

        char[][] brtj = bj.rezgaBuvesana(ls.lasiVardus(), ad); //izveido rezgi
        if(bj.tabulaDer == true){//parbauda vai rezgis ir izdevies
            tb.printTabula(brtj);}
        
        face.x = bj.platums;
        face.y = bj.garums;
        
        sp.sak_laiks(); // speles sakums
        face.userInput(bj, ad, tb);
        sp.beigu_laiks(); // speles beigas
        System.out.println("Hahaha tu spelejis: " + sp.speletais_laiks + "\nTu suka saja spele lmao");
        rez.labakie_rezultati();
        if (rez.sakartoti_aug_sec_rez.length >= 5){for (int i=0 ; i < 5;i++){System.out.println( (i + 1) +". " + rez.sakartoti_aug_sec_rez[i]);}} else {for (int i=0 ; i < rez.sakartoti_aug_sec_rez.length;i++){System.out.println( (i + 1) +". " + rez.sakartoti_aug_sec_rez[i]);}
         spiedpogdēlis.close();
}}}
