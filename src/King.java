import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class King extends Piece{
    private boolean hasMoved; //A FLAG USED TO SEE IF CASTLING IS POSSIBLE

    public King(String pos, boolean isWhite){
        hasMoved = false;
        super.pos = pos;
        super.name = "KING";
        super.isWhite = isWhite;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteKing.png" : "blackKing.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("KING ICON NOT FOUND");
        }
    }

}
