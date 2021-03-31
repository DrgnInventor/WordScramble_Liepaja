import java.util.Scanner;

public class Interfeis {
	
    public int x;
    public int y;

    public void userInput(BurtuJuklis jk, Adreses adr, Tabula t) {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        char viensburts;
        char diviburts;
        int viensskaitlis = 0;
        int diviskaitlis = 0;
        int i = adr.rindaVertibam.size();

        do {
            do {
                System.out.print("\nIevadi pirmo koordinatu (A1 formata): ");
                String viens = keyboard.next();
                viensburts = viens.charAt(0);
                try {
                viensskaitlis = Integer.parseInt(viens.substring(1));
                } catch (NumberFormatException e) {
                        System.out.println("Koordinata jaievada atbilstosa formata!");
                        continue;
                }
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
                        System.out.println("Koordinata jaievada atbilstosa formata!");
                        continue;
                }
                valid = checkInput(diviburts, diviskaitlis);
            } while (!valid);
            diviburts = Character.toUpperCase(diviburts);

            if (adr.salidzinatKoordinates(viensburts, viensskaitlis, diviburts, diviskaitlis)){ //parbauda vai ievaditas koordinates ir pareizas
                int kartas_nr = adr.kartasNr; //koordinasu indekss vertibu rinda
                jk.varduDzesana(viensburts, viensskaitlis, diviburts, diviskaitlis, adr); //parvers vardus uz lielajiem burtiem
                adr.atminetieVardi.add(adr.rindaVertibam.get(kartas_nr)); //pievieno atmineto vardu atmineto vardu rindai
                System.out.println("\nPareizs vards!\n");
                System.out.println("Tev vel jaatrod:\n");
                adr.neatminetieVardi.remove(adr.rindaVertibam.get(kartas_nr).getVardsString()); //nonem vardu no atminamo nosaukumu saraksta
                adr.getNeatminetieVardi(); //izprinte neatminetos vardus
                System.out.println();
                t.printTabula(jk.burtuJuklis); //izprinte tabulu
                i--; 
            } else {
                System.out.println("\nNav pareizi, megini velreiz!\n");
                System.out.println("Tev vel jaatrod:\n");
                adr.getNeatminetieVardi(); //izprinte neatminetos vardus
                System.out.println();
                t.printTabula(jk.burtuJuklis); //izprinte tabulu
            }

        } while (i != 0);
}

    public boolean checkInput(char burts, int skaitlis) {
            boolean valid = true;
            if (!(Character.isLetter(burts))) { //parbauda vai pirma rakstzime koordinata ir burts
                    System.out.println("Pirmajai rakstzimei jabut burtam.");
                    valid = false;
            } else if (Character.getNumericValue(burts) >= 10 + x) { //parbauda vai burts ietilpst dotajos tabulas izmeros
                    System.out.println("Burts neieklaujas tabulas koordinatu ietvaros.");
                    valid = false;
            } else if (skaitlis <= 0 || skaitlis >= y)  { // parbauda vai cipars ietilpst dotajos tabulas izmeros
                    System.out.println("Cipars neieklaujas tabulas koordinatu ietvaros.");
                    valid = false;
            }
            return valid;
    }
}