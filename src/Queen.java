import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Queen extends Piece {
    public Queen(String pos, boolean isWhite,int i,int j){
        super.pos = pos;
        super.name = "QUEEN";
        super.isWhite = isWhite;
        super.i = i;
        super.j = j;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteQueen.png" : "blackQueen.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.printf("%s QUEEN ICON NOT FOUND\n",isWhite?"WHITE":"BLACK");
        }
    }

    @Override
    protected LinkedList<Square> showMoves(Square[][] squares) {
        return null;
    }
}
