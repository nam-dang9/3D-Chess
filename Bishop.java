package PartA;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Bishop.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class Bishop extends Pieces {
    public Bishop(String type, String team, int xCoord, int yCoord, int zCoord) {
        super(type, team, xCoord, yCoord, zCoord);
        // TODO Auto-generated constructor stub
        if (team == "white") {
            setText("\u2657");
        }
        if (team == "black") {
            setText("\u265D");
        }
    }

    @Override
    public boolean isValid(Board board, Tiles tile, Pieces piece) {
        // TODO Auto-generated method stub
        int tileX = tile.getxCoord();
        int tileY = tile.getyCoord();
        int pieceX = piece.getxCoord();
        int pieceY = piece.getyCoord();
        for (Node node : board.getChildren()) {
                //down right
                if (tileX > pieceX && tileY > pieceY) {
                    for (int i = tileY, j = tileX; i > pieceY; i--,j--) {
                        if(GridPane.getRowIndex(node) == i && 
                           GridPane.getColumnIndex(node) == j) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
                //down left
                if (tileX < pieceX && tileY > pieceY) {
                    for (int i = tileY, j = tileX; i > pieceY; i--, j++) {
                        if(GridPane.getRowIndex(node) == i && 
                           GridPane.getColumnIndex(node) == j) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
                //up left
                if (tileX < pieceX && tileY < pieceY) {
                    for (int i = tileY, j = tileX; i < pieceY; i++, j++) {
                        if(GridPane.getRowIndex(node) == i && 
                           GridPane.getColumnIndex(node) == j) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
                //up right
                if (tileX > pieceX && tileY < pieceY) {
                    for (int i = tileY, j = tileX; i < pieceY; i++, j--) {
                        if(GridPane.getRowIndex(node) == i && 
                           GridPane.getColumnIndex(node) == j) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
        }
        for (int i = 1; i < 8; i++) {
            if ((tileX == pieceX + i && tileY == pieceY + i) ||
                (tileX == pieceX - i && tileY == pieceY + i) ||
                (tileX == pieceX + i && tileY == pieceY - i) ||
                (tileX == pieceX - i && tileY == pieceY - i)) {
                return true;
            }
        }
        return false;
    }
}
