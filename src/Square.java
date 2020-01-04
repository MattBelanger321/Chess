import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Square extends JButton implements Global, ActionListener {
    private String name;    //STRING CONTAINING THIS SQUARES COORDINATE (EX G4)
    private boolean isWhite;    //true if this square is white
    private Piece state = null; //Stores the piece this square has
    private boolean isActive;   //true if this square is selected
    private Game game;  // a reference to the game this square is apart of
    private int i,j; //a reference to the index of this square on a gameboard;

    public Square(String name, boolean isWhite,int i , int j, Game game){
        this.name = name;
        this.setBackground(isWhite?new Color(255,255,255):new Color(0,0,0));
        this.isWhite = isWhite;
        setBounds(70*i,70*j,70, 70);  //x axis, y axis, width, height

        //ICONS WILL FILL FULL BUTTON
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setMargin(new Insets(0,0,0,0));
        isActive = false;
        this.game = game;

        addActionListener(this);

        this.i = i;
        this.j = j;
    }

    public boolean isWhite(){
        return isWhite;
    }

    public String toString(){
        return name;
    }

    public void setState(Piece piece){
        state = piece;
        try{
            JLabel picLabel = new JLabel(new ImageIcon(state.icon));
            add(picLabel);
        }catch(NullPointerException e){
            if(piece!=null){
                JLabel picLabel = new JLabel(piece.name);
                add(picLabel);
            }
            state = null;
        }
    }

    public boolean showMoves(){
        return state != null;
    }

    public Piece getState(){
        return state;
    }

    public void activate(){
        setBackground(new Color(255,255,0));
    }

    public void deactivate(){
        setBackground(isWhite?new Color(255,255,255):new Color(0,0,0));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(!isActive){
            activate();
            game.activate(i,j);
        }else{
            deactivate();
            game.deactivate();
        }
        isActive = !isActive;
    }
}