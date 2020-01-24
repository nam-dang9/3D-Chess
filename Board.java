package PartA;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * 
 * Board.
 *
 * @author Nam Dang (A01011612)
 * @version 1.0
 */
public class Board extends GridPane {
    final int SIZE = 8;
    final int boardWidth = 24;
    /**
     * 
     * Constructs an object of type Board.
     */
    Board board;
    public static Pieces clickedPieces = null;
    static boolean turn = true;
    public int z = 0;
    public Board() {
        board = this;
        createBoard();
        generatePieces();
    }
    public void checkMovement(Tiles tile) {
        try {
            if(clickedPieces != null && !tile.isOccupied() &&
              (clickedPieces.isValid(board, tile, clickedPieces))) {
                if (turn && clickedPieces.getTeam().equals("white")) {
                    System.out.println("Black's turn");
                    clickedPieces.move(board, tile, clickedPieces);
                    turn = false;
                }
                if (!turn && clickedPieces.getTeam().equals("black")) {
                    System.out.println("White's turn");
                    clickedPieces.move(board, tile, clickedPieces);
                    turn = true;
                }
            }
            clickedPieces.setStroke(Color.TRANSPARENT);
            clickedPieces = null;
        } catch (NullPointerException e) {
            
        }
    }
    public void createBoard() {
        int level = 0;
        for (int x = 0; x < boardWidth; x++) {
            if (x == 8) {
                z++;
                level = 8;
            } else if (x == 16) {
                z++;
                level = 16;
            }
            for(int y = 0; y < SIZE; y++) {
                Tiles tile;
                if ((y <= 1 || y >= 6) && z == 0) {
                    tile = new Tiles(x, y, z, true);
                } else {
                    tile = new Tiles(x - level, y, z, false);
                }
                if ((x % 2) == 0) {
                    if ((y % 2) == 0) {
                        tile.setFill(Color.WHITE);
                    } else {
                        tile.setFill(Color.GRAY);
                    }
                } else {
                    if ((y % 2) == 0) {
                        tile.setFill(Color.GRAY);
                    } else {
                        tile.setFill(Color.WHITE);
                    }
                }                
                add(tile, x, y);
                tile.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        // TODO Auto-generated method stub
                        System.out.println(tile.isOccupied());

                        checkMovement(tile);
                    }
                });
            }
        }
    }
    /**
     * Generates all the pieces and adds them to GridPane.
     */
    public void generatePieces() {
        addPawns();
        addRooks();
        addKnights();
        addBishops();
        addQueen();
        addKing();
    }
    public void addPawns() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 1; y < SIZE; y += 5) {
                Pawn pawn;
                if (y == 1) {
                    pawn = new Pawn("pawn", "black", x, y, 0);
                } else {
                    pawn = new Pawn("pawn", "white", x, y, 0);
                }
                add(pawn, x, y);
                pawn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent arg0) {
                        if(clickedPieces == null) {
                            clickedPieces = pawn;
                            clickedPieces.setStroke(Color.GREEN);
                        }               
                    }
                });
            }
        }
       
    }
    public void addRooks() {
        for (int x = 0; x < SIZE; x += 7) {
            for (int y = 0; y < SIZE; y += 7) {
                Rook rook;
                if (y == 0) {
                    rook= new Rook("rook", "black", x, y, 0);
                } else {
                    rook = new Rook("rook", "white", x, y, 0);
                }
                add(rook, x, y);
                rook.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent arg0) {
                        if(clickedPieces == null) {
                            clickedPieces = rook;
                            clickedPieces.setStroke(Color.GREEN);
                        }               
                    }
                });
            }
        }
    }
    
    public void addKnights() {
        for (int x = 1; x < SIZE; x += 5) {
            for (int y = 0; y < SIZE; y += 7) {
                Knight knight;
                if (y == 0) {
                    knight = new Knight("knight", "black", x, y, 0);
                } else {
                    knight = new Knight("knight", "white", x, y, 0);
                }
                add(knight, x, y);
                knight.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent arg0) {
                        if(clickedPieces == null) {
                            clickedPieces = knight;
                            clickedPieces.setStroke(Color.GREEN);
                        }               
                    }
                });
            }
        }
    }
    
    public void addBishops() {
        for (int x = 2; x < SIZE; x += 3) {
            for (int y = 0; y < SIZE; y +=7) {
                Bishop bishop;
                if (y == 0) {
                    bishop = new Bishop("bishop", "black", x, y, 0);
                } else {
                    bishop = new Bishop("bishop", "white", x, y, 0);
                }
                add(bishop, x, y);
                bishop.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent arg0) {
                        if(clickedPieces == null) {
                            clickedPieces = bishop;
                            clickedPieces.setStroke(Color.GREEN);
                        }                     
                    }
                });
            }
        }
    }
    
    public void addQueen() {
        for (int y = 0; y < SIZE; y += 7) {
            Queen queen;
            if (y == 0) {
                queen= new Queen("queen", "black", 3, y, 0);
            } else {
                queen = new Queen("queen", "white", 3, y, 0);
            }
            add(queen, 3, y);
            queen.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    if(clickedPieces == null) {
                        clickedPieces = queen;
                        clickedPieces.setStroke(Color.GREEN);
                    }               
                }
            });
        }
    }
    
    public void addKing() {
        for (int y = 0; y < SIZE; y += 7) {
            King king;
            if (y == 0) {
                king = new King("king", "black", 4, y, 0);
            } else {
                king = new King("king", "white", 4, y, 0);
            }
            add(king, 4, y);
            king.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    if(clickedPieces == null) {
                        clickedPieces = king;
                        clickedPieces.setStroke(Color.GREEN);
                    }               
                }
            });
        }
    }
}
