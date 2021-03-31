import java.text.SimpleDateFormat;

public class Speletajs {
    
    public String vards;
    public String speletaisLaiks;
    
    private Long sakumaLaiks;
    private Long beiguLaiks;
    private Long laiksMs;
    private Rezultati rez = new Rezultati();
    
    /**
     * @param speltais_laiks glaba speles laiku String datu tipa formats mm:ss
     * @param beiguLaiks glaba ms laiku kad spele tika beigta
     * @param sakumaLaiks glaba ms laiku kad spele tika sakta
     */

    public Speletajs(String vards) {
        this.vards = vards;
      }

    /**
     * Publsiki izmantotas metodes.
     * sak_laiks() uznem speles sakuma laiku
     * beigu_laiks() uznem speles beigu laiku, apreķina speles laiku, pieraksta rezultatu
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