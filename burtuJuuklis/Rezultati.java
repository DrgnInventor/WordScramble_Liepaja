package burtuJuuklis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Rezultati {
    //kods neizskat'as smuki
    public String dokuments = "visi_rezultati.txt"; // rezultatu uzglabasanas dokumenta nosaukums IMPORTANT var izveidot sistēmu kur ievada savu nosuakumu tam dokumentam, vai var nomainīt ja ir vēlme
    public ArrayList<String> visi_rezultaati = new ArrayList<>(); // glaba nolasitos rezultatus no dokumenta
    public String[] sakartoti_aug_sec_rez; // glaba rezultatus sakartotus augosa seciba
    private Boolean rezultatuFileKorekts = true;

    public void rezultatu_uzskaite(String speletaja_rezultats, String vards){
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
            rezultatu_pierakstitajs.write(vards + " > " + speletaja_rezultats + "\n"); // pieraksta rezultātus
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
                    String temp_thing = rezultātu_Lasītājs.nextLine();
                    visi_rezultaati.add(temp_thing); // Nolasa rezultātus
                }
            rezultātu_Lasītājs.close();
            } 
        catch (FileNotFoundException e)
            {
            System.out.println("brrrr kods aizgaja kakaa"); // parbauda vai ir file
            }

        int[] apstradati_rezultati = new int[visi_rezultaati.size()]; // rezultāti atēloti ms
        int[] rez_index_aug_sec = new int[visi_rezultaati.size()]; // rezultātu index sakārtoti augšā secība index atbils visis_rezultati vertibam
          
          for (int i = 0; i < visi_rezultaati.size(); i++)
            {
                String laiks = visi_rezultaati.get(i); // paņem pirmo rezultātu
                int index = laiks.indexOf(">") + 2; // atrod laiku un nolasa
                try {
                    String min_sek = laiks.substring(index); // dabūt mm:ss no rezultāta
                    LocalTime localTime = LocalTime.parse(min_sek); // pārveido string mm:ss uz local time object
                    int millis = localTime.toSecondOfDay() * 1000; // pārveido doto laiku mm:ss formātā uz ms
                    apstradati_rezultati[i] = millis; // ievieto laiku izteiktu ms
                    rez_index_aug_sec[i] = i; // ievieto sakuma index vērtības masīvā
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Rezultāti nepareizi formatēti. Rezultātu dokumentā \"" + dokuments + "\" nevar atrasties tukšas līnijas.");
                    rezultatuFileKorekts = false;
                    break;
                }
                
                
                

                
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
        sakartoti_aug_sec_rez = new String[visi_rezultaati.size()];
        for (int i = 0; i < visi_rezultaati.size(); i++){ // Ievada sakārtotos rezultātus masīvā sakartoti_aug_sec_rez
            sakartoti_aug_sec_rez[i] = visi_rezultaati.get(rez_index_aug_sec[i]);
        }
}
    public void paradiLabakosRezultatus(){
        labakie_rezultati();
        if (rezultatuFileKorekts){
            if ( 0 < sakartoti_aug_sec_rez.length && sakartoti_aug_sec_rez.length < 5){
                System.out.println((sakartoti_aug_sec_rez.length) + " Ātrākie laiki.");
                for (int i = 0; i < sakartoti_aug_sec_rez.length; i++){
                    System.out.println((1 + i)+ ". " + sakartoti_aug_sec_rez[i]);
                }
            } else if (sakartoti_aug_sec_rez.length >= 5){
                System.out.print(5 + " Ātrākie laiki.\n");
                for (int i = 0; i < 5; i++){
                    System.out.println((1 + i)+ ". " + sakartoti_aug_sec_rez[i]);
                } 
            } else {
                System.out.print("Rezultāti nav atrasti!");
            } 
        }
    
    }
}
