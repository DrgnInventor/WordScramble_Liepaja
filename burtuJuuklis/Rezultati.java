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
    
    public String dokuments = "visi_rezultati.txt"; // rezultatu uzglabasanas dokumenta nosaukums IMPORTANT var izveidot sistēmu kur ievada savu nosuakumu tam dokumentam, vai var nomainīt ja ir vēlme
    public ArrayList<String> visi_rezultāti = new ArrayList<>(); // glaba nolasitos rezultatus no dokumenta
    public String[] sakartoti_aug_sec_rez; // glaba rezultatus sakartotus augosa seciba
    
    public static void main(String[] args, long spel_rez, String vards) {
        Rezultati ls = new Rezultati();
        ls.rezultatu_uzskaite(spel_rez,vards);
        ls.labakie_rezultati();
        ls.dzēs_rezultātus();
      }

    public void rezultatu_uzskaite(long speletaja_rezultats, String vards){
        SimpleDateFormat formatter= new SimpleDateFormat("mm:ss"); // formate ms doto laiku minūtes: sekundes
        try {
            File visi_rezultati = new File(dokuments);
            if (visi_rezultati.createNewFile()) { // Pārbauda vai ir dokluments ja nav uztaisa.
              System.out.println("Rezultātu file izveidots: " + visi_rezultati.getName());
            } else {
              System.out.println("Rezultatu file atrasts.");
            }
          } catch (IOException e) {
            System.out.println("O OO POOPY KODS NOMIRA");
          }
          try {
            FileWriter rezultatu_pierakstitajs = new FileWriter(dokuments, true);
            rezultatu_pierakstitajs.write("\n" + vards + " » " + formatter.format(speletaja_rezultats)); // pieraksta rezultātus
            rezultatu_pierakstitajs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    public void dzēs_rezultātus(){
        try{
        File rezul_dok = new File(dokuments); 
        rezul_dok.delete(); // idzes dokumetu
        System.out.println("Dokuments atrasts");
        rezul_dok.createNewFile(); // izveido dokumentu
    } catch (IOException e) {
        System.out.println("Rezultātu dokumentu nevar izveidot.");
    }

    }        
        

    public void labakie_rezultati()
    {
        try {
            File rezultāti = new File(dokuments); // Atver dokumentu
            Scanner rezultātu_Lasītājs = new Scanner(rezultāti);
                while (rezultātu_Lasītājs.hasNextLine())    {
                    visi_rezultāti.add(rezultātu_Lasītājs.nextLine()); // Nolasa rezultātus
                                                            }
            rezultātu_Lasītājs.close();
            } 
        catch (FileNotFoundException e)
            {
            System.out.println("brrrr kods aizgaja kakaa"); // parbauda vai ir file
            }

        int[] apstradati_rezultati = new int[visi_rezultāti.size()]; // rezultāti atēloti ms
        int[] rez_index_aug_sec = new int[visi_rezultāti.size()]; // rezultātu index sakārtoti augšā secība index atbils visis_rezultati vertibam
          
          for (int i = 0; i < visi_rezultāti.size(); i++)
            {
                String laiks = visi_rezultāti.get(i); // paņem pirmo rezultātu
                int index = laiks.indexOf("»") + 2; // atrod laiku un nolasa
                String min_sek = laiks.substring(index); // dabūt mm:ss no rezultāta
                LocalTime localTime = LocalTime.parse(min_sek); // pārveido string mm:ss uz local time object
                int millis = localTime.toSecondOfDay() * 1000; // pārveido doto laiku mm:ss formātā uz ms
                apstradati_rezultati[i] = millis; // ievieto laiku izteiktu ms

                rez_index_aug_sec[i] = i; // ievieto sakuma index vērtības masīvā
            }
        // Šis te tālāk ir Bubble sort algoritms kas sorto pēc vērtībām un paralēli maina indexus lai var atrast pareizos rezultātu String no visi_rezultāti
        int n = apstradati_rezultati.length; 
                for (int i = 0; i < n-1; i++)
                { 
                    for (int j = 0; j < n-i-1; j++)
                    { 
                        if (apstradati_rezultati[j] > apstradati_rezultati[j+1]) 
                        { 
                            // samaina a[n] ar a [n+1] vietām ja a[n] > a[n +1]
                            int temp = apstradati_rezultati[j]; 
                            apstradati_rezultati[j] = apstradati_rezultati[j+1]; 
                            apstradati_rezultati[j+1] = temp;
                            // tādā paša stilā kārto indexus lai pēc tam rezultātus varam iegūt
                            temp = rez_index_aug_sec[j];
                            rez_index_aug_sec[j] = rez_index_aug_sec[j+1];
                            rez_index_aug_sec[j+1] = temp; 
                        }
                    }
                }
        sakartoti_aug_sec_rez = new String[visi_rezultāti.size()];
        for (int i = 0; i < visi_rezultāti.size(); i++){ // Ievada sakārtotos rezultātus masīvā sakartoti_aug_sec_rez
            sakartoti_aug_sec_rez[i] = visi_rezultāti.get(rez_index_aug_sec[i]);
        }
}
}
