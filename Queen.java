package PartA;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Queen.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class Queen extends Pieces {
    public Queen(String type, String team, int xCoord, int yCoord, int zCoord) {
        super(type, team, xCoord, yCoord, zCoord);
        // TODO Auto-generated constructor stub
        if (team == "white") {
            setText("\u2655");
        }
        if (team == "black") {
            setText("\u265B");
        }
    }
    
    @Override
    public boolean isValid(Board board, Tiles tile, Pieces piece) {
        // TODO Auto-generated method stub
        int tileX = tile.getxCoord();
        int tileY = tile.getyCoord();
        int tileZ = tile.getzCoord();
        int pieceX = piece.getxCoord();
        int pieceY = piece.getyCoord();
        int pieceZ = piece.getzCoord();
        int loopX = Math.abs(tileX - pieceX);
        int loopY = Math.abs(tileY - pieceY);
        int diff = Math.abs(tileZ - pieceZ);
        int level = 0;
        if (tileZ == pieceZ) {
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
                //Up right
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
        }
        switch (diff) {
            case 1: level = 1;
                     break;
            case 2: level = 2;
                    break;
        }
            if ((tileX == pieceX + level && tileY == pieceY + level) ||
                (tileX == pieceX - level && tileY == pieceY + level) ||
                (tileX == pieceX + level && tileY == pieceY - level) ||
                (tileX == pieceX - level && tileY == pieceY - level) ||
                (tileX == pieceX && tileY == pieceY + level) ||
                (tileX == pieceX && tileY == pieceY - level) ||
                (tileX == pieceX + level && tileY == pieceY) ||
                (tileX == pieceX - level && tileY == pieceY)) {
                return true;
            }

        for (int i = 1; i < 8; i++) {
            if (tileZ == pieceZ && ((tileX == pieceX + i && tileY == pieceY + i) ||
                (tileX == pieceX - i && tileY == pieceY + i) ||
                (tileX == pieceX + i && tileY == pieceY - i) ||
                (tileX == pieceX - i && tileY == pieceY - i) ||
                (tileX == pieceX || tileY == pieceY))) {
                return true;
            }
        }
        return false;
    }
}
