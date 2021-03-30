package burtuJuuklis;

public class Galvenais {
    
    public static void main(String[] args){
        Spele sp = new Spele("Dabas maja");
        sp.gameStartInputs();
        sp.startGame();
        sp.guessName();
        sp.endGame();
        sp.gameOptions();
    }
}