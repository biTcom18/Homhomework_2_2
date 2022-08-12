import java.util.Scanner;

public class CheckersActivity {

    public static void main(String[] args) {
        Scanner scanner;
        Game game = new Game();
        String input;
        Entry<Integer, Integer> oldPos = null;
        Entry<Integer, Integer> newPos = null;
        boolean canCapture = false;
        System.out.println(game.getBoard().toString());

        //further documentation needed
        while (!game.getComplete()) {
            //each move
            boolean moveValid = false;
            while (!moveValid) {
                System.out.println("Checker's " + game.getCurTurn() + " move");
                System.out.println("Source : ");

                scanner = new Scanner(System.in);
                input = scanner.nextLine();
                oldPos = game.getIntIntEntry(input);

                if (oldPos == null) {
                    System.out.println("Invalid Space\nPlease try again");
                    continue;
                }
                if (game.isValidMove(false, oldPos)) continue;

                System.out.println("Target : ");
                scanner = new Scanner(System.in);
                input = scanner.nextLine();
                newPos = game.getIntIntEntry(input);
                if (newPos == null) {
                    System.out.println("Invalid Space\nPlease try again");
                    continue;
                }
                if (game.isValidMove(true, newPos)) continue;
                //move piece by 1 space diagonally
                if (game.isDiag1(oldPos, newPos)) {
                    game.getBoard().movePiece(oldPos, newPos, game.getCurTurn());
                    moveValid = true;
                    continue;
                }

                //checking if the move can capture a piece
                Entry<Integer, Integer> capPos = game.setCapPiece(oldPos, newPos);
                if (capPos == null) {
                    System.out.println("invalid move CAP\nplease try again");
                    continue;
                }

                //checking if the move is trying to capture its own piece
                if (game.getBoard().getSpace(capPos) != game.getOPlayer().getPiece()) {
                    System.out.println("The current player is trying to capture their own piece\nPlease try again");
                }

                //move piece to capture
                else {
                    game.getBoard().movePiece(oldPos, newPos, game.getCurTurn());
                    game.getBoard().setSpace(capPos, ' ');
                    game.getOPlayer().capPiece();
                    moveValid = true;
                }
            }

            //checking if a player has lost all their pieces
            if (game.getOPlayer().getNumPieces() == 0) {
                game.setComplete();
                System.out.println("Winner is Player " + game.getOPlayer().getPiece());
            }
            game.setCurTurn(game.getOPlayer().getPiece());
            System.out.println(game.getBoard().toString());

        }

    }

}
