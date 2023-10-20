package player;

import piece.*;

public class WhitePlayer extends Player{
    public  WhitePlayer(boolean setStartingPosition){
        if (setStartingPosition){
            pieceMap.put(56, new Rook(56,true));
            pieceMap.put(63, new Rook(63,true));
            pieceMap.put(57, new Knight(57,true));
            pieceMap.put(62, new Knight(62, true));
            pieceMap.put(58, new Bishop(58,true));
            pieceMap.put(61, new Bishop(61,true));
            pieceMap.put(59, new Queen(59,true));
            pieceMap.put(60, new King(60,true));
            for(int i=48; i<56; i++){
                pieceMap.put(i, new Pawn(i, true));
            }
        }
    }
}
