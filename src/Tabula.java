public class Tabula {
	
	static char[][] tabula; //metodçm pieejams mainîgais
	
	public static void main(String[] args) {
		makeTabula();
		printTabula();
		clearScreen();
		printTabula();
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	public static void makeTabula() {
		int n = 5; // controlç garumu (y dimensiju)
		int m = 8; // platumu (x dimensiju)
		tabula = new char[n][m];
		for (int i = 0; i<tabula.length; i++) { // ðie cikli aizpilda masîvu ar placeholder vçrtîbâm, simulçjot aizpildîtu tabulu
			for (int j = 0; j<tabula[i].length; j++) {
				tabula[i][j] = 'a';
			}
		}
	}
	
	public static void printTabula() {
		for (int i = 0; i<tabula.length; i++) { // ðie cikli izprintç masîvu
			for (int j = 0; j<tabula[i].length; j++) {
				System.out.print(tabula[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
