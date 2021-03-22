package burtuJuuklis;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lasitajs {

    public ArrayList<String> vardiLst = new ArrayList<>(); // ArrayList ar vardiniem kas tiks apstradati
    
    public static void main(String[] args) {
      Lasitajs ls = new Lasitajs();
      ls.lasiVardus();
    }

    public String[] lasiVardus() {
      try {
        File Dotie_Vārdi = new File("Dotie_Vārdi.txt"); // atver
        Scanner Lasītājs = new Scanner(Dotie_Vārdi);
        while (Lasītājs.hasNextLine()) {
          vardiLst.add((Lasītājs.nextLine()).toLowerCase()); //lasa text
        }
        Lasītājs.close();
      } catch (FileNotFoundException e) {
        System.out.println("brrrr kods aizgaja kakaa"); // parbauda vai ir file
      }
      String[] vardi = new String[vardiLst.size()];
      
      for (int pauls = 0; pauls < vardiLst.size(); pauls++){
        vardi[pauls] = vardiLst.get(pauls);
      }
      return vardi;
    }
    
  }
