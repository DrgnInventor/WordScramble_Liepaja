package burtuJuuklis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Rezultati {
    
    private String dokuments = "visi_rezultati.txt";
    private Boolean rezultatuFileKorekts = true;
    private ArrayList<String> visiRezultati = new ArrayList<>();
    private String[] sakartotiAugSecRez;
    
/**
 * @param dokuments glabā dokumenta nosaukumu
 * @param rezultatuFileKorekts glabā boolean vērtību vai rezultātu dokuments pareizi formatēts
 * @param visiRezultato  tur nolasītos rezultātus
 * @param sakartotiAugSecRez glabā sakartotus augošā secībā rezultātus
 * @param apstradatieRezultati glabā rezultātu laikus ms.
 * @param rezIndexAugSec glabā rezultātu indexus atbilst apstradatieRezultati vērtībām. 
 */

    /**
     * Publiskās metodes
     * rezultatuUzskaite() pieraksta spelētāja rezultātu "dokuments"
     * dzesRezultatus() izdzēš un izveido rezultātu dokumentu
     * paradiLabakosRezultatus() izmanto labakierezultati() sakarto un tad izprintē labākos rezultātus. MAX rezultāti ko parāda ir līdz 5 labākie. 
     */
    
    public void rezultatuUzskaite(String speletaja_rezultats, String vards){
        try {
            File rezultatuDokuments = new File(dokuments);
            
            if (rezultatuDokuments.createNewFile()) {
                System.out.println("Rezultātu file izveidots: " + rezultatuDokuments.getName());
                } else {
                    System.out.println("Rezultatu file atrasts.");
                    }
            }   
        catch (IOException e) {
            System.out.println("Radās kļūme \"rezultatuUzskaite()\" > rezultatuDokuments\n");
            e.printStackTrace();
            }

        try {
            FileWriter rezultatuPierakstitajs = new FileWriter(dokuments, true);
            
            rezultatuPierakstitajs.write(vards + " > " + speletaja_rezultats + "\n"); // Var rasties potenciāla problēma, kur ievietots \n dokumentā ,kas neļauj tajā līnijā ierakstīt rezultātu.
            rezultatuPierakstitajs.close();
            } 
        catch (IOException e) {
            System.out.print("Radās kļūme \"rezultatuUzskaite()\" > rezultatuPierakstitajs\n");
            e.printStackTrace();
            }
    }

    public void dzesRezultatus() {
        try {
            File rezulDokuments = new File(dokuments); 
            rezulDokuments.delete();
            System.out.println("Dokuments atrasts");
            rezulDokuments.createNewFile();
            }
        catch (IOException e) {
            System.out.println("Radās kļūme \"dzesRezultatus()\"\nRezultātu dokumentu nevar izveidot.\n");
            e.printStackTrace();
            }
    }        
        

    private void labakieRezultati() {
        try {
            File rezDokuments = new File(dokuments);
            Scanner rezLasitajs = new Scanner(rezDokuments);
            
            while (rezLasitajs.hasNextLine()) {
                String temp_thing = rezLasitajs.nextLine();
                visiRezultati.add(temp_thing);
                }

            rezLasitajs.close();
            } 
        catch (FileNotFoundException e){
            System.out.println("Radās kļūme \"labakieRezultati()\" > rezDokuments\nRezultātu dokumentu nevar atrast.\n");
            e.printStackTrace();
            }

        int[] apstradatiRezultati = new int[visiRezultati.size()];
        int[] rezIndexAugSec = new int[visiRezultati.size()];
          
        for (int i = 0; i < visiRezultati.size(); i++) {

            String laiks = visiRezultati.get(i);
            int index = laiks.indexOf(">") + 2;
            
            try {
                String min_sek = laiks.substring(index);
                LocalTime localTime = LocalTime.parse(min_sek);
                int millis = localTime.toSecondOfDay() * 1000;
                apstradatiRezultati[i] = millis;
                rezIndexAugSec[i] = i;
                } 
            catch (StringIndexOutOfBoundsException e) {
                System.out.println("Rezultāti nepareizi formatēti. Rezultātu dokumentā \"" + dokuments + "\" nevar atrasties tukšas līnijas.");
                rezultatuFileKorekts = false;
                break;
                }  
            }

        int n = apstradatiRezultati.length; 
        for (int i = 0; i < n-1; i++)
            { 
            for (int j = 0; j < n-i-1; j++)
                { 
                if (apstradatiRezultati[j] > apstradatiRezultati[j+1]) 
                    { 
                    // samaina a[n] ar a [n+1] vietām ja a[n] > a[n +1]
                    int temp = apstradatiRezultati[j]; 
                    apstradatiRezultati[j] = apstradatiRezultati[j+1]; 
                    apstradatiRezultati[j+1] = temp;
                    
                    temp = rezIndexAugSec[j];
                    rezIndexAugSec[j] = rezIndexAugSec[j+1];
                    rezIndexAugSec[j+1] = temp; 
                    }
                }
            }
        sakartotiAugSecRez = new String[visiRezultati.size()];
        
        for (int i = 0; i < visiRezultati.size(); i++){
            sakartotiAugSecRez[i] = visiRezultati.get(rezIndexAugSec[i]);
            }
    }

    public void paradiLabakosRezultatus(){
        labakieRezultati();

        if (rezultatuFileKorekts){
            if ( 0 < sakartotiAugSecRez.length && sakartotiAugSecRez.length < 5){
                System.out.println((sakartotiAugSecRez.length) + " Ātrākie laiki.");
                for (int i = 0; i < sakartotiAugSecRez.length; i++){
                    System.out.println((1 + i)+ ". " + sakartotiAugSecRez[i]);
                    }
                } 
            else if (sakartotiAugSecRez.length >= 5){
                System.out.print(5 + " Ātrākie laiki.\n");
                for (int i = 0; i < 5; i++){
                System.out.println((1 + i)+ ". " + sakartotiAugSecRez[i]);
                } 
            } else {
                System.out.print("Rezultāti nav atrasti!");
                } 
            }
    }

}
