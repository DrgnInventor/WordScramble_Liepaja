package burtuJuuklis;

import java.util.Scanner;

public class Interfeis {
	
		public  int x = 5; //pagaidu vertibas
		public  int y = 4;
	
	public void userInput(BurtuJuklis jk, Adreses adr, Tabula t) { // moska outputtot 1-9 vai ko (cipars atbilst nosaukuma id)
		Scanner keyboard = new Scanner(System.in);
		boolean valid = false;
		char[] vienschar;
		char[] divichar;
		int i = adr.rindaVertibam.size();
		do {
			do {
				System.out.print("Ievadi pirmo koordinatu (1A formata): ");
				String viens = keyboard.next();
				vienschar = viens.toCharArray(); // sadala string uz char masivu
				valid = checkInput(vienschar); // parbauda vai koordinata ir pareizi uzrakstita
			} while (!valid);
			vienschar[1] = Character.toUpperCase(vienschar[1]); // parliecinas ka burts ir pareiza sintaksa
			do {
				System.out.print("Ievadi otro koordinatu (1A formata): ");
				String divi = keyboard.next();
				divichar = divi.toCharArray(); // sadala string uz char masivu
				valid = checkInput(divichar);
			} while (!valid);
			divichar[1] = Character.toUpperCase(divichar[1]);
			
			if (adr.salidzinatKoordinates(vienschar[1], Character.getNumericValue(vienschar[0]), divichar[1], Character.getNumericValue(divichar[0]))){
                            System.out.println("Wow tu nu gan gudrs.");
                            jk.varduDzesana(vienschar[1], Character.getNumericValue(vienschar[0]), divichar[1], Character.getNumericValue(divichar[0]), adr);
                            t.printTabula(jk.burtuJuklis);
                            jk.getVards(vienschar[1], Character.getNumericValue(vienschar[0]), divichar[1], Character.getNumericValue(divichar[0]), adr);
                            i = i - 1;
			} else {
				System.out.println(vienschar[1] +" "+ Character.getNumericValue(vienschar[0])+" "+ divichar[1]+" "+ Character.getNumericValue(divichar[0]));
				System.out.println("Broo u dumb hoe");
			}
			
		} while (i != 0);
                System.out.println("uzvara!!!");
		keyboard.close();
		//parbaudit vai koordinatas atrodas nosaukums
		//ja atrodas nosaukums, izcelt vinu, un nonemt 1 no mainiga(?)
		//visu loopot lidz visi vardi atrasti
		//ielikt mineshanu vardam
	}
	
	public boolean checkInput(char[] masivs) {
			boolean valid = true;
			//printTabula?()
			if (masivs.length > 2 || masivs.length < 2) { // parbauda vai ir tikai 2 rakstzimes
				System.out.println("Koordinatai nepieciesamas 2 rakstzimes!");
				valid = false;
			} else if (!(Character.isDigit(masivs[0]))) {  // parbauda vai pirma rakstzime koordinata ir cipars
				System.out.println("Pirmajai rakstzimei jabut ciparam.");
				valid = false;
			} else if (!((Character.getNumericValue(masivs[0]) > 0) && !(Character.getNumericValue(masivs[0]) > x)))  { // parbauda vai cipars ietilpst dotajos tabulas izmeros
				System.out.println("Cipars neietilpst tabulas koordinatu ietvaros.");
				valid = false;
			} else if (!(Character.isLetter(masivs[1]))) { //piarbauda vai parbauda vai otra rakstzime koordinata ir burts
				System.out.println("Otrajai rakstzimei jabut burtam.");
				valid = false;
			} else if (false) { //faking vajadzetu te iepist ka parbauda vai atbilstosh burts vai ne
				
			}
			return valid;
	}
	
}
		//tabula izprintajas
		//tiek paradita iepriekseja kluda rakstitai komandai
		//tiek prasits user input
		//user input tiek salidzinats (vai koordinatas atbilst nosaukumam, vai nosaukums jau nav bijis atrasts?)
		//ja koordinatas atbilst prasibam, nosaukumu izcel, padarot visus burtus uppercase (toUpperCase)
		//moska izveidot mainigo, kas speles sakuma atbilst visu nosaukumu skaitam, un nonemt no ta viens. Pec katras reizes salidzinat vai tas neatbilst 0, un ja atbilst, turpinat ar nakamo speles dalu