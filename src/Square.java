import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JToggleButton implements Global, ActionListener {
    private String name;    //STRING CONTAINING THIS SQUARES COORDINATE (EX G4)
    private boolean isWhite;
    private Piece state = null;
    public static Square active = new Square();
    private boolean isActive;

    public Square(String name, boolean isWhite,int i , int j){
        this.name = name;
        this.setBackground(isWhite?new Color(255,255,255):new Color(0,0,0));
        this.isWhite = isWhite;
        setBounds(70*i,70*j,70, 70);  //x axis, y axis, width, height

        //ICONS WILL FILL FULL BUTTON
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setMargin(new Insets(0,0,0,0));
        isActive = false;
    }

    public Square(){}

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
            if(piece!=null){
                JLabel picLabel = new JLabel(piece.name);
                add(picLabel);
            }
        }
    }


    public void setColor(int r,int g,int b){
        this.setBackground(new Color(r,g,b));
    }

    public boolean showMoves(){
        return state != null;
    }

    public void setActive(){
        if(active.equals(this)){
            active = new Square();
            menu.setText(String.format("YOU SELECTED %s",toString()));
        }else{
            active = this;
            menu.setText(String.format("YOU DESELECTED %s",toString()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        isActive = !isActive;
        if(isActive){
            setBackground(new Color(100,150,232));
        }else{
            this.setBackground(isWhite?new Color(255,255,255):new Color(0,0,0));
        }
    }
}