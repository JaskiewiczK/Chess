package gui;

import piece.EnumPiece;
import piece.Piece;
import player.BlackPlayer;
import player.WhitePlayer;

public class Chessboard {
    public BlackPlayer blackPlayer;
    public WhitePlayer whitePlayer;

    public Chessboard(){
        blackPlayer = new BlackPlayer();
        whitePlayer = new WhitePlayer();
    }



    public static Chessboard deepCopyChessboard(Chessboard originalChessboard) {
        Chessboard newChessboard = new Chessboard();
        for (int i = 0; i < 64; i++) {
            if (originalChessboard.blackPlayer.pieceMap.containsKey(i) && originalChessboard.blackPlayer.pieceMap.get(i) != null) {
                newChessboard.blackPlayer.pieceMap.put(i, Piece.createNewPiece(i, false, originalChessboard.blackPlayer.pieceMap.get(i).getType()));
            }
        }
        for (int i = 0; i < 64; i++) {
            if (originalChessboard.whitePlayer.pieceMap.containsKey(i) && originalChessboard.whitePlayer.pieceMap.get(i) != null) {
                newChessboard.whitePlayer.pieceMap.put(i, Piece.createNewPiece(i, true, originalChessboard.whitePlayer.pieceMap.get(i).getType()));
            }
        }

        return  newChessboard;
    }


    public static int getKingPosition(boolean whiteColor, Chessboard chessboard){
        if(whiteColor){
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
            if (whitePlayer.pieceMap.containsKey(position)) {
                return true;
            } else {
                return false;
            }
        } else {
            if(blackPlayer.pieceMap.containsKey(position)){
                return true;
            }else{
                return false;
            }
        }
    }



}


