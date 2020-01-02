public class Player {
    private boolean isWhite;

    public Player(boolean isWhite){
        this.isWhite = isWhite;
    }

    public String toString(){
        return isWhite?"WHITE PLAYER":"BLACK PLAYER";
    }

}
