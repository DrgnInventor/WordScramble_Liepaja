package burtuJuuklis;

public class Galvenais {
    public static void main(String[] args){
        Spele sp = new Spele("Dabas maja", "Dabas mja");
        sp.gameStartInputs();
        sp.startGame();
        sp.guessName();
        sp.endGame();
        sp.gameOptions();
    }
}