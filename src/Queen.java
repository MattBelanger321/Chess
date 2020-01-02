import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Queen extends Piece {
    public Queen(String pos, boolean isWhite){
        super.pos = pos;
        super.name = "QUEEN";
        super.isWhite = isWhite;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteQueen.png" : "blackQueen.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.printf("%s QUEEN ICON NOT FOUND\n",isWhite?"WHITE":"BLACK");
        }
    }

    @Override
    protected void showMoves() {

    }
}
