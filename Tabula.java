public class Tabula {
  
    public void printTabula(char[][] tabula) {
        for (int i = 0; i<tabula.length; i++) { // sie cikli izprinte masivu
            if(i == 0){
                System.out.print("   ");
            }else if (i < 10){
                System.out.print(" " + i + " ");
            }else{
                System.out.print(i + " ");
            }
            for (int j = 0; j<tabula[i].length; j++) {
                System.out.print(tabula[i][j] + " ");
            }
            System.out.println();
        }
    }
  
  }