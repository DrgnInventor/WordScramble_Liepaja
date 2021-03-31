import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Lasitajs {

    private ArrayList<String> vardiLst = new ArrayList<>();
    private String dokuments = "Dotie_Vardi.txt";
    private String[] vardi;

    /** @param vardiLst nolasitie vardi ArrayList formata ,kas tiks apstradati.
    *   @param dokuments doto vardu dokumenta nosaukums.
     */

    /*
    * Publiski pieejamas metodēs. 
    * Jaizmanto metode lasiVardus()
    * Parējo var ignorēt.
    */
    public static void main(String[] args) {
      Lasitajs ls = new Lasitajs();
      ls.lasiVardus();
    }
    
    public String[] lasiVardus() {
      
      /*
        Metode atrod ,ja ir doto vardu dokumentu un nolasa.
        Atgriez String[] vardi. 
      */
       File Dotie_Vardi = new File(dokuments);
      try {
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
          System.out.println("Doto vardu dokuments \"" + dokuments + "\" netika atrasts!\n\n\n");
          System.out.println("Dokuments tiks izveidots un programa termineta. Ludzu ievadied vardus dokumenta \"" + dokuments + "\"" );
          try {
            Dotie_Vardi.createNewFile();
          } catch (IOException e1) {
            System.out.println("Klume dokumenta izveide. lasiVardus() Error IOException");
            e.printStackTrace();  
          }
          System.exit(0);         
          }
      return vardi;
    }
  }
