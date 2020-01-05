import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Knight extends Piece {

    public Knight(String pos, boolean isWhite,int i ,int j){
        super.pos = pos;
        super.name = "KNIGHT";
        super.isWhite = isWhite;
        super.i = i;
        super.j = j;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteKnight.png" : "blackKnight.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("KNIGHT ICON NOT FOUND");
        }
    }

    @Override
    protected LinkedList<Square> showMoves(Square[][] squares) {
        return null;
    }
}
