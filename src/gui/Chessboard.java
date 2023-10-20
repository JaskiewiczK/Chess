package gui;

import piece.EnumPiece;
import piece.Piece;
import player.BlackPlayer;
import player.WhitePlayer;

public class Chessboard {
    public BlackPlayer blackPlayer;
    public WhitePlayer whitePlayer;

    public Chessboard(boolean setStartingPosition){
        blackPlayer = new BlackPlayer(setStartingPosition);
        whitePlayer = new WhitePlayer(setStartingPosition);
    }

    public static Chessboard deepCopyChessboard(Chessboard originalChessboard) {
        Chessboard newChessboard = new Chessboard(false);
        for (int i = 0; i < 64; i++) {
            if (originalChessboard.blackPlayer.pieceMap.containsKey(i)) {
                Piece originalPiece = originalChessboard.blackPlayer.pieceMap.get(i);
                Piece newPiece = Piece.createNewPiece(i, false, originalPiece.getType());
                newChessboard.blackPlayer.pieceMap.put(i, newPiece);
            }
        }
        for (int i = 0; i < 64; i++) {
            if (originalChessboard.whitePlayer.pieceMap.containsKey(i)) {
                Piece originalPiece = originalChessboard.whitePlayer.pieceMap.get(i);
                Piece newPiece = Piece.createNewPiece(i, true, originalPiece.getType());
                newChessboard.whitePlayer.pieceMap.put(i, newPiece);
            }
        }
        return  newChessboard;
    }

    public static int getKingPosition(boolean isKingColorWhite, Chessboard chessboard){
        if(isKingColorWhite){
            for(int i=0; i<64; i++){
                if(chessboard.whitePlayer.pieceMap.get(i)!=null && chessboard.whitePlayer.pieceMap.get(i).getType()== EnumPiece.KING)
                    return chessboard.whitePlayer.pieceMap.get(i).position;
            }
        }else{
            for(int i=0; i<64; i++){
                if(chessboard.blackPlayer.pieceMap.get(i)!=null && chessboard.blackPlayer.pieceMap.get(i).getType()==EnumPiece.KING)
                    return chessboard.blackPlayer.pieceMap.get(i).position;
            }
        }
        return -1;
    }

    public boolean isOccupiedByColor(boolean isWhite, int position) {
        if (isWhite) {
            return whitePlayer.pieceMap.containsKey(position);
        } else {
            return blackPlayer.pieceMap.containsKey(position);
        }
    }

}


