package burtuJuuklis;

import java.text.SimpleDateFormat;

public class Speletajs {
    
    public String vards;
    public String speletais_laiks;
    
    private Long sakuma_laiks;
    private Long beigu_laiks;
    private Long laiks_ms;
    private Rezultati rez = new Rezultati();
    
    public Speletajs(String vards) {
        this.vards = vards;
      }

    /**
     * Publsiki izmantotās metodes.
     * sak_laiks() uzņem spēles sākuma laiku
     * beigu_laiks() uzņem spēles beigu laiku, aprēķina spēles laiku, pieraksta rezultātu
     */
    public void sak_laiks(){
        sakuma_laiks = System.currentTimeMillis();
    }

    public void beigu_laiks(){
        beigu_laiks = System.currentTimeMillis();
        
        Long speles_laiks = beigu_laiks - sakuma_laiks; // aprekina speles laiku
        laiks_ms = speles_laiks;
         
        SimpleDateFormat formater_brrrr = new SimpleDateFormat("mm:ss");
        speletais_laiks = formater_brrrr.format(laiks_ms);

        rez.rezultatu_uzskaite(speletais_laiks, vards);
    }
}