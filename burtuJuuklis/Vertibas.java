/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burtuJuuklis;

/**
 *
 * @author darta
 */
public class Vertibas { //klase info par vardu atrasanas vietam glababsanai
   
    int virziens;
    int sakums_rinda;
    int sakums_kolona;
    int beigas_rinda;
    int beigas_kolona;
    public Vertibas(int virziens, int sr, int sk, int br, int bk){
        this.virziens = virziens;
        this.sakums_rinda = sr;
        this.sakums_kolona = sk;
        this.beigas_rinda = br;
        this.beigas_kolona = bk;
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
