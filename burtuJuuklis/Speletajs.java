package burtuJuuklis;  
public class Speletajs {
    
    public Long sakuma_laiks;
    public Long beigu_laiks;
    public Long laiks_ms;

    public static void main(String[] args){ 
        Speletajs sp = new Speletajs();
        sp.sak_laiks();
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sp.beigu_laiks();
      }

    public void sak_laiks(){
        sakuma_laiks = System.currentTimeMillis();
    }

    public void beigu_laiks(){
        beigu_laiks = System.currentTimeMillis();
        Long speles_laiks = beigu_laiks - sakuma_laiks;
        laiks_ms = speles_laiks;
    }
}