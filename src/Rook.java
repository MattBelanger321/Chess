import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rook extends Piece{
    private boolean hasMoved;   //A FLAG USED TO SEE IF CASTLING IS POSSIBLE

    public Rook(String pos, boolean isWhite){
        hasMoved = false;
        super.pos = pos;
        super.name = "ROOK";
        super.isWhite = isWhite;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteRook.png" : "blackRook.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("ROOK ICON NOT FOUND");
        }
    }

    @Override
    protected void showMoves() {

    }
}
