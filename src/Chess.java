import javax.swing.*;

public class Chess {
    public static void main(String args[]){
        Game game = new Game();
        game.waitOK();
        game.play();
    }
}