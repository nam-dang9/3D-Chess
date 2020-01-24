package PartA;

/**
 * King.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class King extends Pieces{
    public King(String type, String team, int xCoord, int yCoord, int zCoord) {
        super(type, team, xCoord, yCoord, zCoord);
        // TODO Auto-generated constructor stub
        if (team == "white") {
            setText("\u2654");
        }
        if (team == "black") {
            setText("\u265A");
        }
    }

    @Override
    public boolean isValid(Board board, Tiles tile, Pieces piece) {
        // TODO Auto-generated method stub
        int tileX = tile.getxCoord();
        int tileY = tile.getyCoord();
        int pieceX = piece.getxCoord();
        int pieceY = piece.getyCoord();
        if ((tileX == pieceX + 1 && tileY == pieceY) ||
            (tileX == pieceX - 1 && tileY == pieceY) ||
            (tileX == pieceX && tileY == pieceY + 1) ||
            (tileX == pieceX && tileY == pieceY - 1) ||
            (tileX == pieceX + 1 && tileY == pieceY + 1) ||
            (tileX == pieceX - 1 && tileY == pieceY - 1) ||
            (tileX == pieceX + 1 && tileY == pieceY - 1) ||
            (tileX == pieceX - 1 && tileY == pieceY + 1)) {
            return true;
        }
        return false;
    }
}
