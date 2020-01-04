import javax.swing.*;

public interface Global {
    JTextArea menu = new JTextArea();
    JFrame main = new JFrame("Chess");

    //POSSIBLE STATES
    final int PRE_GAME = 0;
    final int WHITE_PLAY = 1;
    final int BLACK_PLAY = 2;
    final int WHITE_CHECK = 3;  //WHITE IS IN CHECK
    final int BLACK_CHECK = 5;  //BLACK IS IN CHECK
    final int STALEMATE = 6;
    final int WHITE_WINS = 7;   //BLACK HAS BEEN CHECKMATED
    final int BLACK_WINS = 8;   //WHITE HAS BEEN CHECKMATED
}
