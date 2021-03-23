package burtuJuuklis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author darta
 */
public class Adreses {
    private Map<Integer, Character> alfabets;
    private List<Vertibas> rindaVertibam;
    public Adreses(){
        this.alfabets = new HashMap();
        this.rindaVertibam = new ArrayList();
        for(int i = 0; i < 26; i++){ //uztaisa mapu, kur intiem 1- 26 atbilst alfabeta burts
            alfabets.put(i, (char)(i + 17 + '0'));
        }
    }
    public char skaitlisBurta(int skaitlis){ //atgriez atbilstoso burtu padotajam skaitlim
        return alfabets.get(skaitlis);
    }
    public int burtsSkaitli(char burts){ //atgriez atbilstoso skaitli padotajam burtam
        int skaitlis = 0;
        while(alfabets.get(skaitlis) != burts){
            skaitlis++;
        }
        return skaitlis;
    } 
    public void rindaArKoordinatam(char[] vards, int virziens, int rinda, int kolona){ //pievieno rindai info par varda atrasanas vietu
        int varda_garums = vards.length;
        int rinda_beigas = rinda;
        int kolona_beigas = kolona;
        switch(virziens){
            case 0:
                rinda_beigas = rinda;
                kolona_beigas = varda_garums + kolona;
                break;
            case 1:
                rinda_beigas = varda_garums + rinda;
                kolona_beigas = kolona;
                break;
            case 2:
                rinda_beigas = varda_garums + rinda;
                kolona_beigas = varda_garums + kolona;
                break;
        }
        Vertibas vrtb = new Vertibas(vards, rinda, kolona, rinda_beigas, kolona_beigas);
        rindaVertibam.add(vrtb);
    }
    
    
}
