import java.util.Random;

public class BurtuJuklis {
    public char[] abcdburti = {'a','ā','b','c','č','d','e','ē','f','g','ģ','h','i','ī','j','k','ķ','l','ļ','m','n','ņ','o','p','r','s','š','t','u','ū','v','z','ž', '-'};
    private char[][] burtuJuklis; //masivs kur kartot vardus
    private char[] burti; //masivs atseviskajiem burtiem
    private int lielums; //burtu jukla lielums
  public BurtuJuklis(int n){
    lielums = n;
    burtuJuklis = new char[lielums][lielums];
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
  
  public boolean vaiVardsDer(int garums,int virziens_p, int rinda, int kolona){ 
  //parbauda vai vards ielien burtu juklis masiva un vai tur ir brivas ailites
  boolean tr = true;    
    switch(virziens_p){
        case 0:
       //horizontali
            if(lielums - kolona >= garums){
                for(int i = 0; i < garums; i++){
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
            if(lielums - rinda >= garums){
                for(int i = 0; i < garums; i++){
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
            if(rinda + garums <= lielums && kolona + garums <= lielums){
                for(int i = 0; i < garums; i++){
                    if(burtuJuklis[rinda + i][kolona + i] == 0){
                        tr = true;
                    }else {
                        tr = false;
                        break;
                    }
                }
            }else tr = false;
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
  
  public char[][] rezgaBuvesana(String [] vardiMasiva){ //izveido koordinates vardiem un saliek rezgi
    char[] burtiMasiva;
    Random r = new Random();
    for(int i = 0; i < vardiMasiva.length; i++){
        burtiMasiva = atseviskieBurti(vardiMasiva[i]); 
        int virziens = r.nextInt(3);
        int lauks_kolona = (int)(Math.random()*(lielums - 1) + 1); 
        int lauks_rinda = (int)(Math.random()*(lielums - 1) + 1);
        if(vaiVardsDer(burtiMasiva.length, virziens, lauks_rinda, lauks_kolona)){
            varduLiksana(burtiMasiva, virziens, lauks_rinda, lauks_kolona);
        }else{
            i = i - 1;
        }
    }
    for (int i = 0; i < burtuJuklis.length; ++i) { // aizpilda tuksas vietas
            
        for(int j = 0; j < burtuJuklis[i].length; ++j) {
                if(burtuJuklis[i][j] == 0){

                    burtuJuklis[i][j] = abcdburti[r.nextInt(abcdburti.length)];
                }
            }
        }
        return burtuJuklis;
  }
    
  }
