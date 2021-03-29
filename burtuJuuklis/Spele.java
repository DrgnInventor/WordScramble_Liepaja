package burtuJuuklis;

import java.util.Scanner;

public class Spele {
    
    public Tabula tb = new Tabula();
    public Lasitajs ls = new Lasitajs();
    public BurtuJuklis bj = new BurtuJuklis(3, 10);
    public Adreses ad = new Adreses();
    public Speletajs sp;
    public Interfeis intface = new Interfeis();
    public Rezultati rez = new Rezultati();
    public Ertak e = new Ertak(); 
    public static String playerName;
    String apsleptaisVards = new String("Dabas Maja");

    public void gameStartInputs(Scanner datuIevade){
        String tempName;
        String choice;
        e.print("Sveicināts spēletāj! \n");
        e.print("Jūs spēlējat spēli Burtu Jūklis.\n"); 
        e.print("Spēli veidoja komanda \"Masīvi sākas no viens\"\n");
        do {
            e.print("Lūdzu ievadiet savu vārdu ,lai var atzimēt rezultātus: ");
            tempName = datuIevade.nextLine();
            e.print("Vai ievadījāt vārdu pareizi? "  + tempName +"\n");
            e.print("****** \nJ - Jā \nN - Nē \n");
            choice = datuIevade.nextLine();
        } while (choice.equals("N"));
        e.print("Veiksmi spēlē " + tempName + "!\n\n");
        playerName = new String(tempName);
        sp = new Speletajs(playerName);// dumb code
    };

    public void startGame(Scanner datuIevade){
        intface.x = bj.platums;
        intface.y = bj.garums;

          char[][] brtj = bj.rezgaBuvesana(ls.lasiVardus(), ad); //izveido rezgi

            if(bj.tabulaDer){//parbauda vai rezgis ir izdevies
                tb.printTabula(brtj);
                sp.sak_laiks(); // speles sakums
                intface.userInput(bj, ad, tb, datuIevade);
                } else {
                    e.print("Kautkas nestrādā.");
                }

        };

    public void guessName(Scanner datuIevade){
        String minejums = new String("");
        e.print("Apsveicu atradāt visus apslēptos vārdus burtu jūklī! \n");
        e.print("Tagad jums jātmin vārds ko veido atminēto vārdu sākuma burti! \n \n \n");
        do {
            e.print("Atminētie vārdi:\n");
            ad.getAtminetieVardi();
            e.print("\n\n\n");
            e.print("Kas ir apslēptais vārds?\n");
            minejums = datuIevade.next();
            if ((minejums.toLowerCase()).equals(apsleptaisVards.toLowerCase())){
            } else {
                e.print("Nepareizs minējums. Mēģiniet vēlreiz! \n\n");
            }
        } while ((minejums.toLowerCase()).equals(apsleptaisVards.toLowerCase()));
        sp.beigu_laiks();
    }

    public void endGame(){
    e.print("Malacis " + playerName + "!\n");
    e.print("Spēli laiks: " + sp.speletais_laiks + "\n");
    };
    
    public void gameOptions(Scanner datuIevade){
    e.print("Vai vēlaties redzēt labākos rezultātus?" + "\n");
    e.print("****** \nJ - Jā \nN - Nē \n");
    String izveele = datuIevade.next();
    if (izveele.equals("J")){
        rez.paradiLabakosRezultatus();
        e.print("\n\n\nSpēles beigas.");
    } else {
        e.print("Spēles beigas.");
    }
    };
}
