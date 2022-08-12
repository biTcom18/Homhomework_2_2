
public class Player {
    private final char piece; //w or b
    private int numPieces; //number of checkers player owns

    public Player (char p) {
        this.piece = p;
        this.numPieces = 12;
    }

    public Player (char c, int num) {
        this.piece = c;
        this.numPieces = num;
    }


    public char getPiece() {
        return this.piece;
    }
    public int getNumPieces() {
        return this.numPieces;
    }

    public void capPiece() {
        this.numPieces--;
    }
}
