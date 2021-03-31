
package burtuJuuklis;

public class Vertibas { //klase info par vardu atrasanas vietam glababsanai
    private char[] vards;
    private int virziens;
    private int sakums_rinda;
    private int sakums_kolona;
    private int beigas_rinda;
    private int beigas_kolona;
    public Vertibas(char[] vards, int virziens, int sr, int sk, int br, int bk){
        this.vards = vards;
        this.virziens = virziens;
        this.sakums_rinda = sr;
        this.sakums_kolona = sk;
        this.beigas_rinda = br;
        this.beigas_kolona = bk;
    }
    public String getVardsString(){
        String vards_string = "";
        for(int i  = 0; i < vards.length; i++){
            String burts;
            if(vards[i] == '-'){
                burts = " ";
            }else{
                burts = Character.toString(vards[i]);
            }
            vards_string = vards_string + burts;
        }
        return vards_string.toUpperCase();
    }
    public int getVirziens(){
        return virziens;
    }
    public int getSakumsRinda(){
        return sakums_rinda;
    }
    public int getSakumsKolona(){
        return sakums_kolona;
    }
    public int getBeigasRinda(){
        return beigas_rinda;
    }
    public int getBeigasKolona(){
        return beigas_kolona;
    }
}
