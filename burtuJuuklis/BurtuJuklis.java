package burtujuuklis;

import java.util.Random;
import burtuJuuklis.Adreses;

public class BurtuJuklis {
    private char[] abcdburti = {'a','a','a','a','ā','b','b','c','č','d','e','ē','f','g','ģ','h','i','ī','j','k','ķ','l','ļ','m','n','ņ','o','p','r','s','š','t','u','ū','v','z','ž','-'};
    private char[][] burtuJuklis; //masivs kur kartot vardus
    private char[] burti; //masivs atseviskajiem burtiem
    private int platums; //burtu jukla lielums
    private int garums;
    public boolean tabulaDer = true; //glabā vai tabula ir riktīgā izmērā
  public BurtuJuklis(int n, int m){
    platums = m;
    garums = n;
    burtuJuklis = new char[garums][platums];
  }
  public char[] atseviskieBurti(String s){ //sadali stringu characteros un izveido masivu
    char burts;
    burti = new char[s.length()];
    for (int j = 0; j < s.length(); j++) {
       if (s.charAt(j) != ' '){
        burts = s.charAt(j);
       } else {
           burts = '-'; 
       }
       burti[j] = burts;  
    }
    return burti; //masivs ar atseviskiem burtiem  
  }
  
  public boolean vaiVardsDer(int garums_vardam,int virziens_p, int rinda, int kolona){ 
  //parbauda vai vards ielien burtu juklis masiva un vai tur ir brivas ailites
  boolean tr = false; 
  if(garums_vardam < platums || garums_vardam < garums){
    switch(virziens_p){
        case 0:
       //horizontali
            if(platums - kolona >= garums_vardam){
                for(int i = 0; i < garums_vardam; i++){
                    if(burtuJuklis[rinda][kolona + i] == 0){
                        tr = true;
                    }else {
                        tr = false;
                        break;
                    }

                }
            }else tr = false;
        break;
        case 1:
        //vertikali
            if(garums - rinda >= garums_vardam){
                for(int i = 0; i < garums_vardam; i++){
                    if(burtuJuklis[rinda + i][kolona] == 0){
                        tr = true;
                    }else {
                        tr = false;
                        break;
                    }
                }    
            }else tr = false;
        break;
        case 2:
        //diagonali
            if(rinda + garums_vardam <= garums && kolona + garums_vardam <= platums){
                for(int i = 0; i < garums_vardam; i++){
                    if(burtuJuklis[rinda + i][kolona + i] == 0){
                        tr = true;
                    }else {
                        tr = false;
                        break;
                    }
                }
            }else tr = false;
    }
  }else{
      tabulaDer = false;
  }
    if(tr == true)return true;
    else return false;
  }
  
  public void varduLiksana(char[] burtiMasiva, int virziens, int lauks_rinda, int lauks_kolona){
    //panem masivu ar burtiem un ieliek burtu jukli
    for(int j = 0; j < burtiMasiva.length; j++){
        char viensBurts = burtiMasiva[j];
        if(virziens == 0){
            burtuJuklis[lauks_rinda][lauks_kolona + j] = viensBurts;
        } else if(virziens == 1){
            burtuJuklis[lauks_rinda + j][lauks_kolona] = viensBurts;
        } else{
            burtuJuklis[lauks_rinda + j][lauks_kolona + j] = viensBurts;
        } 
    }
    }
  
  public char[][] rezgaBuvesana(String [] vardiMasiva, Adreses adr){ //izveido koordinates vardiem un saliek rezgi
    
    char[] burtiMasiva;
    Random r = new Random();
    boolean daudzReizu = true;
    if(platums > 26){ // nevar vairak par 26, jo alfabeta nav tik daudz burtu
        System.out.println("pls no");
        tabulaDer = false;
    }
    if(platums <= 0 || garums <= 0){ //pārbauda vai dotie parametri nav 0 vai negatīvi
        tabulaDer = false;
    }
    if(tabulaDer){
        for(int i = 0; i < vardiMasiva.length; i++){
            burtiMasiva = atseviskieBurti(vardiMasiva[i]); 
            int skaititajs = 0; //skaita, cik reizes izmēģina atrast vārdam vietu
            do{
                int virziens = r.nextInt(3);
                int lauks_kolona = (int)(Math.random()*(platums - 1) + 1); 
                int lauks_rinda = (int)(Math.random()*(garums - 2) + 1);
                if(vaiVardsDer(burtiMasiva.length, virziens, lauks_rinda, lauks_kolona)){
                    varduLiksana(burtiMasiva, virziens, lauks_rinda, lauks_kolona);
                    adr.rindaArKoordinatam(burtiMasiva, virziens, lauks_rinda, lauks_kolona); //papildina rindu
                    tabulaDer = true;
                }else{                    
                    skaititajs++;
                    tabulaDer = false;
                }
            }while(skaititajs < 1000 && !tabulaDer); //ja 1000 reizēs nevar atrast vietu, pieņem, ka vietas nav
        }
    }
    if(daudzReizu == true && tabulaDer == true){    
        for(int i = 0; i < platums; i++){ // uztaisa identifikatorus no alfabeta burtiem
            burtuJuklis[0][i] = (char)(i + 17 + '0');
        }
        for (int i = 0; i < burtuJuklis.length; ++i) { // aizpilda tuksas vietas
            for(int j = 0; j < burtuJuklis[i].length; ++j) {
                if(burtuJuklis[i][j] == 0){
                    burtuJuklis[i][j] = abcdburti[r.nextInt(abcdburti.length)];
                }
            }
        }
    }else tabulaDer = false;
    return burtuJuklis;
    }
}  
  