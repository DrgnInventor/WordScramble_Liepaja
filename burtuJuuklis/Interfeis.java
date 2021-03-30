package burtuJuuklis;

import java.util.Scanner;

public class Interfeis {
	
	public int x;
	public int y;
	
	public void userInput(BurtuJuklis jk, Adreses adr, Tabula t) {
		Scanner keyboard = new Scanner(System.in);
		boolean valid = false;
		//char[] vienschar;
		//char[] divichar;
		//int vienscipari;
		//int divicipari;
		char viensburts;
		char diviburts;
		int viensskaitlis = 0;
		int diviskaitlis = 0;
		int i = adr.rindaVertibam.size();

		do {
			do {
				System.out.print("Ievadi pirmo koordinatu (A1 formata): ");
				String viens = keyboard.next();
				viensburts = viens.charAt(0);
				try {
				viensskaitlis = Integer.parseInt(viens.substring(1));
				} catch (NumberFormatException e) {
					System.out.println("Koordinātā jāievada atbilstošā formātā!");
					continue;
				}
				//if (isNan(viensskaitlis)) {

				//}
				//vienschar = viens.toCharArray(); // sadala string uz char masivu
				valid = checkInput(viensburts, viensskaitlis); // parbauda vai koordinata ir pareizi uzrakstita
			} while (!valid);
			viensburts = Character.toUpperCase(viensburts); // parliecinas ka burts ir pareiza sintaksa
			valid = false;
			do {
				System.out.print("Ievadi otro koordinatu (A1 formata): ");
				String divi = keyboard.next();
				diviburts = divi.charAt(0);
				try {
					diviskaitlis = Integer.parseInt(divi.substring(1));
				} catch (NumberFormatException e) {
					System.out.println("Koordinātā jāievada atbilstošā formātā!");
					continue;
				}
				//divichar = divi.toCharArray(); // sadala string uz char masivu
				valid = checkInput(diviburts, diviskaitlis);
			} while (!valid);
			diviburts = Character.toUpperCase(diviburts);

			/*if (y > 10) {
				String temp = ("" + vienschar[1] + vienschar[2]);
				vienscipari = Integer.parseInt(temp);
				temp = ("" + divichar[1] + divichar[2]);
				divicipari = Integer.parseInt(temp);
			} else {
				vienscipari = Character.getNumericValue(vienschar[1]);
				divicipari = Character.getNumericValue(divichar[1]);
			}*/
			
            if (adr.salidzinatKoordinates(viensburts, viensskaitlis, diviburts, diviskaitlis)){ //parbauda vai ievaditas koordinates ir pareizas
                int kartas_nr = adr.kartasNr; //koordinasu indekss vertibu rinda
                if(adr.checkAtminetieVardi(adr.rindaVertibam.get(kartas_nr).getVardsString())){ //parbauda vai vards atkartojas
                    jk.varduDzesana(viensburts, viensskaitlis, diviburts, diviskaitlis, adr); //parvers vardus uz lielajiem burtiem
                    t.printTabula(jk.burtuJuklis); //izprinte tabulu
                    adr.atminetieVardi.add(adr.rindaVertibam.get(kartas_nr).getVardsString()); //pievieno atmineto vardu rindai
                    System.out.println("Tev vēl jāatrod: ");
                    adr.rindaVertibam.remove(kartas_nr); //nonem atmineto vardu no vertibu rindas
                    adr.getNeatminetieVardi(); //izprinte neatminetos vardus
                    i--; 
                } else {
					t.printTabula(jk.burtuJuklis); //izprinte tabulu
                    System.out.println("Atkartojas, kringe.");
					
                }
            } else {
				t.printTabula(jk.burtuJuklis); //izprinte tabulu
				System.out.println("Nepareizi, Lasīt māki?");
            }

		} while (i != 0);
        System.out.println("Tu uzvarēji!");
	}
	
	public boolean checkInput(char burts, int skaitlis) {
		boolean valid = true;
		//printTabula?()
		/*if (y > 10  && !(masivs.length > 2 || masivs.length < 3)){
			System.out.println("Koordinatai nepieciesamas 2 vai 3 rakstzimes!");
			valid = false;
		} else if (y <= 10 && (masivs.length > 2 || masivs.length < 2)) { // parbauda vai ir tikai 2 rakstzimes
			System.out.println("Koordinatai nepieciesamas 2 rakstzimes!");
			valid = false;
		} else */ 
		if (!(Character.isLetter(burts))) { //parbauda vai pirma rakstzime koordinata ir burts
			System.out.println("Pirmajai rakstzimei jābut burtam.");
			valid = false;
		} else if (Character.getNumericValue(burts) >= 10 + x) { //parbauda vai burts ietilpst dotajos tabulas izmeros
			System.out.println("Burts neiekļaujas tabulas koordinātu ietvaros.");
			valid = false;
		} 
		//else if (!(Character.isDigit(skaitlis))) {  // parbauda vai otra rakstzime koordinata ir cipars
		//	System.out.println("Otrajai rakstzimei jabut ciparam.");
		//	valid = false;
		//} 
		else if (skaitlis <= 0 || skaitlis >= y)  { // parbauda vai cipars ietilpst dotajos tabulas izmeros
			System.out.println("Cipars neiekļaujas tabulas koordinātu ietvaros.");
			valid = false;
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