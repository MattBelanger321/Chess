import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Pawn extends Piece{

    private boolean hasMoved;   //A FLAG USED TO SEE IF A PAWN CAN MOVE TWO SPACES INSTEAD OF ONE

    public Pawn(String pos, boolean isWhite){
        hasMoved = false;
        super.pos = pos;
        super.name = "PAWN";
        super.isWhite = isWhite;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whitePawn.png" : "blackPawn.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("PAWN ICON NOT FOUND");
        }

    }

}