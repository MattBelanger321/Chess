import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Bishop extends Piece {

    public Bishop(String pos, boolean isWhite){
        super.pos = pos;
        super.name = "BISHOP";
        super.isWhite = isWhite;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteBishop.png" : "blackBishop.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("BISHOP ICON NOT FOUND");
        }
    }

    @Override
    protected void showMoves() {

    }
}
