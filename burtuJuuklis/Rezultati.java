package burtuJuuklis;

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
    public String[] sakartoti_aug_sec_rez;
    
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
            
        

    public void labakie_rezultati()
    {
        try {
            File rezultāti = new File(dokuments); // atver
            Scanner rezultātu_Lasītājs = new Scanner(rezultāti);
                while (rezultātu_Lasītājs.hasNextLine())    {
                    visi_rezultāti.add(rezultātu_Lasītājs.nextLine()); //lasa text
                                                            }
            rezultātu_Lasītājs.close();
            } 
        catch (FileNotFoundException e)
            {
            System.out.println("brrrr kods aizgaja kakaa"); // parbauda vai ir file
            }

        int[] apstradati_rezultati = new int[visi_rezultāti.size()];
        int[] rez_index_aug_sec = new int[visi_rezultāti.size()];
          
          for (int i = 0; i < visi_rezultāti.size(); i++)
            {
                String laiks = visi_rezultāti.get(i);
                int index = laiks.indexOf("»") + 1;
                String min_sek = laiks.substring(index);
                LocalTime localTime = LocalTime.parse(min_sek);
                int millis = localTime.toSecondOfDay() * 1000;
                apstradati_rezultati[i] = millis;
                rez_index_aug_sec[i] = i;
            }
        int n = apstradati_rezultati.length; 
                for (int i = 0; i < n-1; i++)
                { 
                    for (int j = 0; j < n-i-1; j++)
                    { 
                        if (apstradati_rezultati[j] > apstradati_rezultati[j+1]) 
                        { 
                            // swap arr[j+1] and arr[j] 
                            int temp = apstradati_rezultati[j]; 
                            apstradati_rezultati[j] = apstradati_rezultati[j+1]; 
                            apstradati_rezultati[j+1] = temp;
                            temp = rez_index_aug_sec[j];
                            rez_index_aug_sec[j] = rez_index_aug_sec[j+1];
                            rez_index_aug_sec[j+1] = temp; 
                        }
                    }
                }
        sakartoti_aug_sec_rez = new String[visi_rezultāti.size()];
        for (int i = 0; i < visi_rezultāti.size(); i++){
            sakartoti_aug_sec_rez[i] = visi_rezultāti.get(rez_index_aug_sec[i]);
        }
}
}
