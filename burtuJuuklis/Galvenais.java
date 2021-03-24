package burtujuuklis;

import burtuJuuklis.Adreses;


public class Galvenais {
    
    public static void main(String[] args){
        Tabula tb = new Tabula();
        Lasitajs ls = new Lasitajs();
        BurtuJuklis bj = new BurtuJuklis(10, 26);
        Adreses ad = new Adreses();
        char[][] brtj = bj.rezgaBuvesana(ls.lasiVardus(), ad); //izveido rezgi
        if(bj.tabulaDer == true){//parbauda vai rezgis ir izdevies
            tb.printTabula(brtj);
    }
}
}