import javax.swing.*;

public interface Global {
    JTextArea menu = new JTextArea();
    JFrame main = new JFrame("Chess");

    //POSSIBLE STATES
    int REGULAR_PLAY = 0;
    int WHITE_PLAY = 1;
    int BLACK_PLAY = 2;
    int WHITE_CHECK = 3;  //WHITE IS IN CHECK
    int BLACK_CHECK = 4;  //BLACK IS IN CHECK
    int STALEMATE = 5;
    int WHITE_WINS = 6;   //BLACK HAS BEEN CHECKMATED
    int BLACK_WINS = 7;   //WHITE HAS BEEN CHECKMATED
}
