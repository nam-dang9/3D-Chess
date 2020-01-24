package PartA;

import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import PartA.Board;
import javafx.scene.text.Text;

/**
 * Pieces.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public abstract class Pieces extends Text{
    protected String type;
    protected String team;
    protected int xCoord;
    protected int yCoord;
    protected int zCoord;
    /**
     * Constructs an object of type Pieces.
     * @param type
     */
    public Pieces(String type, String team, int xCoord, int yCoord, int zCoord) {
        super();
        this.type = type;
        this.team = team;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
        GridPane.setHalignment(this, HPos.CENTER);
        setFont(new Font(37));
    }

    /**
     * Returns the type for this Pieces.
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type for this Pieces.
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the xCoord for this Pieces.
     * @return the xCoord
     */
    public int getxCoord() {
        return xCoord;
    }

    /**
     * Sets the xCoord for this Pieces.
     * @param xCoord the xCoord to set
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * Returns the yCoord for this Pieces.
     * @return the yCoord
     */
    public int getyCoord() {
        return yCoord;
    }

    /**
     * Sets the yCoord for this Pieces.
     * @param yCoord the yCoord to set
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    /**
     * Returns the zCoord for this Pieces.
     * @return the zCoord
     */
    public int getzCoord() {
        return zCoord;
    }

    /**
     * Sets the zCoord for this Pieces.
     * @param zCoord the xCoord to set
     */
    public void setzCoord(int zCoord) {
        this.zCoord = zCoord;
    }


    /**
     * Returns the team for this Pieces.
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    public void move(Board board, Tiles tile, Pieces piece) {
        // TODO Auto-generated method stub
        board.getChildren().remove(piece);
        board.add(piece, GridPane.getColumnIndex(tile), tile.getyCoord());
        int level = 0;
        for (Node node : board.getChildren()) {
            switch (piece.getzCoord()) {
            case 0: level = 0;
                    break;
            case 1: level = 8;
                    break;
            case 2: level = 16;
                    break;
            }
            if (GridPane.getRowIndex(node) == piece.getyCoord() && 
                GridPane.getColumnIndex(node) == piece.getxCoord() + level) {
                Tiles result = (Tiles)node;
                result.setOccupied(false);
                break;
            }
        }
        piece.setxCoord(tile.getxCoord());
        piece.setyCoord(tile.getyCoord());
        piece.setzCoord(tile.getzCoord());
        tile.setOccupied(true);
    }
    public abstract boolean isValid(Board board, Tiles tile, Pieces piece);
}
