package burtuJuuklis;

import java.util.Scanner;

public class Spele {
    
    public Tabula tb = new Tabula();
    public Lasitajs ls = new Lasitajs();
    public BurtuJuklis bj = new BurtuJuklis(20, 20);
    public Adreses ad = new Adreses();
    public Speletajs sp;
    public Interfeis intface = new Interfeis();
    public Rezultati rez = new Rezultati();
    public static String playerName;
    String apsleptaisVards = new String("Dabas Maja");

    public void gameStartInputs(Scanner datuIevade){
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
        System.out.print("Veiksmi spēlē " + tempName + "!\n\n");
        playerName = new String(tempName);
        sp = new Speletajs(playerName);// dumb code
    }

    public void startGame(Scanner datuIevade){
        intface.x = bj.platums;
        intface.y = bj.garums;

          char[][] brtj = bj.rezgaBuvesana(ls.lasiVardus(), ad); //izveido rezgi

            if(bj.tabulaDer){//parbauda vai rezgis ir izdevies
                tb.printTabula(brtj);
                sp.sakLaiks(); // speles sakums
                intface.userInput(bj, ad, tb, datuIevade);
                } else {
                    System.out.print("Kautkas nestrādā.");
                }

        }

        public void guessName(){
            String minejums = new String("");
            Scanner z = new Scanner(System.in);
            System.out.print("Apsveicu atradāt visus apslēptos vārdus burtu jūklī! \n");
            System.out.print("Tagad jums jātmin vārds ko veido atminēto vārdu sākuma burti! \n \n \n");
            do {
                System.out.print("Atminētie vārdi:\n");
                ad.getAtminetieVardi();
                System.out.print("\n\n\n");
                System.out.print("Kas ir apslēptais vārds?\n");
                minejums = z.nextLine();
                if ((minejums.toLowerCase()).equals(apsleptaisVards.toLowerCase())){
                    System.out.println("Uzminējāt!");
                } else {
                    System.out.print("Nepareizs minējums. Mēģiniet vēlreiz! \n\n");
                }
            } while (!(minejums.toLowerCase().equals(apsleptaisVards.toLowerCase())));
            sp.beiguLaiks();
        }

    public void endGame(){
    System.out.print("Malacis " + playerName + "!\n");
    System.out.print("Spēli laiks: " + sp.speletais_laiks + "\n");
    }

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
