public class Galvenais {
    public static void main(String[] args){
        Tabula pauls = new Tabula();

        Lasitajs ls = new Lasitajs();

        BurtuJuklis bj = new BurtuJuklis(10000);

        
        pauls.printTabula(bj.rezgaBuvesana(ls.lasiVardus()));

    }

}
