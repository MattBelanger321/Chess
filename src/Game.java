import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener,Global {
    private Piece[] whites = new Piece[16]; // WHITE PLAYER PIECES
    private Piece[] blacks = new Piece[16]; // BLACK PLAYERS PIECES
    private Square[][] squares = new Square[8][8];
    private int state;  //HOLDS BOARD STATE

    //POSSIBLE STATES
    private final int REGUALR_PLAY = 0;
    private final int WHITE_CHECK = 1;  //WHITE IS IN CHECK
    private final int BLACK_CHECK = 2;  //BLACK IS IN CHECK
    private final int STALEMATE = 3;
    private final int WHITE_WINS = 4;   //BLACK HAS BEEN CHECKMATED
    private final int BLACK_WINS = 5;   //WHITE HAS BEEN CHECKMATED

    public Game(){
        state = 0;

        //Makes Board
        createBoard();

        //Makes Sidebar
        createSideBar();

        //Create Frame
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1000,640); //width height
        main.setLayout(null);   //using no layout managers
        main.setVisible(true);  //making the frame visible

        //Initialize Players
        Player white = new Player(true);
        Player black = new Player(false);
    }//Constructor

    private void populateSquares(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                squares[i][j] = new Square(String.format("%c%d",i+65,j+1), ((i + j) % 2) == 0,i,j); //Creates Square
                squares[i][j].setBounds(75*i,75*j,75, 75);  //x axis, y axis, width, height
                main.add(squares[i][j]);    //adds button to frame
            }
        }
    }

    private void createBoard(){
        populateSquares();
        placePieces();
    }

    private void createSideBar(){
        //OK BUTTON
        JButton ok = new JButton("OK");
        ok.setBounds(750,50,100,100);
        ok.addActionListener(this);
        main.add(ok);

        //TEXT BOX
        menu.setEditable(false);
        menu.setText("WELCOME TO CHESS\nPRESS OK TO BEGIN");
        menu.setBounds(635,300,300,200);
        main.add(menu);
    }//sidebar

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        menu.setText("");
    }

    private void placePieces(){
        //PAWNS

        whites[0] = new Pawn("A2",true);
        blacks[0] = new Pawn("A7",false);
        whites[1] = new Pawn("B2",true);
        blacks[1] = new Pawn("B7",false);
        whites[2] = new Pawn("C2",true);
        blacks[2] = new Pawn("C7",false);
        whites[3] = new Pawn("D2",true);
        blacks[3] = new Pawn("D7",false);
        whites[4] = new Pawn("E2",true);
        blacks[4] = new Pawn("E7",false);
        whites[5] = new Pawn("F2",true);
        blacks[5] = new Pawn("F7",false);
        whites[6] = new Pawn("G2",true);
        blacks[6] = new Pawn("G7",false);
        whites[7] = new Pawn("H2",true);
        blacks[7] = new Pawn("H7",false);

        //ROOKS

        whites[8] = new Rook("A1",true);
        blacks[8] = new Rook("A8",false);
        whites[15] = new Rook("H1",true);
        blacks[15] = new Rook("H8",false);

        //KNIGHTS

        whites[9] = new Knight("B1",true);
        blacks[9] = new Knight("B8",false);
        whites[14] = new Knight("G1",true);
        blacks[14] = new Knight("G8",false);

        //BISHOPS

        whites[10] = new Bishop("C1",true);
        blacks[10] = new Bishop("C8",false);
        whites[13] = new Bishop("F1",true);
        blacks[13] = new Bishop("F8",false);

        //KINGS & QUEENS

        whites[11] = new Queen("D1",true);
        blacks[11] = new Queen("D8",false);
        whites[12] = new King("E1",true);
        blacks[12] = new King("E8",false);

        for(int i = 0; i<32; i++){  //PLACES PIECES
            if(i%2==0){ //WHITE PIECES
                squares[i/2 - (i>15?8:0)][6 + (i>15?1:0)].setState(whites[i/2]);
            }else{  //BLACK PIECES
                squares[i/2 - (i>15?8:0)][1 - (i>15?1:0)].setState(blacks[i/2]);
            }
        }
    }   //placePiece

    public void start() {
        waitOK();
        for(int i = 0;state<3;i++){

        }
    }

    public void setState(int newState){
        state = newState;
    }

    private void waitOK(){
        while(true){
            if(menu.getText().equals("")){
                return;
            }
        }
    }//waitOK
}//class