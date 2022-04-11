import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<Move>();
    }

    /**
     * move.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(this.board, x, y)) {
            Move newMove = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
            if (this.board.getAt(x, y) != null) {
                Piece pieceAtDestination = this.board.getAt(x, y);
                newMove.setKilledPiece(pieceAtDestination);
                this.board.removeAt(x, y);
                this.board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                this.board.addPiece(piece);
            } else {
                this.board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                this.board.addPiece(piece);
            }
            this.moveHistory.add(newMove);
        }

    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return this.moveHistory;
    }

}
