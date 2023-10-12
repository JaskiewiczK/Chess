package piece;

import gui.Chessboard;
import gui.ChessboardPanel;
import player.BlackPlayer;
import player.WhitePlayer;

import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(int position, boolean whiteColor){
        this.position = position;
        this.whiteColor = whiteColor;
    }

    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<Integer>();
        int X = position%8;
        int Y = position/8;
        if(this.whiteColor){
            if(X-2>-1 && Y-1>-1 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X-2,Y-1))))
                legalMoves.add(calculatePosition(X-2,Y-1));
            if(X-2>-1 && Y+1<8 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X-2,Y+1))))
                legalMoves.add(calculatePosition(X-2,Y+1));
            if(X+2<8 && Y-1>-1 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X+2,Y-1))))
                legalMoves.add(calculatePosition(X+2,Y-1));
            if(X+2<8 && Y+1<8 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X+2,Y+1))))
                legalMoves.add(calculatePosition(X+2,Y+1));
            if(X-1>-1 && Y-2>-1 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X-1,Y-2))))
                legalMoves.add(calculatePosition(X-1,Y-2));
            if(X-1>-1 && Y+2<8 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X-1,Y+2))))
                legalMoves.add(calculatePosition(X-1,Y+2));
            if(X+1<8 && Y-2>=-1 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X+1,Y-2))))
                legalMoves.add(calculatePosition(X+1,Y-2));
            if(X+1<8 && Y+2<8 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(X+1,Y+2))))
                legalMoves.add(calculatePosition(X+1,Y+2));
        }else{
            if(X-2>-1 && Y-1>-1 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X-2,Y-1))))
                legalMoves.add(calculatePosition(X-2,Y-1));
            if(X-2>-1 && Y+1<8 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X-2,Y+1))))
                legalMoves.add(calculatePosition(X-2,Y+1));
            if(X+2<8 && Y-1>-1 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X+2,Y-1))))
                legalMoves.add(calculatePosition(X+2,Y-1));
            if(X+2<8 && Y+1<8 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X+2,Y+1))))
                legalMoves.add(calculatePosition(X+2,Y+1));
            if(X-1>-1 && Y-2>-1 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X-1,Y-2))))
                legalMoves.add(calculatePosition(X-1,Y-2));
            if(X-1>-1 && Y+2<8 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X-1,Y+2))))
                legalMoves.add(calculatePosition(X-1,Y+2));
            if(X+1<8 && Y-2>=-1 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X+1,Y-2))))
                legalMoves.add(calculatePosition(X+1,Y-2));
            if(X+1<8 && Y+2<8 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(X+1,Y+2))))
                legalMoves.add(calculatePosition(X+1,Y+2));
        }
        return  legalMoves;
    }

    @Override
    public EnumPiece getType() {
        return EnumPiece.KNIGHT;
    }



    @Override
    public boolean canAttackThisTile(int position, boolean whiteColor, Chessboard chessboard) {
        return false;
    }
}
