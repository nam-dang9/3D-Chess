package PartA;

/**
 * Knight.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class Knight extends Pieces{
    public Knight(String type, String team, int xCoord, int yCoord, int zCoord) {
        super(type, team, xCoord, yCoord, zCoord);
        // TODO Auto-generated constructor stub
        if (team == "white") {
            setText("\u2658");
        }
        if (team == "black") {
            setText("\u265E");
        }
    }
    
    @Override
    public boolean isValid(Board board, Tiles tile, Pieces piece) {
        // TODO Auto-generated method stub
        int tileX = tile.getxCoord();
        int tileY = tile.getyCoord();
        int pieceX = piece.getxCoord();
        int pieceY = piece.getyCoord();
        if ((tileX == pieceX + 2 && tileY == pieceY + 1) ||
            (tileX == pieceX + 2 && tileY == pieceY - 1) ||
            (tileX == pieceX + 1 && tileY == pieceY + 2) ||
            (tileX == pieceX + 1 && tileY == pieceY - 2) ||
            (tileX == pieceX - 2 && tileY == pieceY - 1) ||
            (tileX == pieceX - 2 && tileY == pieceY + 1) ||
            (tileX == pieceX - 1 && tileY == pieceY - 2) ||
            (tileX == pieceX - 1 && tileY == pieceY + 2)) {
                return true;
        }
        return false;
    }
}
