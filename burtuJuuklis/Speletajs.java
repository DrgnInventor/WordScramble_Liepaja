package burtuJuuklis;

import java.text.SimpleDateFormat;

public class Speletajs {
    
    public Long sakuma_laiks; //sakuma laiks ms
    public Long beigu_laiks; // beigu laiks ms
    public Long laiks_ms; // glaba laiku ms
    public String vards; // glaba vardu
    public String speletais_laiks; // speltais laiks
    public Rezultati rez = new Rezultati();
    public Speletajs(String vards) {
        this.vards = vards;
      }

    public void sak_laiks(){
        sakuma_laiks = System.currentTimeMillis(); // uznem sakuma laiku
    }

    public void beigu_laiks(){
        SimpleDateFormat formater_brrrr = new SimpleDateFormat("mm:ss");
        beigu_laiks = System.currentTimeMillis(); // uznem beigu laiku
        Long speles_laiks = beigu_laiks - sakuma_laiks; // aprekina speles laiku
        laiks_ms = speles_laiks;
        rez.rezultatu_uzskaite(laiks_ms, vards);
        speletais_laiks = formater_brrrr.format(laiks_ms);
    }
}