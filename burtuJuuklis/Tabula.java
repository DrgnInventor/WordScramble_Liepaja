public class Tabula {

  //  public char[][] tabula; //metodēm pieejams mainīgais
  
 //   public void makeTabula() {
   //     int n = 5; // controlē garumu (y dimensiju)
     //   int m = 8; // platumu (x dimensiju)
        //tabula = new char[n][m];
       // for (int i = 0; i<tabula.length; i++) { // šie cikli aizpilda masīvu ar placeholder vērtībām, simulējot aizpildītu tabulu
          //  for (int j = 0; j<tabula[i].length; j++) {
              //  tabula[i][j] = 'a';
            //}
        //}
    //}
  
    public void printTabula(char[][] tabula) {
        for (int i = 0; i<tabula.length; i++) { // šie cikli izprintē masīvu
            for (int j = 0; j<tabula[i].length; j++) {
                System.out.print(tabula[i][j] + " ");
            }
            System.out.println();
        }
    }
  
  }