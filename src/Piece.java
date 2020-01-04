import java.awt.image.BufferedImage;

public abstract class Piece {
    protected String pos;
    protected BufferedImage icon;
    protected String name;
    protected boolean isWhite;
    protected abstract void showMoves();
    protected boolean isTemp;

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
