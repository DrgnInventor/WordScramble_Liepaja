package burtuJuuklis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Rezultati {
 
    
    public void rezultatu_uzskaite(long speletaja_rezultats, String vards){
        SimpleDateFormat formatter= new SimpleDateFormat("mm:ss");
        try {
            File visi_rezultati = new File("visi_rezultati.txt"); //atver file ja nav uztaisa
            if (visi_rezultati.createNewFile()) {
              System.out.println("Rezultātu file izveidots: " + visi_rezultati.getName());
            } else {
              System.out.println("Rezultatu file atrasts.");
            }
          } catch (IOException e) {
            System.out.println("O OO POOPY KODS NOMIRA");
          }
          try {
            FileWriter rezultatu_pierakstitajs = new FileWriter("visi_rezultati.txt"); // pieraksta rezultatu
            rezultatu_pierakstitajs.write(vards + " » " + formatter.format(speletaja_rezultats));
            rezultatu_pierakstitajs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
            
        

    public void labakie_rezultati(){

    }
}
