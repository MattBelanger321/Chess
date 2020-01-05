import java.awt.image.BufferedImage;
import java.util.LinkedList;

public abstract class Piece {
    protected String pos;
    protected BufferedImage icon;
    protected String name;
    protected boolean isWhite;
    protected boolean isTemp;
    protected int i,j;  //array coordiates of this piece

    protected abstract LinkedList<Square> showMoves(Square[][] squares);

    public String toString(){
        return String.format("%s %s", isWhite?"WHITE":"BLACK",name);
    }

    public BufferedImage getIcon(){
        return icon;
    }

    public String getPosition(){
        return pos;
    }

    public boolean getColor(){
        return isWhite;
    }

    public void setPosition(String position){
        pos = position;
    }

    public void setCoors(int i,int j){
        this.i = i;
        this.j = j;
    }

}
