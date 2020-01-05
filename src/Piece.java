import java.awt.image.BufferedImage;

public abstract class Piece {
    protected String pos;
    protected BufferedImage icon;
    protected String name;
    protected boolean isWhite;
    protected boolean isTemp;
    protected int i,j;  //array coordiates of this piece

    protected abstract Square[] showMoves(Square[][] squares);

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

}
