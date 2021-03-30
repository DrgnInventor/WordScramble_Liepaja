package burtuJuuklis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lasitajs {

    private ArrayList<String> vardiLst = new ArrayList<>();
    private String dokuments = "Dotie_Vardi.txt";
    private String[] vardi;

    /** @param vardiLst nolasītie vārdi ArrayList formātā ,kas tiks apstrādāti.
    *   @param dokuments doto vārdu dokumenta nosaukums.
     */

    /*
    * Publiski pieejamās metodēs. 
    * Jaizmanto metode lasiVardus()
    * Pārējo var ignorēt.
    */
    public static void main(String[] args) {
      Lasitajs ls = new Lasitajs();
      ls.lasiVardus();
    }
    
    public String[] lasiVardus() {
      
      /*
        Metode atrod ,ja ir doto vārdu dokumentu un nolasa.
        Atgriež String[] vardi. 
      */
      
      try {
            File Dotie_Vardi = new File(dokuments);
            Scanner Lasiitajs = new Scanner(Dotie_Vardi);

            while (Lasiitajs.hasNextLine()) {
              vardiLst.add((Lasiitajs.nextLine()).toLowerCase());
              }
            Lasiitajs.close();
            
            vardi = new String[vardiLst.size()];  
            
            for (int i = 0; i < vardiLst.size(); i++) {
              vardi[i] = vardiLst.get(i);
              }
          }
      catch (FileNotFoundException e) {
          System.out.println("Doto vārdu dokuments \"" + dokuments + "\" netika atrasts!\n\n\n");          
          }
      return vardi;
    }
  }
