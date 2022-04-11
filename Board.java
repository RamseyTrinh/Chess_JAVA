import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<Piece>();
    }

    /**
     * addpiece.
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null) {
                pieces.add(piece);
            }
        }
    }

    /**
     * validate.
     */
    public boolean validate(int x, int y) {
        if (x < 1 || x > 8) {
            return false;
        }
        if (y < 1 || y > 8) {
            return false;
        }
        return true;
    }

    /**
     * remove.
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            boolean check1 = pieces.get(i).getCoordinatesX() == x;
            boolean check2 = pieces.get(i).getCoordinatesY() == y;
            if (check1 && check2) {
                pieces.remove(i);
                break;
            }
        }
    }

    /**
     * location.
     */
    public Piece getAt(int x, int y) {
        if (1 <= x && x <= 8 && 1 <= y && y <= 8) {
            for (int i = 0; i < pieces.size(); i++) {
                if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                    return pieces.get(i);
                }

            }
        }
        return null;
    }

    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

}
