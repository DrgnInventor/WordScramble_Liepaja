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
    public void rindaArKoordinatam(int virziens, int varda_garums, int rinda, int kolona){ //pievieno rindai info par varda atrasanas vietu
        
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
        System.out.println("salidzinatKoordinates Input " + burts_sakums +" "+ rinda_sakums + " " + burts_beigas + " " + rinda_beigas);
        int kolona_sakums = getSkaitlis(burts_sakums);
        System.out.println("ks "+kolona_sakums);
        int kolona_beigas = getSkaitlis(burts_beigas);
        System.out.println("kb "+kolona_beigas);
        boolean tr = false;
        System.out.println("For limits " + rindaVertibam.size());
        for(int i = 0; i < rindaVertibam.size(); i++){
            int sakums_rinda = rindaVertibam.get(i).getSakumsRinda();
            int sakums_kolona = rindaVertibam.get(i).getSakumsKolona();
            int beigas_rinda = rindaVertibam.get(i).getBeigasRinda();
            int beigas_kolona = rindaVertibam.get(i).getBeigasKolona();
            System.out.println(i + " " + sakums_rinda +" "+sakums_kolona+" "+beigas_rinda+" "+beigas_kolona);
            if(sakums_rinda == rinda_sakums && sakums_kolona == kolona_sakums && beigas_rinda == rinda_beigas && beigas_kolona == kolona_beigas){
                tr = true;
                break;
            }else tr = false;
        }
        return tr;
    }
    
   
}
