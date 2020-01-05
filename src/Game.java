import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Game implements ActionListener,Global {
    private Piece[] whites = new Piece[16]; // WHITE PLAYER PIECES
    private Piece[] blacks = new Piece[16]; // BLACK PLAYERS PIECES
    private Square[][] squares = new Square[8][8]; //GAME BOARD
    private int state = PRE_GAME;  //HOLDS BOARD STATE
    private Square active = null;

    public Game(){
        //Makes Board
        createBoard();

        //Makes Sidebar
        createSideBar();

        //Create Frame
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1000,640); //width height
        main.setLayout(null);   //using no layout managers
        main.setVisible(true);  //making the frame visible
    }//Constructor

    public void play() {
        for(int i = 0;state<3;i++){
            if(i%2==0){
                menu.setText("WHITE PLAYER'S TURN!\nPLEASE SELECT A PIECE ");
                setState(WHITE_PLAY);
                makeMove();
            }else{
                menu.setText("BLACK PLAYER'S TURN!\nPLEASE SELECT A PIECE ");
                setState(BLACK_PLAY);
                makeMove();
            }
            resetBoard();
        }
    }

    public void makeMove(){
        boolean moveMade = false;
        while(!moveMade){
            menu.setText(menu.getText());   //FIX A THREADING ISSUE
            if(state == WHITE_PLAY){    //WHITES TURN
                if(active != null){
                    if((active.getState() == null) || !active.getState().getColor()){ //NO PIECE FOUND OR COLOR MISMATCH
                        menu.setText("PLEASE SELECT A VALID PIECE");
                    }else{
                        menu.setText("YOU SELECTED A VALID PIECE");
                        active.getState().showMoves(squares);
                        if(active!=null){
                            Square temp = active;
                            while(true){
                                menu.setText(menu.getText());   //FIX THREADING ISSUE
                                if(active!=null && !active.equals(temp) && isValidMove(active,temp.getState().showMoves(squares))){
                                    if(active.getState() != null){
                                        active.removeIcon();
                                        active.removeState();
                                    }
                                    active.setState(temp.getState());
                                    menu.setText(String.format("You moved %s to %s",temp.getState(),active));
                                    squares[temp.i][temp.j].removeIcon();
                                    squares[temp.i][temp.j].removeState();
                                    moveMade = true;
                                    break;
                                }else if(active == null){
                                    break;
                                }
                            }
                        }
                        resetBoard();
                    }
                }
            }else if(state == BLACK_PLAY){
                if(active != null){
                    if((active.getState() == null) || active.getState().getColor()){ //NO PIECE FOUND OR COLOR MISMATCH
                        menu.setText("PLEASE SELECT A VALID PIECE");
                    }else{
                        menu.setText("YOU SELECTED A VALID PIECE");
                        active.getState().showMoves(squares);
                        if(active!=null){
                            Square temp = active;
                            while(true){
                                menu.setText(menu.getText());   //FIX THREADING ISSUE
                                if(active!=null && !active.equals(temp) && isValidMove(active,temp.getState().showMoves(squares))){
                                    if(active.getState() != null){
                                        active.removeIcon();
                                        active.removeState();
                                    }
                                    active.setState(temp.getState());
                                    menu.setText(String.format("You moved %s to %s",temp.getState(),active));
                                    squares[temp.i][temp.j].removeIcon();
                                    squares[temp.i][temp.j].removeState();
                                    moveMade = true;
                                    break;
                                }else if(active == null){
                                    break;
                                }
                            }
                        }
                        resetBoard();
                    }
                }
            }
        }
    }

    private boolean isValidMove(Square square, LinkedList<Square> possibles){
        for(Square s: possibles){
            if(square.equals(s))
                return true;
        }
        return false;
    }

    private void populateSquares(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                squares[i][j] = new Square(String.format("%c%d",i+65,j+1), ((i + j) % 2) == 0,i,j,this); //Creates Square
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

    private void placePieces(){
        //PAWNS

        whites[0] = new Pawn("A2",true,0,6);
        blacks[0] = new Pawn("A7",false,0,1);
        whites[1] = new Pawn("B2",true,1,6);
        blacks[1] = new Pawn("B7",false,1,1);
        whites[2] = new Pawn("C2",true,2,6);
        blacks[2] = new Pawn("C7",false,2,1);
        whites[3] = new Pawn("D2",true,3,6);
        blacks[3] = new Pawn("D7",false,3,1);
        whites[4] = new Pawn("E2",true,4,6);
        blacks[4] = new Pawn("E7",false,4,1);
        whites[5] = new Pawn("F2",true,5,6);
        blacks[5] = new Pawn("F7",false,5,1);
        whites[6] = new Pawn("G2",true,6,6);
        blacks[6] = new Pawn("G7",false,6,1);
        whites[7] = new Pawn("H2",true,7,6);
        blacks[7] = new Pawn("H7",false,7,1);

        //ROOKS

        whites[8] = new Rook("A1",true,0,7);
        blacks[8] = new Rook("A8",false,0,0);
        whites[15] = new Rook("H1",true,7,7);
        blacks[15] = new Rook("H8",false,7,0);

        //KNIGHTS

        whites[9] = new Knight("B1",true,1,7);
        blacks[9] = new Knight("B8",false,1,0);
        whites[14] = new Knight("G1",true,6,7);
        blacks[14] = new Knight("G8",false,6,0);

        //BISHOPS

        whites[10] = new Bishop("C1",true,2,7);
        blacks[10] = new Bishop("C8",false,2,0);
        whites[13] = new Bishop("F1",true,5,7);
        blacks[13] = new Bishop("F8",false,5,0);

        //KINGS & QUEENS

        whites[11] = new Queen("D1",true,3,7);
        blacks[11] = new Queen("D8",false,3,0);
        whites[12] = new King("E1",true,4,7);
        blacks[12] = new King("E8",false,4,0);

        for(int i = 0; i<32; i++){  //PLACES PIECES
            if(i%2==0){ //WHITE PIECES
                squares[i/2 - (i>15?8:0)][6 + (i>15?1:0)].setState(whites[i/2]);
            }else{  //BLACK PIECES
                squares[i/2 - (i>15?8:0)][1 - (i>15?1:0)].setState(blacks[i/2]);
            }
        }
    }   //placePiece

    public void setState(int newState){
        state = newState;
    }

    public void waitOK(){
        while(!menu.getText().equals("")){
            if(menu.getText().equals("")){
                return;
            }
        }
    }//waitOK

    public int getState(){
        return state;
    }

    public void resetBoard(){
        squares[0][0].deactivate();
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                squares[i][j].setBackground(squares[i][j].isWhite()?new Color(255,255,255):new Color(0,0,0));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(menu.getText().equals("")){
            menu.setText("OK");
        }else{
            menu.setText("");
        }
        resetBoard();
    }

    public void activate(int i, int j) {
        if(active != null){
            deactivate();
        }
        active = squares[i][j];
        menu.setText(menu.getText());
    }

    public void deactivate() {
        if(active != null){
            active.deactivate();
        }
        active = null;
    }
}//class