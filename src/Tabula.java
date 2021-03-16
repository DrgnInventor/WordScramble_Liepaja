public class Tabula {
	
	static char[][] tabula; //metod�m pieejams main�gais
	
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
		int n = 5; // control� garumu (y dimensiju)
		int m = 8; // platumu (x dimensiju)
		tabula = new char[n][m];
		for (int i = 0; i<tabula.length; i++) { // �ie cikli aizpilda mas�vu ar placeholder v�rt�b�m, simul�jot aizpild�tu tabulu
			for (int j = 0; j<tabula[i].length; j++) {
				tabula[i][j] = 'a';
			}
		}
	}
	
	public static void printTabula() {
		for (int i = 0; i<tabula.length; i++) { // �ie cikli izprint� mas�vu
			for (int j = 0; j<tabula[i].length; j++) {
				System.out.print(tabula[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
