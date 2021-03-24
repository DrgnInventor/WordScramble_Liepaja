package burtuJuuklis;  
public class Speletajs {
    
    public Long sakuma_laiks; //sakuma laiks ms
    public Long beigu_laiks; // beigu laiks ms
    public Long laiks_ms; // glaba laiku ms
    public String vards; // glaba vardu

    public Speletajs(String vards) {
        this.vards = vards;
      }

    public void sak_laiks(){
        sakuma_laiks = System.currentTimeMillis(); // uznem sakuma laiku
    }

    public void beigu_laiks(){
        beigu_laiks = System.currentTimeMillis(); // uznem beigu laiku
        Long speles_laiks = beigu_laiks - sakuma_laiks; // aprekina speles laiku
        laiks_ms = speles_laiks;
    }
}