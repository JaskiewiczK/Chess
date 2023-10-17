package piece;


import gui.Chessboard;
import gui.ChessboardPanel;

import java.util.ArrayList;

public abstract class Piece {
    public abstract ArrayList<Integer> getLegalMoves(Chessboard chessboard);
    public abstract EnumPiece getType();
    public int position;
    public boolean whiteColor;

    public int calculatePosition(int X, int Y){
        return X+8*Y;
    }

    public abstract boolean canAttackThisTile(int position, boolean whiteColor, Chessboard chessboard);

    public static Piece createNewPiece(int position, boolean whiteColor, EnumPiece pieceType){
        if(pieceType==EnumPiece.BISHOP){
            return new Bishop(position, whiteColor);
        }
        if(pieceType==EnumPiece.KING)
            return new King(position, whiteColor);
        if(pieceType==EnumPiece.KNIGHT)
            return new Knight(position,whiteColor);
        if(pieceType==EnumPiece.PAWN)
            return new Pawn(position, whiteColor);
        if(pieceType==EnumPiece.QUEEN)
            return new Queen(position, whiteColor);
        if(pieceType==EnumPiece.ROOK)
            return new Rook(position,whiteColor);
        return null;
    }
    protected static boolean isKingUnderAttack(int fromPosition, int toPosition, boolean whiteColor, Chessboard chessboard){

        Chessboard newChessboard = Chessboard.deepCopyChessboard(chessboard);
        boolean isKingUnderAttackFlag = false;
        if (whiteColor) {


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

