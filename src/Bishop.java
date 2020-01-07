import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Bishop extends Piece {

    public Bishop(String pos, boolean isWhite,int i, int j){
        super.pos = pos;
        super.name = "BISHOP";
        super.isWhite = isWhite;
        super.i = i;
        super.j = j;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteBishop.png" : "blackBishop.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("BISHOP ICON NOT FOUND");
        }
    }

    @Override
    protected LinkedList<Square> showMoves(Square[][] squares) {
        LinkedList<Square> moves = new LinkedList<>();
        try{
            for(int a = 1; a<8; a++){   //DOWN RIGHT
                if(squares[i+a][j+a].getState() == null){
                    squares[i+a][j+a].setColor(255,0,0);
                    moves.add(squares[i+a][j+a]);
                    continue;
                }

                if(squares[i+a][j+a].getState().getColor() != getColor()){
                    squares[i+a][j+a].setColor(255,0,0);
                    moves.add(squares[i+a][j+a]);
                    break;
                }

                if(squares[i+a][j+a].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{    //DOWN LEFT
            for(int a = 1; a<8; a++){
                if(squares[i-a][j+a].getState() == null){
                    squares[i-a][j+a].setColor(255,0,0);
                    moves.add(squares[i-a][j+a]);
                    continue;
                }

                if(squares[i-a][j+a].getState().getColor() != getColor()){
                    squares[i-a][j+a].setColor(255,0,0);
                    moves.add(squares[i-a][j+a]);
                    break;
                }

                if(squares[i-a][j+a].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{    //UP RIGHT
            for(int a = 1; a<8; a++){
                if(squares[i+a][j-a].getState() == null){
                    squares[i+a][j-a].setColor(255,0,0);
                    moves.add(squares[i+a][j-a]);
                    continue;
                }

                if(squares[i+a][j-a].getState().getColor() != getColor()){
                    squares[i+a][j-a].setColor(255,0,0);
                    moves.add(squares[i+a][j-a]);
                    break;
                }

                if(squares[i+a][j-a].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{    //UP LEFT
            for(int a = 1; a<8; a++){
                if(squares[i-a][j-a].getState() == null){
                    squares[i-a][j-a].setColor(255,0,0);
                    moves.add(squares[i-a][j-a]);
                    continue;
                }

                if(squares[i-a][j-a].getState().getColor() != getColor()){
                    squares[i-a][j-a].setColor(255,0,0);
                    moves.add(squares[i-a][j-a]);
                    break;
                }

                if(squares[i-a][j-a].getState().getColor() == getColor()){ break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        return moves;
    }
}
