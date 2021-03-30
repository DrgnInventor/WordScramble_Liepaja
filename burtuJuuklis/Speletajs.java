package burtuJuuklis;

import java.text.SimpleDateFormat;

public class Speletajs {
    
    public String vards;
    public String speletaisLaiks;
    
    private Long sakumaLaiks;
    private Long beiguLaiks;
    private Long laiksMs;
    private Rezultati rez = new Rezultati();
    
    /**
     * @param speltais_laiks glabā spēles laiku String datu tipā formāts mm:ss
     * @param beiguLaiks glabā ms laiku kad spēle tika beigta
     * @param sakumaLaiks glaba ms laiku kad spēle tika sākta
     */

    public Speletajs(String vards) {
        this.vards = vards;
      }

    /**
     * Publsiki izmantotās metodes.
     * sak_laiks() uzņem spēles sākuma laiku
     * beigu_laiks() uzņem spēles beigu laiku, aprēķina spēles laiku, pieraksta rezultātu
     */
    public void sakLaiks(){
        sakumaLaiks = System.currentTimeMillis();
    }

    public void beiguLaiks(){
        beiguLaiks = System.currentTimeMillis();
        
        Long speles_laiks = beiguLaiks - sakumaLaiks; // aprekina speles laiku
        laiksMs = speles_laiks;
         
        SimpleDateFormat laikaFormatetajs = new SimpleDateFormat("mm:ss");
        speletaisLaiks = laikaFormatetajs.format(laiksMs);

        rez.rezultatuUzskaite(speletaisLaiks, vards);
    }
}