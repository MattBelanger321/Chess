import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Pawn extends Piece{

    private boolean hasMoved;   //A FLAG USED TO SEE IF A PAWN CAN MOVE TWO SPACES INSTEAD OF ONE

    public Pawn(String pos, boolean isWhite,int i,int j){
        hasMoved = false;
        super.pos = pos;
        super.name = "PAWN";
        super.isWhite = isWhite;
        super.i = i;
        super.j = j;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whitePawn.png" : "blackPawn.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("PAWN ICON NOT FOUND");
        }

    }

    @Override
    protected Square[] showMoves(Square[][] squares) {
        Square[] moves = new Square[3];
        squares[i][j+(isWhite?-1:1)].setColor(255,0,0);
        moves[0] = squares[i][j+(isWhite?-1:1)];
        if(!hasMoved){
            squares[i][j+(isWhite?-2:2)].setColor(255,0,0);
            moves[1] = squares[i][j+(isWhite?-2:2)];
        }
        moves[2] = null;
        return moves;
    }
}