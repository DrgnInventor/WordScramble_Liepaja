package burtuJuuklis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rezultati {
 
    
    public void rezultatu_uzskaite(long speletaja_rezultats, String vards){
        try {
            File visi_rezultati = new File("visi_rezultati.txt"); //atver file ja nav uztaisa
            if (visi_rezultati.createNewFile()) {
              System.out.println("File created: " + visi_rezultati.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          try {
            FileWriter rezultatu_pierakstitajs = new FileWriter("visi_rezultati.txt"); // pieraksta rezultatu
            rezultatu_pierakstitajs.write(vards + " " + speletaja_rezultats);
            rezultatu_pierakstitajs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
            
        

    public void labakie_rezultati(){
        
    }
}
