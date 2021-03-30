package burtuJuuklis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lasitajs {

    private ArrayList<String> vardiLst = new ArrayList<>(); // ArrayList ar vardiniem kas tiks apstradati
    private String dokuments = "Dotie_Vārdi.txt";
    // String[] vardi uztur Default vārdu vērtības ,lai spēle var funkcionēt pat ja doto vārdu dokuments nav.
    private String[] vardi = {
      "Dienvidu mols",
      "Austrumu forts",
      "BB wakepark",
      "Atpūtas parks Pērkone",
      "Spoku koks",
      "Mūziķu slavas aleja",
      "Āmuļi",
      "Juliannas pagalms",
      "Amatnieku nams"};

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
            File Dotie_Vārdi = new File(dokuments);
            Scanner Lasītājs = new Scanner(Dotie_Vārdi);

            while (Lasītājs.hasNextLine()) {
              vardiLst.add((Lasītājs.nextLine()).toLowerCase());
              }
            Lasītājs.close();
            
            vardi = new String[vardiLst.size()];  
            
            for (int i = 0; i < vardiLst.size(); i++) {
              vardi[i] = vardiLst.get(i);
              }
          }
      catch (FileNotFoundException e) {
            System.out.println("Dotu vārdu dokuments \"" + dokuments + "\" netika atrasts!");
            System.out.println("Spēle turpināsies ar \"Default\" vērtībām.");
          }
      return vardi;
    }
  }
