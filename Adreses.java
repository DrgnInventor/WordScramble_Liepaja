import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adreses {
    private Map<Integer, Character> alfabets;
    public List<Vertibas> rindaVertibam;
    public int kartasNr;
    public List<Vertibas> atminetieVardi;
    public List<String> neatminetieVardi;
    public Adreses(){
        alfabets = new HashMap<>();
        rindaVertibam = new ArrayList<>();
        atminetieVardi = new ArrayList<>();
        neatminetieVardi = new ArrayList<>();
        for(int i = 0; i < 26; i++){ //uztaisa mapu, kur intiem 1- 26 atbilst alfabeta burts
            alfabets.put(i, (char)(i + 17 + '0'));
        }
        
    }
    public void putNeatminetieVardi(){ //izveido rindu kur uzglabat neatminetos vardus
        for(int i = 0; i < rindaVertibam.size(); i++){
            neatminetieVardi.add(rindaVertibam.get(i).getVardsString());
        }
    }
    public void getNeatminetieVardi(){ //izprinte neatminetos vardus
        for(int i = 0; i < neatminetieVardi.size(); i++){
            System.out.println(neatminetieVardi.get(i));
        }
    }
    public boolean checkAtminetieVardi(String s){ //parbauda vai vards neatkartojas
        boolean tr = true;
        for(int i = 0; i < atminetieVardi.size(); i++){
            if(atminetieVardi.get(i).getVardsString().equals(s)){
                tr = false;
                break;
            }
        }
        return tr;
    }
    public void getAtminetieVardi(){ //izprinte atminetos vardus
        int size = atminetieVardi.size() - 1;
        for(int i = size; i >= 0; i--){
            System.out.println(atminetieVardi.get(i).getVardsString());
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
    public void rindaArKoordinatam(char [] vards, int virziens, int varda_garums, int rinda, int kolona){ //pievieno rindai info par varda atrasanas vietu
        Vertibas vrtb;
        int beigas_rinda = 0;
        int beigas_kolona = 0;
        switch(virziens){
            case 0:
                beigas_rinda = rinda;
                beigas_kolona = varda_garums + kolona - 1;
                break;
            case 1:
                beigas_rinda = varda_garums + rinda - 1;
                beigas_kolona = kolona;
                break;
            case 2:
                beigas_rinda = varda_garums + rinda - 1;
                beigas_kolona = varda_garums + kolona - 1;
                break;
        }
        vrtb = new Vertibas(vards, virziens, rinda, kolona, beigas_rinda, beigas_kolona);
        rindaVertibam.add(vrtb);
    }
    
    public boolean salidzinatKoordinates(char burts_sakums, int rinda_sakums, char burts_beigas, int rinda_beigas){
        //salīdzina dotās koordinātas ar tām, kas vērtību rindā, atgriež true or false atbilstoši
        int kolona_sakums = getSkaitlis(burts_sakums);
        int kolona_beigas = getSkaitlis(burts_beigas);
        boolean tr = true;
        
        for(int i = 0; i < rindaVertibam.size(); i++){
            int sakums_rinda = rindaVertibam.get(i).getSakumsRinda();
            int sakums_kolona = rindaVertibam.get(i).getSakumsKolona();
            int beigas_rinda_list = rindaVertibam.get(i).getBeigasRinda();
            int beigas_kolona_list = rindaVertibam.get(i).getBeigasKolona();
            if(sakums_rinda == rinda_sakums && sakums_kolona == kolona_sakums && beigas_rinda_list == rinda_beigas && beigas_kolona_list == kolona_beigas){
                if(checkAtminetieVardi(rindaVertibam.get(i).getVardsString())){
                    tr = true;
                    kartasNr = i;
                    break;
                }else{
                    tr = false;
                    System.out.println("\nSo vardu tu jau uzmineji!");
                    break;
                }
            }else{
                tr = false;
                
            }
        }
        return tr;
    }
    
   
}