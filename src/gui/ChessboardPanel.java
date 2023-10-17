package gui;

import piece.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChessboardPanel extends JPanel implements MouseListener {

    ArrayList<Integer> legalMoves;

    public static int moveNumber = 0;
    boolean firstClick = true;
    boolean whiteToMove = true;
    int fromX;
    int fromY;
    int toX;
    int toY;
    private double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    private int panelSize = (int) ((8.0 / 12.0 + 2.0 / 14.0) * height);
    private final int TILESIZE = (int) height / 12;
    private final int OFFSET = (int) height / 14;

    public static Chessboard chessboard;
    public Map<EnumPiece, BufferedImage> whiteImageMap = new HashMap<EnumPiece, BufferedImage>();
    public Map<EnumPiece, BufferedImage> blackImageMap = new HashMap<EnumPiece, BufferedImage>();

    private BufferedImage legalMoveCircle;
    private BufferedImage blackPawnImage;
    private BufferedImage blackRookImage;
    private BufferedImage blackKnightImage;
    private BufferedImage blackBishopImage;
    private BufferedImage blackQueenImage;
    private BufferedImage blackKingImage;
    private BufferedImage whitePawnImage;
    private BufferedImage whiteRookImage;
    private BufferedImage whiteKnightImage;
    private BufferedImage whiteBishopImage;
    private BufferedImage whiteQueenImage;
    private BufferedImage whiteKingImage;

    public ChessboardPanel(Chessboard chessboard) {

        this.chessboard = chessboard;
        addMouseListener(this);

        this.setBackground(new Color(153, 255, 187));
        this.setPreferredSize(new Dimension(panelSize, panelSize));
        try {
            legalMoveCircle = ImageIO.read(getClass().getResource("/images/legalMoveCircle.png"));
            blackPawnImage = ImageIO.read(getClass().getResource("/images/blackP.png"));
            blackRookImage = ImageIO.read(getClass().getResource("/images/blackR.png"));
            blackKnightImage = ImageIO.read(getClass().getResource("/images/blackN.png"));
            blackBishopImage = ImageIO.read(getClass().getResource("/images/blackB.png"));
            blackQueenImage = ImageIO.read(getClass().getResource("/images/blackQ.png"));
            blackKingImage = ImageIO.read(getClass().getResource("/images/blackK.png"));
            whitePawnImage = ImageIO.read(getClass().getResource("/images/whiteP.png"));
            whiteRookImage = ImageIO.read(getClass().getResource("/images/whiteR.png"));
            whiteKnightImage = ImageIO.read(getClass().getResource("/images/whiteN.png"));
            whiteBishopImage = ImageIO.read(getClass().getResource("/images/whiteB.png"));
            whiteQueenImage = ImageIO.read(getClass().getResource("/images/whiteQ.png"));
            whiteKingImage = ImageIO.read(getClass().getResource("/images/whiteK.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        blackImageMap.put(EnumPiece.PAWN, blackPawnImage);
        blackImageMap.put(EnumPiece.ROOK, blackRookImage);
        blackImageMap.put(EnumPiece.KNIGHT, blackKnightImage);
        blackImageMap.put(EnumPiece.BISHOP, blackBishopImage);
        blackImageMap.put(EnumPiece.QUEEN, blackQueenImage);
        blackImageMap.put(EnumPiece.KING, blackKingImage);

        whiteImageMap.put(EnumPiece.PAWN, whitePawnImage);
        whiteImageMap.put(EnumPiece.ROOK, whiteRookImage);
        whiteImageMap.put(EnumPiece.KNIGHT, whiteKnightImage);
        whiteImageMap.put(EnumPiece.BISHOP, whiteBishopImage);
        whiteImageMap.put(EnumPiece.QUEEN, whiteQueenImage);
        whiteImageMap.put(EnumPiece.KING, whiteKingImage);
    }

    private void paintWhitePieces(Graphics2D g2D, Piece piece) {
        if (piece != null) {
            g2D.drawImage(whiteImageMap.get(piece.getType()), OFFSET + (piece.position % 8) * TILESIZE, OFFSET + (piece.position / 8) * TILESIZE, TILESIZE, TILESIZE, null);
        }
    }

    private void paintBlackPieces(Graphics2D g2D, Piece piece) {
        if (piece != null) {
            g2D.drawImage(blackImageMap.get(piece.getType()), OFFSET + (piece.position % 8) * TILESIZE, OFFSET + (piece.position / 8) * TILESIZE, TILESIZE, TILESIZE, null);
        }
    }

    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ((x + y) % 2 == 0) {
                    g2D.setColor(Color.lightGray);
                } else {
                    g2D.setColor(Color.darkGray);
                }
                g.fillRect(OFFSET + x * TILESIZE, OFFSET + y * TILESIZE, TILESIZE, TILESIZE);
            }
        }
        chessboard.whitePlayer.pieceMap.forEach((key, value) -> paintWhitePieces(g2D, value));
        chessboard.blackPlayer.pieceMap.forEach((key, value) -> paintBlackPieces(g2D, value));
        if (!firstClick) {
            drawLegalMoves(g2D, whiteToMove, fromX, fromY);
        }

    }

    private boolean ClickedOnChessboard(int X, int Y) {
        if ((X < 0) || (X > 8 * TILESIZE) || (Y < 0) || (Y > 8 * TILESIZE)) {
            return false;
        }
        return true;
    }

    private boolean ClickedOnChessboardAndIsPlayerTurn(boolean whiteToMove, int X, int Y) {
        int position = X / TILESIZE + 8 * (Y / TILESIZE);
        if ((X < 0) || (X > 8 * TILESIZE) || (Y < 0) || (Y > 8 * TILESIZE)) {
            return false;
        } else if (whiteToMove) {
            if (chessboard.whitePlayer.pieceMap.containsKey(position)) {
                return true;
            }
            return false;
        } else {
            if (chessboard.blackPlayer.pieceMap.containsKey(position)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private void drawLegalMoves(Graphics2D g2D, boolean whiteToMove, int fromX, int fromY) {
        int key = fromX + 8 * fromY;
        if (chessboard.whitePlayer.pieceMap.containsKey(key)) {
            legalMoves = chessboard.whitePlayer.pieceMap.get(key).getLegalMoves(chessboard);
        } else if (chessboard.blackPlayer.pieceMap.containsKey(key)) {
            legalMoves = chessboard.blackPlayer.pieceMap.get(key).getLegalMoves(chessboard);
        }
        if (legalMoves != null) {
            legalMoves.forEach(value -> g2D.drawImage(legalMoveCircle, OFFSET + (value % 8) * TILESIZE, OFFSET + (value / 8) * TILESIZE, TILESIZE, TILESIZE, null));
        }
    }

    private boolean isMoveLegal(int toX, int toY) {
        int position = toX + 8 * toY;
        if (legalMoves != null && legalMoves.contains(position)) {
            return true;
        }
        return false;
    }

    private void makeMove(int fromX, int fromY, int toX, int toY) {
        int fromPosition = fromX + 8 * fromY;
        int toPosition = toX + 8 * toY;
        if (whiteToMove) {
            Piece originalPiece = chessboard.whitePlayer.pieceMap.get(fromPosition);
            Piece newPiece = Piece.createNewPiece(toPosition, true, originalPiece.getType());
            if (newPiece.getType() == EnumPiece.PAWN) {
                if (fromY - toY == 2) {
                    Pawn temp = (Pawn) newPiece;
                    temp.longMoveNumber = ChessboardPanel.moveNumber;
                }
                if (fromX != toX && fromY == 3 && isOccupiedByColor(false, (toX + 8 * fromY))) {
                    chessboard.blackPlayer.pieceMap.remove(toX + 8 * fromY);
                }
            }


            if (newPiece.getType() == EnumPiece.ROOK) {
                Rook temp = (Rook) newPiece;
                temp.hasAlreadyMoved = true;
            }


            if (newPiece.getType() == EnumPiece.KING) {
                King temp = (King) newPiece;
                temp.hasAlreadyMoved = true;
            }

            if (newPiece.getType() == EnumPiece.KING && Math.abs(fromX - toX) == 2) {
                if (toX == 6) {
                    Piece tempOriginalPiece = chessboard.whitePlayer.pieceMap.get(63);
                    Piece tempNewPiece = Piece.createNewPiece(61, true, tempOriginalPiece.getType());
                    chessboard.whitePlayer.pieceMap.put(61, tempNewPiece);
                    chessboard.whitePlayer.pieceMap.remove(63);
                } else {
                    Piece tempOriginalPiece = chessboard.whitePlayer.pieceMap.get(56);
                    Piece tempNewPiece = Piece.createNewPiece(59, true, tempOriginalPiece.getType());
                    chessboard.whitePlayer.pieceMap.put(59, tempNewPiece);
                    chessboard.whitePlayer.pieceMap.remove(56);
                }
            }

            chessboard.whitePlayer.pieceMap.put(toPosition, newPiece);

            chessboard.whitePlayer.pieceMap.remove(fromPosition);

            chessboard.blackPlayer.pieceMap.remove(toPosition);

        } else {


            Piece originalPiece = chessboard.blackPlayer.pieceMap.get(fromPosition);
            Piece newPiece = Piece.createNewPiece(toPosition, false, originalPiece.getType());

            if (newPiece.getType() == EnumPiece.PAWN) {
                if (toY - fromY == 2) {
                    Pawn temp = (Pawn) newPiece;
                    temp.longMoveNumber = ChessboardPanel.moveNumber;
                }
                if (fromX != toX && fromY == 4 && isOccupiedByColor(true, (toX + 8 * fromY))) {
                    chessboard.whitePlayer.pieceMap.remove(toX + 8 * fromY);
                }

            }

            if (newPiece.getType() == EnumPiece.ROOK) {
                Rook temp = (Rook) newPiece;
                temp.hasAlreadyMoved = true;
            }


            if (newPiece.getType() == EnumPiece.KING) {
                King temp = (King) newPiece;
                temp.hasAlreadyMoved = true;
            }

            if (newPiece.getType() == EnumPiece.KING && Math.abs(fromX - toX) == 2) {
                if (toX == 6) {
                    Piece tempOriginalPiece = chessboard.blackPlayer.pieceMap.get(7);
                    Piece tempNewPiece = Piece.createNewPiece(5, false, tempOriginalPiece.getType());
                    chessboard.blackPlayer.pieceMap.put(5, tempNewPiece);
                    chessboard.blackPlayer.pieceMap.remove(7);
                } else {
                    Piece tempOriginalPiece = chessboard.blackPlayer.pieceMap.get(0);
                    Piece tempNewPiece = Piece.createNewPiece(3, false, tempOriginalPiece.getType());
                    chessboard.blackPlayer.pieceMap.put(3, tempNewPiece);
                    chessboard.blackPlayer.pieceMap.remove(0);
                }
            }

            chessboard.blackPlayer.pieceMap.put(toPosition, newPiece);
            chessboard.blackPlayer.pieceMap.remove(fromPosition);

            chessboard.whitePlayer.pieceMap.remove(toPosition);

        }
        repaint();
        if(!isThereAnyLegalMove(chessboard, whiteToMove)){
            checkForWinOrDraw(chessboard, whiteToMove);
        }

        ++ChessboardPanel.moveNumber;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (firstClick) {
            fromX = (e.getX() - OFFSET);
            fromY = (e.getY() - OFFSET);
            if (ClickedOnChessboardAndIsPlayerTurn(whiteToMove, fromX, fromY)) {
                firstClick = false;
                fromX /= TILESIZE;
                fromY /= TILESIZE;

            } else {
                firstClick = true;
            }

        } else {
            toX = (e.getX() - OFFSET);
            toY = (e.getY() - OFFSET);
            if (ClickedOnChessboard(toX, toY)) {
                toX /= TILESIZE;
                toY /= TILESIZE;

                if (isMoveLegal(toX, toY)) {
                    firstClick = true;
                    legalMoves = null;
                    makeMove(fromX, fromY, toX, toY);
                    if (whiteToMove) {
                        whiteToMove = false;
                    } else {
                        whiteToMove = true;
                    }

                } else {
                    firstClick = true;
                }

            } else {
                firstClick = false;

            }

        }
        repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static boolean isOccupiedByColor(boolean isWhite, int position) {
        if (isWhite) {
            if (chessboard.whitePlayer.pieceMap.containsKey(position)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (chessboard.blackPlayer.pieceMap.containsKey(position)) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static boolean isKingTileUnderAttack(boolean whiteColor, Chessboard newChessboard) {
        if (whiteColor) {
            int kingPosition = Chessboard.getKingPosition(true, newChessboard);
            for (int i = 0; i < 64; i++) {
                if (newChessboard.blackPlayer.pieceMap.containsKey(i) && newChessboard.blackPlayer.pieceMap.get(i) != null) {
                    if (newChessboard.blackPlayer.pieceMap.get(i).canAttackThisTile(kingPosition, false, newChessboard)) {
                        return true;
                    }
                }
            }

        } else {
            int kingPosition = Chessboard.getKingPosition(false, newChessboard);
            for (int i = 0; i < 64; i++) {
                if (chessboard.whitePlayer.pieceMap.containsKey(i) && chessboard.whitePlayer.pieceMap.get(i) != null) {
                    if (chessboard.whitePlayer.pieceMap.get(i).canAttackThisTile(kingPosition, true, newChessboard)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void displayWinMessage(boolean isWhiteWinner) {
        if (isWhiteWinner) {
            JOptionPane.showMessageDialog(this, "Congratulations! White player won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Congratulations! Black player won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void displayDrawMessage() {
        JOptionPane.showMessageDialog(this, "The match has ended in a draw.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void checkForWinOrDraw(Chessboard chessboard, boolean whiteToMove) {
            if(whiteToMove){
                if(isKingTileUnderAttack(false,chessboard))
                    displayWinMessage(true);
                else {
                    displayDrawMessage();
                }
            }else{
                if(isKingTileUnderAttack(true,chessboard))
                    displayWinMessage(false);
                else {
                    displayDrawMessage();
                }
            }

        }


    public boolean isThereAnyLegalMove(Chessboard chessboard, boolean whiteToMove){
        if (whiteToMove) {

            for (int i = 0; i < 64; i++) {
                if (chessboard.blackPlayer.pieceMap.containsKey(i) && chessboard.blackPlayer.pieceMap.get(i) != null) {
                    legalMoves = chessboard.blackPlayer.pieceMap.get(i).getLegalMoves(chessboard);
                    if (!legalMoves.isEmpty()) {
                        return true;
                    }
                }
            }


        } else {
            for (int i = 0; i < 64; i++) {
                if (chessboard.whitePlayer.pieceMap.containsKey(i) && chessboard.whitePlayer.pieceMap.get(i) != null) {
                    legalMoves = chessboard.whitePlayer.pieceMap.get(i).getLegalMoves(chessboard);
                    if (!legalMoves.isEmpty()) {
                        return true;
                    }
                }
            }

        }
        return false;
    }



}






