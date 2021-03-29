package burtuJuuklis;

import java.util.Scanner;

public class Galvenais {
    
    public static void main(String[] args){
        Scanner datuIevade = new Scanner(System.in);
        Spele sp = new Spele();
        sp.gameStartInputs(datuIevade);
        sp.startGame(datuIevade);
        sp.guessName(datuIevade);
        sp.endGame();
        sp.gameOptions();
        datuIevade.close();
    }
}