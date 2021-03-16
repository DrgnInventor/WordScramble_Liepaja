
package burtujuklis;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author darta
 */
public class BurtuJuklis {
    private String[][] burtuJuklis; //masivs kur kartot vardus
    private String burts; 
    private String [] burti;
    private int lielums;
public BurtuJuklis(){
    lielums = 20;
    burtuJuklis = new String[lielums][lielums];
}
public String[] atseviskieBurti(String s){
   
    burti = new String[s.length()];
    int k = 0;
    for (int j = 0; j < s.length(); j++) {//cikls, lai sadalitu vārdu pa burtiem
       
        if (j < s.length() - 1) {
            burts = s.substring(j, j + 2);
            j = j + 1;
        } else {
            burts = s.substring(j); //lai neiet string out of bounds
        }
        burti[k] = burts;       
}
    return burti; //masivs ar atseviskiem burtiem + atstarpem    
}

public boolean vaiVardsDer(int virziens_p, int kolona, int rinda){ 
//parbauda vai vards ielien burtu juklis masiva un vai tur ir brivas ailites
this.burtuJuklis = burtuJuklis;
boolean tr = false;    
    switch(virziens_p){
        case 0:
       //horizontali
            if(lielums - kolona >= burti.length){
                for(int i = 0; i < burti.length; i++){
                    if(burtuJuklis[kolona][rinda + i].isEmpty()){
                        tr = true;
                    }else break;
                }
        }else tr = false;
        break;
        case 1:
        //vertikali
            if(lielums - rinda >= burti.length){
                for(int i = 0; i < burti.length; i++){
                    if(burtuJuklis[kolona + i][rinda].isEmpty()){
                        tr = true;
                    }else break;
                }
        }else tr = false;
        break;
        case 2:
        //diagonali
            if(rinda + burti.length <= lielums){
            for(int i = 0; i < burti.length; i++){
                if(burtuJuklis[kolona + i][rinda + i].isEmpty()){
                    tr = true;
                }else break;
            }
        }else tr = false;
    }
    if(tr == true)return true;
    else return false;
}
public void rezgaBuvesana(){
    String[] vardiMasiva = {
            "v a r d s ","c i t s-v a r d s ","d a r t a-i r-s t i l i g a "
    };
    burtuJuklis = this.burtuJuklis;
    String[] burtiMasiva;
    Random r = new Random();
    for(int i = 0; i < vardiMasiva.length; i ++){
        burtiMasiva = atseviskieBurti(vardiMasiva[i]); // izveido masivu ar burtiem
        int virziens = r.nextInt(3);
        int lauks_kolona = (int)(Math.random()*(lielums) + 1); 
        int lauks_rinda = (int)(Math.random()*(lielums) + 1); 
        for(int j = 0; j < burtiMasiva.length; j++){
            burts = burtiMasiva[j];
           
                if(vaiVardsDer(virziens, lauks_kolona, lauks_rinda) == true){
                    if(virziens == 0){
                        burtuJuklis[lauks_kolona][lauks_rinda + j] = burts;
                    } else if(virziens == 1){
                        burtuJuklis[lauks_kolona + j][lauks_rinda] = burts;
                    } else{
                        burtuJuklis[lauks_kolona + j][lauks_rinda + j] = burts;
                    }
                }else {
                    i = i - 1;
                } break;
                
        }
    }
    for (int i = 0; i < burtuJuklis.length; ++i) { // aizpilda tuksas vietas
            for(int j = 0; j < burtuJuklis[i].length; ++j) {
                if(burtuJuklis[i][j].isEmpty()){
                    burtuJuklis[i][j] = "x";
                }
            }
        }
}
    public static void main(String[] args) {
        BurtuJuklis bj = new BurtuJuklis();
        int liel = bj.lielums;
        String brtj[][] = bj.burtuJuklis;
        brtj[0][0] = "darta";
        // Loop through all rows
        for (String[] row : brtj)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
        System.out.print((int)(Math.random()*(20) + 1));
    }
    
}
