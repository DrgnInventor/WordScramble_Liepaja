package burtuJuuklis;

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
    private String apsleptaisVards1;
    private String apsleptaisVards2;

    /**
     * @param apsleptaisVards1 vard1s! vārds kas spēlētājam jātmin no burtu jūkli esošo vārdu pirmajiem burtiem 
     * @param slepenaisVards1 norāda apslēpto vārdu ,kas jātmin.
     * @param apsleptaisVards2 vard2s! vārds kas spēlētājam jātmin no burtu jūkli esošo vārdu pirmajiem burtiem 
     * @param slepenaisVards2 norāda apslēpto vārdu ,kas jātmin.
     */

    public Spele(String slepenaisVards1, String slepenaisVards2) {
        this.apsleptaisVards1 = slepenaisVards1;
        this.apsleptaisVards2 = slepenaisVards2;
    }

    /**
     * Publiskās metodes
     * gameStartInput() iegūst spēlētāja vārdu
     * startGame() sāk spēli
     * guessName() kad atmin vārdus prasa atminēt no atminētajiem vārdiem apslēptu vārdu
     * endGame() beidz spēli pasaka spēlētājam spēlēto laiku
     * gameOption() piedāvā spēlētājam apskatīties labākos rezultātus
     */

    public void gameStartInputs(){
        Scanner datuIevade = new Scanner(System.in);
        
        String tempName;
        String choice;

        System.out.print("Sveicināts spēletāj! \n");
        System.out.print("Jūs spēlējat spēli Burtu Jūklis.\n"); 
        System.out.print("Spēli veidoja komanda \"Masīvi sākas no viens\"\n");

        do {
            System.out.print("Lūdzu ievadiet savu vārdu ,lai var atzimēt rezultātus: ");
            tempName = datuIevade.nextLine();
            System.out.print("Vai ievadījāt vārdu pareizi? "  + tempName +"\n");
            System.out.print("****** \nJ - Jā \nN - Nē \n");
            choice = datuIevade.nextLine();
            } while (choice.equals("N"));
        
        playerName = new String(tempName);
        sp = new Speletajs(playerName);

        System.out.print("Veiksmi spēlē " + playerName + "!\n\n");
    }

    //Sāk spēli izveidu burtujuukli un sāk spēles min;e;sanas ciklu
    public void startGame(){
        intface.x = bj.platums;
        intface.y = bj.garums;

        char[][] brtj = bj.rezgaBuvesana(ls.lasiVardus(), ad);

        if(bj.tabulaDer){
            tb.printTabula(brtj);
            sp.sakLaiks();
            intface.userInput(bj, ad, tb);
            } else {
            System.out.print("Radās kļūme burtu jūkļa ģenerēšanā.");
            }
    }

    //Izprintē atminētos vārdus un prasa spēlētājam ievadīt apslēpto vārdu !!Garumzīmes nestrādā
    public void guessName(){
        Scanner s = new Scanner(System.in);

        System.out.print("Apsveicu atradāt visus apslēptos vārdus burtu jūklī! \n");
        System.out.print("Tagad jums jātmin vārds ko veido atminēto vārdu sākuma burti! \n \n \n");

        String minejums;

        do {
            System.out.print("Atminētie vārdi:\n");
            
            ad.getAtminetieVardi();
            
            System.out.print("\n\n\n");
            
            System.out.print("Kas ir apslēptais vārds?\nMINĒJUMU JĀVEIC BEZ GARUMZĪMĒM!\n");
            minejums = s.nextLine();
            if ((minejums.toLowerCase().equals(apsleptaisVards1.toLowerCase()))||(minejums.toLowerCase().equals(apsleptaisVards2.toLowerCase()))){
                System.out.println("Uzminējāt!");
                } else {
                System.out.print("Nepareizs minējums. Mēģiniet vēlreiz! \n\n");
                }
            
            } while (!(minejums.toLowerCase().equals(apsleptaisVards1.toLowerCase()))&&!(minejums.toLowerCase().equals(apsleptaisVards2.toLowerCase())));
        }
    
    //Pabeidz spēli, pasaka spēlētājam spēlēto laiku
    public void endGame(){
        sp.beiguLaiks();
        System.out.print("Malacis " + playerName + "!\n");
        System.out.print("Spēli laiks: " + sp.speletaisLaiks + "\n");
    }

    //Dod spēlētājam izvēli apskatīties labākos rezultātus.
    public void gameOptions(){
        Scanner s = new Scanner(System.in);
        
        System.out.print("Vai vēlaties redzēt labākos rezultātus?" + "\n");
        System.out.print("** \nJ - Jā \nN - Nē \n");
        String izvele = s.nextLine();

        izvele = izvele.toUpperCase();
        
        if (izvele.equals("J")){
            rez.paradiLabakosRezultatus();
            System.out.print("\n\n\nSpēles beigas.");
            } else {
            System.out.print("Spēles beigas.");
            }
        
            s.close();
    }
}
