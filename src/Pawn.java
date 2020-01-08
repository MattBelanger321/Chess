import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Pawn extends Piece{
    private final int INITI; //STARTING COORDINATES
    private final int INITJ;

    public Pawn(String pos, boolean isWhite,int i,int j){
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

        INITI = super.i;
        INITJ = super.j;

    }

    @Override
    protected LinkedList<Square> showMoves(Square[][] squares) {
        LinkedList<Square> moves = new LinkedList<>();
        try{
            if(squares[i][j+(isWhite?-1:1)].getState() == null){    //MOVE FORWARD
                squares[i][j+(isWhite?-1:1)].setColor(255,0,0);
                moves.add(squares[i][j+(isWhite?-1:1)]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }
        try{
            if(super.i == INITI && super.j == INITJ && squares[i][j+(isWhite?-2:2)].getState() == null){    //MOVE TWICE FORWARD
                squares[i][j+(isWhite?-2:2)].setColor(255,0,0);
                moves.add(squares[i][j+(isWhite?-2:2)]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }
        try{
            if(squares[i+1][j+(isWhite?-1:1)].getState() != null && squares[i+1][j+(isWhite?-1:1)].getState().getColor() != isWhite){   //ATTACK RIGHT
                squares[i+1][j+(isWhite?-1:1)].setColor(255,0,0);
                moves.add(squares[i+1][j+(isWhite?-1:1)]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }
         try{
            if(squares[i-1][j+(isWhite?-1:1)].getState() != null && squares[i-1][j+(isWhite?-1:1)].getState().getColor() != isWhite){   //ATTACK LEFT
                squares[i-1][j+(isWhite?-1:1)].setColor(255,0,0);
                moves.add(squares[i-1][j+(isWhite?-1:1)]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        return moves;
    }
}