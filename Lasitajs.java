public class Lasitajs {

    static ArrayList<String> vardiLst = new ArrayList<>(); // ArrayList ar vardiniem kas tiks apstradati
    static Object[] vardi;
  
    public static void main(String[] args) {
      lasiVardus();
    }
    public static Object[] lasiVardus() {
      try {
        File Dotie_Vārdi = new File("Dotie_Vārdi.txt"); // atver
        Scanner Lasītājs = new Scanner(Dotie_Vārdi);
        while (Lasītājs.hasNextLine()) {
          vardiLst.add(Lasītājs.nextLine()); //lasa text
        }
        Lasītājs.close();
      } catch (FileNotFoundException e) {
        System.out.println("brrrr kods aizgaja kakaa"); // parbauda vai ir file
      }
      vardi = vardiLst.toArray();
    }
  }