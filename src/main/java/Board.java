

public class Board {
    static final int LEN = 8;
    static final int WIDTH = 8;
    private Character[][] board;

    public Board () {
        board = new Character[LEN][WIDTH];
        //Initializing board values
        for (int i = LEN-1; i >= 0; i--) { // rows/numbers
            for (int j = 0; j < WIDTH ; j++) { // columns/letters
                if (i == 3 || i == 4) board [i][j] = ' '; //empty rows 4 and 5
                else if (i > 4 && i % 2 == 0 && j % 2 == 0) board[i][j] = 'b';
                else if (i > 4 && i % 2 != 0 && j % 2 != 0) board[i][j] = 'b';
                else if (i < 3 && i % 2 == 0 && j % 2 == 0) board[i][j] = 'w';
                else if (i < 3 && i % 2 != 0 && j % 2 != 0) board[i][j] = 'w';
                else board[i][j] = ' ';
            }
        }
    }

    /**
     * Initializes a deep copy of a Board object
     * @param b
     */
    public Board(Board b) {
        for (int i = LEN-1; i >= 0; i--) {
            for (int j = 0; j < WIDTH; j++) {
                assert false;
                this.board[i][j] = b.getSpace(new Entry<>(i, j));
            }
        }
    }

    /**
     * Helper method to check whether a moved piece needs to be updated to a King piece, then updated
     * @param pos position where piece was just moved to (new position)
     * @param curTurn piece type (w or b) of the current player
     */
    public void updateToKing(Entry<Integer, Integer> pos, char curTurn) {
        //checking that the
        if (this.getSpace(pos) == 'w' && pos.getKey() == 0) {
            setSpace(pos, 'W');
        }
        else if (getSpace(pos) == 'b' && pos.getKey() == 7) {
            setSpace(pos, 'B');
        }
    }

    /**
     * Returns the character representing
     * @param e
     * @return
     */
    public char getSpace(Entry<Integer, Integer> e){
        return this.board[e.getKey()][e.getValue()];
    }

    /**
     * Method that moves a piece by updating the board
     * @param oldPos position of piece that will be moved
     * @param newPos position of space where piece is to be moved to
     */
    public void movePiece(Entry<Integer, Integer> oldPos, Entry<Integer, Integer> newPos, char curTurn) {
        this.board[newPos.getKey()][newPos.getValue()] = this.board[oldPos.getKey()][oldPos.getValue()];
        this.board[oldPos.getKey()][oldPos.getValue()] = ' ';
        this.updateToKing(newPos, curTurn);
    }

    public void setSpace(Entry<Integer, Integer> pos, char c) {
        this.board[pos.getKey()][pos.getValue()] = c;
    }

    public String toString() {
      String temp = "  ---------------------------------\n";
        temp += "  ---------------------------------\n";
        for (int i = LEN-1; i >= 0; i--) {
            temp += i+1;
            for (int j = 0; j < WIDTH; j++) {
                temp += " | " + board[i][j];
            }
            temp += " |\n  ---------------------------------\n";
        }
        temp += "    A   B   C   D   E   F   G   H \n";
        return temp;
    }

}