import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class King extends Piece{
    private boolean hasMoved; //A FLAG USED TO SEE IF CASTLING IS POSSIBLE

    public King(String pos, boolean isWhite,int i,int j){
        hasMoved = false;
        super.pos = pos;
        super.name = "KING";
        super.isWhite = isWhite;
        super.i = i;
        super.j = j;

        try {
            super.icon = ImageIO.read(new File(String.format("C:\\Users\\mattm\\Desktop\\Java\\Chess\\src\\icons\\%s", isWhite ? "whiteKing.png" : "blackKing.png")));    //Loads Icon
        } catch (IOException e) {
            System.err.println("KING ICON NOT FOUND");
        }
    }

    @Override
    protected LinkedList<Square> showMoves(Square[][] squares) {
        LinkedList<Square> moves = new LinkedList<>();

        try{
            if(squares[i][j+1].getState() == null || squares[i][j+1].getState().getColor() != getColor() ){    //MOVE DOWN
                squares[i][j+1].setColor(255,0,0);
                moves.add(squares[i][j+1]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        try{
            if(squares[i][j-1].getState() == null || squares[i][j-1].getState().getColor() != getColor() ){    //MOVE UP
                squares[i][j-1].setColor(255,0,0);
                moves.add(squares[i][j-1]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        try{
            if(squares[i+1][j].getState() == null || squares[i+1][j].getState().getColor() != getColor() ){    //MOVE RIGHT
                squares[i+1][j].setColor(255,0,0);
                moves.add(squares[i+1][j]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        try{
            if(squares[i-1][j].getState() == null || squares[i-1][j].getState().getColor() != getColor() ){    //MOVE LEFT
                squares[i-1][j].setColor(255,0,0);
                moves.add(squares[i-1][j]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        try{
            if(squares[i-1][j-1].getState() == null || squares[i-1][j-1].getState().getColor() != getColor() ){    //LEFT UP
                squares[i-1][j-1].setColor(255,0,0);
                moves.add(squares[i-1][j-1]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        try{
            if(squares[i-1][j+1].getState() == null || squares[i-1][j+1].getState().getColor() != getColor() ){    //LEFT DOWN
                squares[i-1][j+1].setColor(255,0,0);
                moves.add(squares[i-1][j+1]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        try{
            if(squares[i+1][j+1].getState() == null || squares[i+1][j+1].getState().getColor() != getColor() ){    //RIGHT DOWN
                squares[i+1][j+1].setColor(255,0,0);
                moves.add(squares[i+1][j+1]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        try{
            if(squares[i+1][j-1].getState() == null || squares[i+1][j-1].getState().getColor() != getColor() ){    //RIGHT UP
                squares[i+1][j-1].setColor(255,0,0);
                moves.add(squares[i+1][j-1]);
            }
        }catch(ArrayIndexOutOfBoundsException ignored){ }

        //TO DO: CASTLING

        return moves;
    }

    public boolean isChecked(Square[][] squares){
        if(pawnChecked(squares)){return true;}
        if(rookChecked(squares)){return true;}
        if(knightChecked(squares)){return true;}
        if(bishopChecked(squares)){return true;}
        if(queenChecked(squares)){return true;}
        if(kingChecked(squares)){return true;}
        return false;
    }

    private boolean rookChecked(Square[][] squares){
        try{
            for(int a = 1;a<8;a++){
                if(squares[i][j+a].getState() != null && squares[i][j+a].getState().getColor() != isWhite && squares[i][j+a].getState().getName().equals("ROOK")){return true;}
                if(squares[i][j+a].getState() != null && (squares[i][j+a].getState().getColor() == isWhite || !squares[i][j+a].getState().getName().equals("ROOK"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i][j-a].getState() != null && squares[i][j-a].getState().getColor() != isWhite && squares[i][j-a].getState().getName().equals("ROOK")){return true;}
                if(squares[i][j-a].getState() != null && (squares[i][j-a].getState().getColor() == isWhite || !squares[i][j-a].getState().getName().equals("ROOK"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i+a][j].getState() != null && squares[i+a][j].getState().getColor() != isWhite && squares[i+a][j].getState().getName().equals("ROOK")){return true;}
                if(squares[i+a][j].getState() != null && (squares[i+a][j].getState().getColor() == isWhite || !squares[i+a][j].getState().getName().equals("ROOK"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a=1;a<8;a++){
                if(squares[i-a][j].getState() != null && squares[i-a][j].getState().getColor() != isWhite && squares[i-a][j].getState().getName().equals("ROOK")){return true;}
                if(squares[i-a][j].getState() != null && (squares[i-a][j].getState().getColor() == isWhite || !squares[i-a][j].getState().getName().equals("ROOK"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}
        return false;
    }

    private boolean knightChecked(Square[][] squares){
        return false;
    }

    private boolean bishopChecked(Square[][] squares){
        try{
            for(int a = 1;a<8;a++){
                if(squares[i+a][j+a].getState() != null && squares[i+a][j+a].getState().getColor() != isWhite && squares[i+a][j+a].getState().getName().equals("BISHOP")){return true;}
                if(squares[i+a][j+a].getState() != null && (squares[i+a][j+a].getState().getColor() == isWhite || !squares[i+a][j+a].getState().getName().equals("BISHOP"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i+a][j-a].getState() != null && squares[i+a][j-a].getState().getColor() != isWhite && squares[i+a][j-a].getState().getName().equals("BISHOP")){return true;}
                if(squares[i+a][j-a].getState() != null && (squares[i+a][j-a].getState().getColor() == isWhite || !squares[i+a][j-a].getState().getName().equals("BISHOP"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i-a][j+a].getState() != null && squares[i-a][j+a].getState().getColor() != isWhite && squares[i-a][j+a].getState().getName().equals("BISHOP")){return true;}
                if(squares[i-a][j+a].getState() != null && (squares[i-a][j+a].getState().getColor() == isWhite || !squares[i-a][j+a].getState().getName().equals("BISHOP"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a=1;a<8;a++){
                if(squares[i-a][j-a].getState() != null && squares[i-a][j-a].getState().getColor() != isWhite && squares[i-a][j-a].getState().getName().equals("BISHOP")){return true;}
                if(squares[i-a][j-a].getState() != null && (squares[i-a][j-a].getState().getColor() == isWhite || !squares[i-a][j-a].getState().getName().equals("BISHOP"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}
        return false;
    }

    private boolean queenChecked(Square[][] squares){
        try{
            for(int a = 1;a<8;a++){
                if(squares[i+a][j+a].getState() != null && squares[i+a][j+a].getState().getColor() != isWhite && squares[i+a][j+a].getState().getName().equals("QUEEN")){return true;}
                if(squares[i+a][j+a].getState() != null && (squares[i+a][j+a].getState().getColor() == isWhite || !squares[i+a][j+a].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i+a][j-a].getState() != null && squares[i+a][j-a].getState().getColor() != isWhite && squares[i+a][j-a].getState().getName().equals("QUEEN")){return true;}
                if(squares[i+a][j-a].getState() != null && (squares[i+a][j-a].getState().getColor() == isWhite || !squares[i+a][j-a].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i-a][j+a].getState() != null && squares[i-a][j+a].getState().getColor() != isWhite && squares[i-a][j+a].getState().getName().equals("QUEEN")){return true;}
                if(squares[i-a][j+a].getState() != null && (squares[i-a][j+a].getState().getColor() == isWhite || !squares[i-a][j+a].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a=1;a<8;a++){
                if(squares[i-a][j-a].getState() != null && squares[i-a][j-a].getState().getColor() != isWhite && squares[i-a][j-a].getState().getName().equals("QUEEN")){return true;}
                if(squares[i-a][j-a].getState() != null && (squares[i-a][j-a].getState().getColor() == isWhite || !squares[i-a][j-a].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++){
                if(squares[i][j+a].getState() != null && squares[i][j+a].getState().getColor() != isWhite && squares[i][j+a].getState().getName().equals("QUEEN")){return true;}
                if(squares[i][j+a].getState() != null && (squares[i][j+a].getState().getColor() == isWhite || !squares[i][j+a].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i][j-a].getState() != null && squares[i][j-a].getState().getColor() != isWhite && squares[i][j-a].getState().getName().equals("QUEEN")){return true;}
                if(squares[i][j-a].getState() != null && (squares[i][j-a].getState().getColor() == isWhite || !squares[i][j-a].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a = 1;a<8;a++ ){
                if(squares[i+a][j].getState() != null && squares[i+a][j].getState().getColor() != isWhite && squares[i+a][j].getState().getName().equals("QUEEN")){return true;}
                if(squares[i+a][j].getState() != null && (squares[i+a][j].getState().getColor() == isWhite || !squares[i+a][j].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            for(int a=1;a<8;a++){
                if(squares[i-a][j].getState() != null && squares[i-a][j].getState().getColor() != isWhite && squares[i-a][j].getState().getName().equals("QUEEN")){return true;}
                if(squares[i-a][j].getState() != null && (squares[i-a][j].getState().getColor() == isWhite || !squares[i-a][j].getState().getName().equals("QUEEN"))){break;}
            }
        }catch(ArrayIndexOutOfBoundsException ignored){}
        return false;
    }

    private boolean kingChecked(Square[][] squares){
        return false;
    }

    private boolean pawnChecked(Square[][] squares){
        try{
            if(squares[i+1][j+(isWhite?-1:1)].getState() !=null && squares[i+1][j+(isWhite?-1:1)].getState().getColor() != isWhite && squares[i+1][j+(isWhite?-1:1)].getState().getName().equals("PAWN")){return true;}
        }catch(ArrayIndexOutOfBoundsException ignored){}

        try{
            if(squares[i-1][j+(isWhite?-1:1)].getState() !=null && squares[i-1][j+(isWhite?-1:1)].getState().getColor() != isWhite && squares[i-1][j+(isWhite?-1:1)].getState().getName().equals("PAWN")){return true;}
        }catch(ArrayIndexOutOfBoundsException ignored){}

        return false;
    }
}
