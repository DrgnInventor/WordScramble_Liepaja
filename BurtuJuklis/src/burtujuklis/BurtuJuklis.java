
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
   
    burti = new String[s.length()/2];
    int k = 0;
    for (int j = 0; j < s.length(); j++) {//cikls, lai sadalitu vārdu pa burtiem
       
        if (j < s.length() - 1) {
            burts = s.substring(j, j + 2);
            j = j + 1;
        } else {
            burts = s.substring(j); //lai neiet string out of bounds
        }
        burti[k] = burts;  
        k = k +1;
}
    return burti; //masivs ar atseviskiem burtiem + atstarpem    
}

public boolean vaiVardsDer(int garums,int virziens_p, int kolona, int rinda){ 
//parbauda vai vards ielien burtu juklis masiva un vai tur ir brivas ailites

boolean tr = true;    
    switch(virziens_p){
        case 0:
       //horizontali
            if(lielums - kolona >= garums){
                for(int i = 0; i < garums; i++){
                    if(burtuJuklis[kolona][rinda + i].isEmpty()){
                        tr = true;
                    }else break;
                }
        }else tr = false;
        break;
        case 1:
        //vertikali
            if(lielums - rinda >= garums){
                for(int i = 0; i < garums; i++){
                    if(burtuJuklis[kolona + i][rinda].isEmpty()){
                        tr = true;
                    }else break;
                }
        }else tr = false;
        break;
        case 2:
        //diagonali
            if(rinda + garums <= lielums){
            for(int i = 0; i < garums; i++){
                if(burtuJuklis[kolona + i][rinda + i].isEmpty()){
                    tr = true;
                }else break;
            }
        }else tr = false;
    }
    if(tr == true)return true;
    else return false;
}
public void rezgaBuvesana(String [] vardiMasiva){
    
    String[] burtiMasiva;
    Random r = new Random();
    for(int i = 0; i < vardiMasiva.length; i ++){
        burtiMasiva = atseviskieBurti(vardiMasiva[i]); // izveido masivu ar burtiem
        int virziens = r.nextInt(3);
        int lauks_kolona = (int)(Math.random()*(lielums) + 1); 
        int lauks_rinda = (int)(Math.random()*(lielums) + 1); 
        for(int j = 0; j < burtiMasiva.length; j++){
            burts = burtiMasiva[j];
           
                if(vaiVardsDer(burtiMasiva.length, virziens, lauks_kolona, lauks_rinda) == true){
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
        String[] vm = {
            "v a r d s ","c i t s-v a r d s ","d a r t a-i r-s t i l i g a "
    };
        System.out.println(Arrays.toString(bj.atseviskieBurti("k a k a ")));
        System.out.println(bj.vaiVardsDer(5, 0, 6, 1));
        for (int i = 0; i < brtj.length; ++i) { 
            
                //bj.rezgaBuvesana(vm);
                System.out.println(Arrays.toString(brtj[i]));
            
        }
    }
    
}
