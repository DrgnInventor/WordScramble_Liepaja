package burtuJuuklis;
public class Galvenais {
    public static void main(String[] args){
        Tabula pauls = new Tabula();

        Lasitajs ls = new Lasitajs();

        BurtuJuklis bj = new BurtuJuklis(20);

        Rezultati rez = new Rezultati();

        Speletajs sp = new Speletajs("vārds");

        rez.dzēs_rezultātus();

        pauls.printTabula(bj.rezgaBuvesana(ls.lasiVardus()));
        }

    }
