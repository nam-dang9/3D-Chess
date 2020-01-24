package PartA;

import javafx.scene.shape.Rectangle;

/**
 * Tiles.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class Tiles extends Rectangle {
    private static int LENGTH = 50;
    boolean isOccupied;
    public int xCoord;
    public int yCoord;
    public int zCoord;
    /**
     * Constructs an object of type Tiles.
     * @param isOccupied
     * @param xCoord
     * @param yCoord
     */
    public Tiles(int xCoord, int yCoord, int zCoord, boolean isOccupied) {
        super(LENGTH, LENGTH);
        this.isOccupied = isOccupied;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }
 
    /**
     * Returns the isOccupied for this Tiles.
     * @return the isOccupied
     */
    public boolean isOccupied() {
        return isOccupied;
    }
    /**
     * Sets the isOccupied for this Tiles.
     * @param isOccupied the isOccupied to set
     */
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    /**
     * Returns the xCoord for this Tiles.
     * @return the xCoord
     */
    public int getxCoord() {
        return xCoord;
    }
    /**
     * Sets the xCoord for this Tiles.
     * @param xCoord the xCoord to set
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    /**
     * Returns the yCoord for this Tiles.
     * @return the yCoord
     */
    public int getyCoord() {
        return yCoord;
    }
    /**
     * Sets the yCoord for this Tiles.
     * @param yCoord the yCoord to set
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    /**
     * Returns the zCoord for this Tiles.
     * @return the zCoord
     */
    public int getzCoord() {
        return zCoord;
    }
    /**
     * Sets the zCoord for this Tiles.
     * @param zCoord the xCoord to set
     */
    public void setzCoord(int zCoord) {
        this.zCoord = zCoord;
    }
}
