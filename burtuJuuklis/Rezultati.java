package burtuJuuklis;

import java.beans.Visibility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Rezultati {
    
    public String dokuments = "visi_rezultati.txt";
    public ArrayList<String> visi_rezultāti = new ArrayList<>();
    
    public void rezultatu_uzskaite(long speletaja_rezultats, String vards){
        SimpleDateFormat formatter= new SimpleDateFormat("mm:ss");
        try {
            File visi_rezultati = new File(dokuments); //atver file ja nav uztaisa
            if (visi_rezultati.createNewFile()) {
              System.out.println("Rezultātu file izveidots: " + visi_rezultati.getName());
            } else {
              System.out.println("Rezultatu file atrasts.");
            }
          } catch (IOException e) {
            System.out.println("O OO POOPY KODS NOMIRA");
          }
          try {
            FileWriter rezultatu_pierakstitajs = new FileWriter(dokuments); // pieraksta rezultatu
            rezultatu_pierakstitajs.write(vards + " » " + formatter.format(speletaja_rezultats));
            rezultatu_pierakstitajs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
            
        

    public void labakie_rezultati(){
        Scanner rezultātu_lasītājs = new Scanner(dokuments);
        try {
            File rezultāti = new File(dokuments); // atver
            Scanner Rezultātu_Lasītājs = new Scanner(rezultāti);
            while (Rezultātu_Lasītājs.hasNextLine()) {
                visi_rezultāti.add((Rezultātu_Lasītājs.nextLine()); //lasa text
            }
            Rezultātu_Lasītājs.close();
          } catch (FileNotFoundException e) {
            System.out.println("brrrr kods aizgaja kakaa"); // parbauda vai ir file
          }
          int[] apstradati_rezultati = new int[visi_rezultāti.size()];
          int[] rez_index_aug_sec = new int[visi_rezultāti.size()];
          
          for (int i = 0; i < visi_rezultāti.size(); i++){
            String laiks = visi_rezultāti.get(i);
            int index = laiks.indexOf("»") + 1;
            String min_sek = laiks.substring(index);
            LocalTime localTime = LocalTime.parse(min_sek);
            int millis = localTime.toSecondOfDay() * 1000;
            apstradati_rezultati[i] = millis;
            rez_index_aug_sec[i] = i;
          }
          BubbleSort ludzu_strada = new BubbleSort();
          ludzu_strada.bubbleSort(apstradati_rezultati, rez_index_aug_sec);

    }
    
}
