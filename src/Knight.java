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
        LinkedList<Square> moves = new LinkedList<>();
        try{
            if(squares[i+1][j+2].getState() == null || squares[i+1][j+2].getState().getColor() != getColor()  ){
                moves.add(squares[i+1][j+2]);
                squares[i+1][j+2].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i-1][j+2].getState() == null || squares[i-1][j+2].getState().getColor() != getColor()  ){
                moves.add(squares[i-1][j+2]);
                squares[i-1][j+2].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i+1][j-2].getState() == null || squares[i+1][j-2].getState().getColor() != getColor()  ){
                moves.add(squares[i+1][j-2]);
                squares[i+1][j-2].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i-1][j-2].getState() == null || squares[i-1][j-2].getState().getColor() != getColor() ){
                moves.add(squares[i-1][j-2]);
                squares[i-1][j-2].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i+2][j+1].getState() == null || squares[i+2][j+1].getState().getColor() != getColor()  ){
                moves.add(squares[i+2][j+1]);
                squares[i+2][j+1].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i-2][j+1].getState() == null || squares[i-2][j+1].getState().getColor() != getColor()  ){
                moves.add(squares[i-2][j+1]);
                squares[i-2][j+1].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i+2][j-1].getState() == null || squares[i+2][j-1].getState().getColor() != getColor()  ){
                moves.add(squares[i+2][j-1]);
                squares[i+2][j-1].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i-2][j-1].getState() == null || squares[i-2][j-1].getState().getColor() != getColor() ){
                moves.add(squares[i-2][j-1]);
                squares[i-2][j-1].setColor(255,0,0);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        return moves;
    }
}
