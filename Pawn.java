package PartA;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Pawn.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class Pawn extends Pieces{
    Board board;
    Boolean start;
    public Pawn(String type, String team, int xCoord, int yCoord,int zCoord) {
        super(type, team, xCoord, yCoord, zCoord);
        // TODO Auto-generated constructor stub
        if (team == "white") {
            setText("\u2659");
        }
        if (team == "black") {
            setText("\u265F");
        }
        start = true;
    }    
    
    @Override
    public boolean isValid(Board board, Tiles tile, Pieces piece) {
        int tileX = tile.getxCoord();
        int tileY = tile.getyCoord();
        int tileZ = tile.getzCoord();
        int pieceX = piece.getxCoord();
        int pieceY = piece.getyCoord();
        int diff = Math.abs(tileZ - piece.getzCoord());
        if (piece.getTeam().equals("black")) {
            if (start && (tileY == pieceY + 1 || tileY == pieceY + 2) 
                    && tileX == pieceX ) {
                if((tileZ == 1 && tileY != pieceY + 1) || (tileZ == 2 && tileY != pieceY + 2)) {
                    return false;
                }
                for (Node node : board.getChildren()) {
                    if(GridPane.getRowIndex(node)  == pieceY + 1 && 
                            GridPane.getColumnIndex(node) == pieceX) {
                            Tiles result = (Tiles)node;
                        if (result.isOccupied()) {
                            return false;
                        }
                    }
                }
                start = false;
                return true;
            }
            if (tileY == pieceY + 1 && tileX == pieceX) {
                if(diff == 2 || diff == 1 && tileY != pieceY + 1) {
                    return false;
                }
                return true;
            }
        }
        if (piece.getTeam().equals("white")) {
            if (start && (tileY == pieceY - 1 || tileY == pieceY - 2) 
                    && tileX == pieceX) {
                if((tileZ == 1 && tileY != pieceY - 1) || (tileZ == 2 && tileY != pieceY - 2)) {
                    return false;
                }
                for (Node node : board.getChildren()) {
                    if(GridPane.getRowIndex(node)  == pieceY - 1 && 
                       GridPane.getColumnIndex(node) == pieceX) {
                        Tiles result = (Tiles)node;
                        if (result.isOccupied()) {
                            return false;
                        }
                    }
                }
                start = false;
                return true;
            }
            if ((tileY == pieceY - 1) && tileX == pieceX) {
                if(diff == 2 || diff == 1 && tileY != pieceY - 1) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
