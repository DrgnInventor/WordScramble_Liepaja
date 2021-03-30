package burtuJuuklis;

public class test_rez_uzskaite {
    public static void main(String[] args){
        Speletajs skolnieks = new Speletajs("Pauls");
        skolnieks.sakLaiks();
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        skolnieks.beiguLaiks();
    }

}


