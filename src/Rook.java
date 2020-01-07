import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Rook extends Piece{
    private boolean hasMoved;   //A FLAG USED TO SEE IF CASTLING IS POSSIBLE

    public Rook(String pos, boolean isWhite,int i,int j){
        hasMoved = false;
        super.pos = pos;
        super.name = "ROOK";
        super.isWhite = isWhite;
        super.i = i;
        super.j = j;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteRook.png" : "blackRook.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("ROOK ICON NOT FOUND");
        }
    }

    @Override
    protected LinkedList<Square> showMoves(Square[][] squares) {
        LinkedList<Square> moves = new LinkedList<>();
        try{
            for(int a = 1; a<8; a++){   //DOWN
                if(squares[i][j+a].getState() == null){
                    squares[i][j+a].setColor(255,0,0);
                    moves.add(squares[i][j+a]);
                    continue;
                }

                if(squares[i][j+a].getState().getColor() != getColor()){
                    squares[i][j+a].setColor(255,0,0);
                    moves.add(squares[i][j+a]);
                    break;
                }

                if(squares[i][j+a].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{    //LEFT
            for(int a = 1; a<8; a++){
                if(squares[i-a][j].getState() == null){
                    squares[i-a][j].setColor(255,0,0);
                    moves.add(squares[i-a][j]);
                    continue;
                }

                if(squares[i-a][j].getState().getColor() != getColor()){
                    squares[i-a][j].setColor(255,0,0);
                    moves.add(squares[i-a][j]);
                    break;
                }

                if(squares[i-a][j].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{    //RIGHT
            for(int a = 1; a<8; a++){
                if(squares[i+a][j].getState() == null){
                    squares[i+a][j].setColor(255,0,0);
                    moves.add(squares[i+a][j]);
                    continue;
                }

                if(squares[i+a][j].getState().getColor() != getColor()){
                    squares[i+a][j].setColor(255,0,0);
                    moves.add(squares[i+a][j]);
                    break;
                }

                if(squares[i+a][j].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{    //UP
            for(int a = 1; a<8; a++){
                if(squares[i][j-a].getState() == null){
                    squares[i][j-a].setColor(255,0,0);
                    moves.add(squares[i][j-a]);
                    continue;
                }

                if(squares[i][j-a].getState().getColor() != getColor()){
                    squares[i][j-a].setColor(255,0,0);
                    moves.add(squares[i][j-a]);
                    break;
                }

                if(squares[i][j-a].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        return moves;
    }
}
