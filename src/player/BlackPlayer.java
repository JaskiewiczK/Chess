package player;

import piece.*;

public class BlackPlayer extends Player{



    public  BlackPlayer(BlackPlayer deepCopyBlackPlayer){

    }
    public BlackPlayer(){
        pieceMap.put(0, new Rook(0,false));
        pieceMap.put(7, new Rook(7,false));
        pieceMap.put(1, new Knight(1, false));
        pieceMap.put(6, new Knight(6, false));
        pieceMap.put(2, new Bishop(2,false ));
        pieceMap.put(5, new Bishop(5,false));
        pieceMap.put(3, new Queen(3, false));
        pieceMap.put(4, new King(4,false));
        for(int i=8; i<16; i++){
            pieceMap.put(i, new Pawn(i, false));
        }

    }
    public BlackPlayer(int flag){

    }

}


