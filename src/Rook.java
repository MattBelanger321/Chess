import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Rook extends Piece{
    private boolean hasMoved;   //A FLAG USED TO SEE IF CASTLING IS POSSIBLE

    public Rook(String pos, boolean isWhite,int i,int j){
        hasMoved = false;
        super.pos = pos;
        super.name = "ROOK";
        super.isWhite = isWhite;
        super.i = i;
        super.j = j;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteRook.png" : "blackRook.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("ROOK ICON NOT FOUND");
        }
    }

    @Override
    protected LinkedList<Square> showMoves(Square[][] squares) {
        return null;
    }
}
