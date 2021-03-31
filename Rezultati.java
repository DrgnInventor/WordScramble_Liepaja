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
 * @param dokuments glaba dokumenta nosaukumu
 * @param rezultatuFileKorekts glaba boolean vertibu vai rezultatu dokuments pareizi formatets
 * @param visiRezultato  tur nolasitos rezultatus
 * @param sakartotiAugSecRez glaba sakartotus augosa seciba rezultatus
 * @param apstradatieRezultati glaba rezultatu laikus ms.
 * @param rezIndexAugSec glaba rezultatu indexus atbilst apstradatieRezultati vertibam. 
 */

    /**
     * Publiskas metodes
     * rezultatuUzskaite() pieraksta speletaja rezultatu "dokuments"
     * dzesRezultatus() izdzes un izveido rezultatu dokumentu
     * paradiLabakosRezultatus() izmanto labakierezultati() sakarto un tad izprinte labakos rezultatus. MAX rezultati ko parada ir lidz 5 labakie. 
     */
    
    public void rezultatuUzskaite(String speletaja_rezultats, String vards){
        try {
            File rezultatuDokuments = new File(dokuments);
            
            if (rezultatuDokuments.createNewFile()) {
                System.out.println("Rezultatu file izveidots: " + rezultatuDokuments.getName());
                } else {
                    System.out.println("Rezultatu file atrasts.");
                    }
            }   
        catch (IOException e) {
            System.out.println("Radas klume \"rezultatuUzskaite()\" > rezultatuDokuments\n");
            e.printStackTrace();
            }
        // Pieraksta rezultatus ar doto formatu [vards > mm:ss]
        try {
            FileWriter rezultatuPierakstitajs = new FileWriter(dokuments, true);
            
            rezultatuPierakstitajs.write(vards + " > " + speletaja_rezultats + "\n"); // Var rasties potenciala problema, kur ievietots \n dokumenta ,kas nelauj taja linija ierakstit rezultatu.
            rezultatuPierakstitajs.close();
            } 
        catch (IOException e) {
            System.out.print("Radas klume \"rezultatuUzskaite()\" > rezultatuPierakstitajs\n");
            e.printStackTrace();
            }
    }
    // Izdzes un izveido rezultatu dokumentu
    public void dzesRezultatus() {
        try {
            File rezulDokuments = new File(dokuments); 
            rezulDokuments.delete();
            System.out.println("Dokuments atrasts");
            rezulDokuments.createNewFile();
            }
        catch (IOException e) {
            System.out.println("Radas klume \"dzesRezultatus()\"\nRezultatu dokumentu nevar izveidot.\n");
            e.printStackTrace();
            }
    }        
        
    // Sakarto rezultatus augosa seciba
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
            System.out.println("Radas klume \"labakieRezultati()\" > rezDokuments\nRezultatu dokumentu nevar atrast.\n");
            e.printStackTrace();
            }

        int[] apstradatiRezultati = new int[visiRezultati.size()];
        int[] rezIndexAugSec = new int[visiRezultati.size()];

        // Iegust ms laiku no rezultatiem.  
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
                System.out.println("Rezultati nepareizi formateti. Rezultatu dokumenta \"" + dokuments + "\" nevar atrasties tuksas linijas.");
                rezultatuFileKorekts = false;
                break;
                }  
            }
        // Apstradatos rezultatus sakarto augosa seciba
        int n = apstradatiRezultati.length; 
        for (int i = 0; i < n-1; i++)
            { 
            for (int j = 0; j < n-i-1; j++)
                { 
                if (apstradatiRezultati[j] > apstradatiRezultati[j+1]) 
                    { 
                    // samaina a[n] ar a [n+1] vietam ja a[n] > a[n +1]
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

    // Sakarto un tad izprinte labakos rezultatus (MAX 5)
    public void paradiLabakosRezultatus(){
        //Sakarto
        labakieRezultati();

        //Izprinte
        if (rezultatuFileKorekts){
            if ( 0 < sakartotiAugSecRez.length && sakartotiAugSecRez.length < 5){
                System.out.println((sakartotiAugSecRez.length) + " atrakie laiki.");
                for (int i = 0; i < sakartotiAugSecRez.length; i++){
                    System.out.println((1 + i)+ ". " + sakartotiAugSecRez[i]);
                    }
                } 
            else if (sakartotiAugSecRez.length >= 5){
                System.out.print(5 + " atrakie laiki.\n");
                for (int i = 0; i < 5; i++){
                System.out.println((1 + i)+ ". " + sakartotiAugSecRez[i]);
                } 
            } else {
                System.out.print("Rezultati nav atrasti!");
                } 
            }
    }

}
