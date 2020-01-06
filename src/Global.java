import javax.swing.*;

public interface Global {
    JTextArea menu = new JTextArea();
    JFrame main = new JFrame("Chess");

    //POSSIBLE STATES
    final int PRE_GAME = 0;
    final int WHITE_PLAY = 1;
    final int BLACK_PLAY = 2;
    final int WHITE_CHECK = 3;  //WHITE IS IN CHECK
    final int BLACK_CHECK = 4;  //BLACK IS IN CHECK
    final int STALEMATE = 5;
    final int WHITE_WINS = 6;   //BLACK HAS BEEN CHECKMATED
    final int BLACK_WINS = 7;   //WHITE HAS BEEN CHECKMATED
}
