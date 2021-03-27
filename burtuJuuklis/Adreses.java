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
    public List<Vertibas> rindaVertibam;
    public Vertibas vrtb;
    public int beigas_rinda;
    public int beigas_kolona;
   public int virziens;
   public int rinda;
   public int kolona;
    public Adreses(){
        this.alfabets = new HashMap();
        this.rindaVertibam = new ArrayList();
        for(int i = 0; i < 26; i++){ //uztaisa mapu, kur intiem 1- 26 atbilst alfabeta burts
            alfabets.put(i, (char)(i + 17 + '0'));
        }
        
    }
    public char getBurts(int skaitlis){ //atgriez atbilstoso burtu padotajam skaitlim
        return alfabets.get(skaitlis);
    }
    public int getSkaitlis(char burts){ //atgriez atbilstoso skaitli padotajam burtam
        int skaitlis = 0;
        while(alfabets.get(skaitlis) != burts){
            skaitlis++;
        }
        return skaitlis;
    } 
    public void rindaArKoordinatam(int virz, int varda_garums, int rind, int kolon){ //pievieno rindai info par varda atrasanas vietu
        this.virziens = virz;
        this.rinda = rind;
        this.kolona = kolon;
        switch(virziens){
            case 0:
                beigas_rinda = rinda;
                beigas_kolona = varda_garums + kolona;
                break;
            case 1:
                beigas_rinda = varda_garums + rinda;
                beigas_kolona = kolona;
                break;
            case 2:
                beigas_rinda = varda_garums + rinda;
                beigas_kolona = varda_garums + kolona;
                break;
        }
        vrtb = new Vertibas(virziens, rinda, kolona, beigas_rinda, beigas_kolona);
        rindaVertibam.add(vrtb);
    }
    
    public boolean salidzinatKoordinates(char burts_sakums, int rinda_sakums, char burts_beigas, int rinda_beigas){
        //salīdzina dotās koordinātas ar tām, kas vērtību rindā, atgriež true or false atbilstoši
        int kolona_sakums = getSkaitlis(burts_sakums);
        int kolona_beigas = getSkaitlis(burts_beigas) + 1;
        boolean tr = true;
        for(int i = 0; i < rindaVertibam.size(); i++){
            int sakums_rinda = rindaVertibam.get(i).getSakumsRinda();
            int sakums_kolona = rindaVertibam.get(i).getSakumsKolona();
            int beigas_rinda_list = rindaVertibam.get(i).getBeigasRinda();
            int beigas_kolona_list = rindaVertibam.get(i).getBeigasKolona();
            if(sakums_rinda == rinda_sakums && sakums_kolona == kolona_sakums && beigas_rinda_list == rinda_beigas && beigas_kolona_list == kolona_beigas){
                tr = true;
                break;
            }else tr = false;
        }
        return tr;
    }
    
   
}
