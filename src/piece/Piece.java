package piece;


import gui.Chessboard;
import gui.ChessboardPanel;

import java.util.ArrayList;

public abstract class Piece {
    public int position;
    protected boolean isWhiteColor;

    public abstract ArrayList<Integer> getLegalMoves(Chessboard chessboard);
    public abstract EnumPiece getType();
    public abstract boolean canAttackThisTile(int tilePosition, boolean isWhiteColorAttacking, Chessboard chessboard);
    public int calculatePosition(int X, int Y){
        return X+8*Y;
    }
    public static Piece createNewPiece(int position, boolean isWhiteColor, EnumPiece pieceType){
        return switch (pieceType){
            case BISHOP -> new Bishop(position, isWhiteColor);
            case KING -> new King(position, isWhiteColor);
            case ROOK -> new Rook(position,isWhiteColor);
            case KNIGHT -> new Knight(position,isWhiteColor);
            case PAWN -> new Pawn(position, isWhiteColor);
            case QUEEN -> new Queen(position, isWhiteColor);
        };
    }
    protected static boolean isKingUnderAttack(int fromPosition, int toPosition, boolean isKingWhite, Chessboard chessboard){

        Chessboard newChessboard = Chessboard.deepCopyChessboard(chessboard);
        boolean isKingUnderAttackFlag = false;
        if (isKingWhite) {
            Piece originalPiece = newChessboard.whitePlayer.pieceMap.get(fromPosition);
            Piece newPiece = Piece.createNewPiece(toPosition, true, originalPiece.getType());

            newChessboard.whitePlayer.pieceMap.put(toPosition, newPiece);

            newChessboard.whitePlayer.pieceMap.remove(fromPosition);
            newChessboard.blackPlayer.pieceMap.remove(toPosition);

            if(ChessboardPanel.isKingTileUnderAttack(true, newChessboard)){
                isKingUnderAttackFlag = true;
            }
        } else {
            Piece originalPiece = newChessboard.blackPlayer.pieceMap.get(fromPosition);
            Piece newPiece = Piece.createNewPiece(toPosition, false, originalPiece.getType());

            newChessboard.blackPlayer.pieceMap.put(toPosition, newPiece);

            newChessboard.blackPlayer.pieceMap.remove(fromPosition);
            newChessboard.whitePlayer.pieceMap.remove(toPosition);
            if(ChessboardPanel.isKingTileUnderAttack(false, newChessboard)){
                isKingUnderAttackFlag = true;
            }
        }
        return isKingUnderAttackFlag;
    }
}

