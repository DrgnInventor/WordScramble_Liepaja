package burtuJuuklis;

public class test_rez_uzskaite {
    public static void main(String[] args){

        Rezultati rez = new Rezultati();
        Speletajs skolnieks = new Speletajs("Pauls");
        skolnieks.sak_laiks();
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        skolnieks.beigu_laiks();
        rez.rezultatu_uzskaite(skolnieks.laiks_ms, skolnieks.vards);
        }

    }




