package PartA;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Rook.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class Rook extends Pieces {
    public Rook(String type, String team, int xCoord, int yCoord, int zCoord) {
        super(type, team, xCoord, yCoord, zCoord);
        // TODO Auto-generated constructor stub
        if (team == "white") {
            setText("\u2656");
        }
        if (team == "black") {
            setText("\u265C");
        }
    }
    // in case moving everything to pieces breaks
    /**@Override
    public void move(Board board, Tiles tile, Pieces piece) {
        // TODO Auto-generated method stub
        board.getChildren().remove(piece);
        board.add(piece, tile.getxCoord(), tile.getyCoord());
        for (Node node : board.getChildren()) {
            if(GridPane.getRowIndex(node) == piece.getyCoord() && 
               GridPane.getColumnIndex(node) == piece.getxCoord()) {
                Tiles result = (Tiles)node;
                result.setOccupied(false);
                break;
            }
        }
        piece.setxCoord(tile.getxCoord());
        piece.setyCoord(tile.getyCoord());
        tile.setOccupied(true);
    }*/

    public boolean isValid(Board board, Tiles tile, Pieces piece) {
        // TODO Auto-generated method stub
        int tileX = tile.getxCoord();
        int tileY = tile.getyCoord();
        int pieceX = piece.getxCoord();
        int pieceY = piece.getyCoord();
        int loopX = Math.abs(tileX - pieceX);
        int loopY = Math.abs(tileY - pieceY);
        for (Node node : board.getChildren()) {
            //Horizontal movement
            if (tileY == pieceY) {
                //Right
                if (tileX > pieceX) {
                    for (int i = 1; i <= loopX; i++) {
                        if(GridPane.getRowIndex(node) == tileY && 
                           GridPane.getColumnIndex(node) == pieceX + i) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
                //Left
                if (tileX < pieceX) {
                    for (int i = 1; i <= loopX; i++) {
                        if((GridPane.getRowIndex(node) == tileY && 
                            GridPane.getColumnIndex(node) == pieceX - i)) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
            }
            //Vertical movement
            if (tileX == pieceX) {
                // Down
                if (tileY > pieceY) {
                    for (int i = 1; i <= loopY; i++) {
                        if((GridPane.getRowIndex(node)  == pieceY + i && 
                            GridPane.getColumnIndex(node) == tileX)) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
                //Up
                if (tileY < pieceY) {
                    for (int i = 1; i <= loopY; i++) {
                        if((GridPane.getRowIndex(node)  == pieceY - i && 
                            GridPane.getColumnIndex(node) == tileX)) {
                            Tiles result = (Tiles)node;
                            if (result.isOccupied()) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (tileX == pieceX || tileY == pieceY) {
            return true;
        }
        return false;
    }
}
