import java.util.Scanner;

public class Spele {
    
    private Tabula tb = new Tabula();
    private Lasitajs ls = new Lasitajs();
    private BurtuJuklis bj = new BurtuJuklis(20, 20);
    private Adreses ad = new Adreses();
    private Speletajs sp;
    private Interfeis intface = new Interfeis();
    private Rezultati rez = new Rezultati();
    private static String playerName;
    private String apsleptaisVards;

    /**
     * @param apsleptaisVards vards kas speletajam jatmin no burtu jukli esoso vardu pirmajiem burtiem 
     * @param slepenaisVards norada apslepto vardu, kas jaatmin.
     */

    public Spele(String slepenaisVards) {
        this.apsleptaisVards = slepenaisVards.toLowerCase();
    }

    /**
     * Publiskas metodes
     * gameStartInput() iegust speletaja vardu
     * startGame() sak speli
     * guessName() kad atmin vardus prasa atminet no atminetajiem vardiem apsleptu vardu
     * endGame() beidz speli pasaka speletajam speleto laiku
     * gameOption() piedava speletajam apskatities labakos rezultatus
     */

    public void gameStartInputs(){
        Scanner datuIevade = new Scanner(System.in);
        
        String tempName;
        String choice;

        System.out.print("Sveicinats, Speletaj! \n");
        System.out.print("Jus spelejat speli Burtu Juklis.\n"); 
        System.out.print("Speli veidoja komanda \"Masivi sakas no 1\"\n");

        do {
            System.out.print("Ludzu ievadiet savu vardu: ");
            tempName = datuIevade.nextLine();
            System.out.print("Vai ievadijat vardu pareizi? "  + tempName +"\n");
            System.out.print("****** \nJ - Ja \nN - Ne \n> ");
            choice = datuIevade.nextLine().toUpperCase().substring(0,1);
            } while (choice.equals("N"));
        
        playerName = tempName;
        sp = new Speletajs(playerName);

        System.out.print("Veiksmi spele " + playerName + "!\n\n");
    }

    //Sak speli izveidu burtujuukli un sak speles minesanas ciklu
    public void startGame(){
        intface.x = bj.platums;
        intface.y = bj.garums;

        char[][] brtj = bj.rezgaBuvesana(ls.lasiVardus(), ad);

        if(bj.tabulaDer){
            System.out.println("Tev jaatrod:\n");
            ad.getNeatminetieVardi();
            System.out.println();
            tb.printTabula(brtj);
            sp.sakLaiks();
            intface.userInput(bj, ad, tb);
            } else {
            System.out.print("Radas klume burtu jukla generesana.");
            }
    }

    //Izprinte atminetos vardus un prasa speletajam ievadit apslepto vardu !!Garumzimes nestrada
    public void guessName(){
        Scanner s = new Scanner(System.in);

        System.out.print("Apsveicu atradat visus apsleptos vardus burtu jukli!\n");
        System.out.print("Tagad jums jaatmin vards ko veido atmineto vardu sakuma burti!\n\n\n");

        String minejums;

        do {
            System.out.println("Minejums javeic bez garumzimem!");
            System.out.println("Atminetie vardi:\n");
            
            ad.getAtminetieVardi();
            
            System.out.print("\n\n\n");
            
            System.out.print("Kas ir apsleptais vards?\n> ");
            minejums = s.nextLine().toLowerCase();
            if (minejums.equals(apsleptaisVards)){
                System.out.println("Uzminejat!");
                } else {
                System.out.print("Nepareizs minejums. Meginiet velreiz!\n\n");
                }
            
            } while (!(minejums.equals(apsleptaisVards)));
        }
    
    //Pabeidz speli, pasaka speletajam speleto laiku
    public void endGame(){
        sp.beiguLaiks();
        System.out.print("Malacis " + playerName + "!\n");
        System.out.print("Speles laiks: " + sp.speletaisLaiks + "\n");
    }

    //Dod speletajam izveli apskatities labakos rezultatus.
    public void gameOptions(){
        Scanner s = new Scanner(System.in);
        
        System.out.print("Vai velaties redzet labakos rezultatus?" + "\n");
        System.out.print("** \nJ - Ja \nN - Ne \n> ");
        String izvele = s.nextLine();

        izvele = izvele.toUpperCase().substring(0,1);
        
        if (izvele.equals("J")){
            rez.paradiLabakosRezultatus();
            System.out.print("\n\n\nSpeles beigas.");
            } else {
            System.out.print("Speles beigas.");
            }
        
            s.close();
    }
}
