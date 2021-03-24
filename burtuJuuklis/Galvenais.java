package burtuJuuklis;


public class Galvenais {
    
    public static void main(String[] args){
        Tabula tb = new Tabula();
        Lasitajs ls = new Lasitajs();
        BurtuJuklis bj = new BurtuJuklis(10, 26);
        Adreses ad = new Adreses();
        Speletajs sp = new Speletajs("Pauls");
        Interfeis face = new Interfeis();

        char[][] brtj = bj.rezgaBuvesana(ls.lasiVardus(), ad); //izveido rezgi
        if(bj.tabulaDer == true){//parbauda vai rezgis ir izdevies
            tb.printTabula(brtj);}
        
        face.x = bj.platums;
        face.y = bj.garums;
        
        sp.sak_laiks(); // speles sakums
        
        face.userInput();
        

        sp.beigu_laiks(); // speles beigas
}
}