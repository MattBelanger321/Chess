import javax.swing.*;
import java.awt.*;

public class Square extends JPanel{
    private String name;    //STRING CONTAINING THIS SQUARES COORDINATE (EX G4)
    private boolean isWhite;
    private Piece state = null;

    public Square(String name, boolean isWhite){
        this.name = name;
        this.setBackground(isWhite?new Color(255,255,255):new Color(0,0,0));
        this.isWhite = isWhite;

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
            System.err.println(e);
        }
    }

    
    public void setColor(int r,int g,int b){
        this.setBackground(new Color(r,g,b));
    }

    public boolean showMoves(){
        if(state == null){return false;}
        return true;
    }
}