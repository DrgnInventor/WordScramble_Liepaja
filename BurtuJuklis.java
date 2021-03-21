<<<<<<< HEAD
import java.util.Arrays;
import java.util.Random;

public class BurtuJuklis {
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
       burts = s.charAt(j);
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
  
  public void rezgaBuvesana(String [] vardiMasiva){ //izveido koordinates vardiem un saliek rezgi
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
                    burtuJuklis[i][j] = '0';
                }
            }
        }
  }
    public static void main(String[] args) {
        BurtuJuklis bj = new BurtuJuklis(20);
        char brtj[][] = bj.burtuJuklis;
        String[] vm = {
            "VARDS","CITS-VARDS","DARTA-IR-STILIGA","SUDS","DABAS-MAJA","LIEPAJA","CIMDI","JUKLIS"
        };
        
        bj.rezgaBuvesana(vm);
        for (int j = 0; j < brtj.length; j++) { 
            System.out.println(Arrays.toString(brtj[j]));
        }    
    }
    
  }
=======
package burtujuklis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lasitajs {

  static ArrayList<String> vardiLst = new ArrayList<>(); // ArrayList ar vardiniem kas tiks apstradati
  static Object[] vardi;

  public static void main(String[] args) {
    lasiVardus();
  }
  public static Object[] lasiVardus() {
    try {
      File Dotie_Vārdi = new File("Dotie_Vārdi.txt"); // atver
      Scanner Lasītājs = new Scanner(Dotie_Vārdi);
      while (Lasītājs.hasNextLine()) {
        vardiLst.add(Lasītājs.nextLine()); //lasa text
      }
      Lasītājs.close();
    } catch (FileNotFoundException e) {
      System.out.println("brrrr kods aizgaja kakaa"); // parbauda vai ir file
    }
    vardi = vardiLst.toArray();
  }
}

public class Tabula {

  static char[][] tabula; //metodēm pieejams mainīgais

  public static void main(String[] args) {
      makeTabula();
      printTabula();
  }

  public static void makeTabula() {
      int n = 5; // controlē garumu (y dimensiju)
      int m = 8; // platumu (x dimensiju)
      tabula = new char[n][m];
      for (int i = 0; i<tabula.length; i++) { // šie cikli aizpilda masīvu ar placeholder vērtībām, simulējot aizpildītu tabulu
          for (int j = 0; j<tabula[i].length; j++) {
              tabula[i][j] = 'a';
          }
      }
  }

  public static void printTabula() {
      for (int i = 0; i<tabula.length; i++) { // šie cikli izprintē masīvu
          for (int j = 0; j<tabula[i].length; j++) {
              System.out.print(tabula[i][j] + " ");
          }
          System.out.println();
      }
  }

}
public class BurtuJuklis {
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
     burts = s.charAt(j);
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

public void rezgaBuvesana(String [] vardiMasiva){ //izveido koordinates vardiem un saliek rezgi
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
                  burtuJuklis[i][j] = '0';
              }
          }
      }
}
  public static void main(String[] args) {
      BurtuJuklis bj = new BurtuJuklis(20);
      int liel = bj.lielums;
      char brtj[][] = bj.burtuJuklis;
      String[] vm = {
          "VARDS","CITS-VARDS","DARTA-IR-STILIGA","SUDS","DABAS-MAJA","LIEPAJA","CIMDI","JUKLIS"
      };
      
      bj.rezgaBuvesana(vm);
      for (int j = 0; j < brtj.length; j++) { 
          System.out.println(Arrays.toString(brtj[j]));
      }    
  }
  
}
>>>>>>> a21893af9c13f493c62a37049c9fd6abd8d38c9b
