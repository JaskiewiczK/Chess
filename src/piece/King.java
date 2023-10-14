package piece;

import gui.Chessboard;


import java.util.ArrayList;

public class King extends Piece{
    public King(int position, boolean whiteColor){
        this.position = position;
        this.whiteColor = whiteColor;
    }




    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard){
        ArrayList<Integer> legalMoves = new ArrayList<>();
        int X = position % 8;
        int Y = position / 8;
        if(whiteColor) {
            if (X + 1 < 8 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(true,calculatePosition(X+1,Y+1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X+1,Y+1), true, chessboard))
                legalMoves.add(calculatePosition(X+1,Y+1));
            if (Y + 1 < 8 && !(chessboard.isOccupiedByColor(true,calculatePosition(X,Y+1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X,Y+1), true, chessboard))
                legalMoves.add(calculatePosition(X,Y+1));
            if (X - 1 > -1 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(true,calculatePosition(X-1,Y+1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X-1,Y+1), true, chessboard))
                legalMoves.add(calculatePosition(X-1,Y+1));
            if (X + 1 < 8 &&  !(chessboard.isOccupiedByColor(true,calculatePosition(X+1,Y)))&& !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X+1,Y), true, chessboard))
                legalMoves.add(calculatePosition(X+1,Y));
            if (X - 1 > -1  && !(chessboard.isOccupiedByColor(true,calculatePosition(X-1,Y)))&& !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X-1,Y), true, chessboard))
                legalMoves.add(calculatePosition(X-1,Y));
            if (X + 1 < 8 && Y -1 > -1 && !(chessboard.isOccupiedByColor(true,calculatePosition(X+1,Y-1)))&& !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X+1,Y-1), true, chessboard))
                legalMoves.add(calculatePosition(X+1,Y-1));
            if (Y - 1 > -1 && !(chessboard.isOccupiedByColor(true,calculatePosition(X,Y-1)))&& !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X,Y-1), true, chessboard))
                legalMoves.add(calculatePosition(X,Y-1));
            if (X -1 > -1 && Y -1 > - 1  && !(chessboard.isOccupiedByColor(true,calculatePosition(X-1,Y-1)))&& !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X-1,Y-1), true, chessboard))
                legalMoves.add(calculatePosition(X-1,Y-1));
        }else{
            if (X + 1 < 8 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(false,calculatePosition(X+1,Y+1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X+1,Y+1), false, chessboard))
                legalMoves.add(calculatePosition(X + 1, Y + 1));
            if (Y + 1 < 8 && !(chessboard.isOccupiedByColor(false,calculatePosition(X,Y+1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X,Y+1), false, chessboard))
                legalMoves.add(calculatePosition(X,Y+1));
            if (X - 1 > -1 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(false,calculatePosition(X-1,Y+1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X-1,Y+1), false, chessboard))
                legalMoves.add(calculatePosition(X-1,Y+1));
            if (X + 1 < 8 &&  !(chessboard.isOccupiedByColor(false,calculatePosition(X+1,Y))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X+1,Y), false, chessboard))
                legalMoves.add(calculatePosition(X+1,Y));
            if (X - 1 > -1  && !(chessboard.isOccupiedByColor(false,calculatePosition(X-1,Y))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X-1,Y), false, chessboard))
                legalMoves.add(calculatePosition(X-1,Y));
            if (X + 1 < 8 && Y -1 > -1 && !(chessboard.isOccupiedByColor(false,calculatePosition(X+1,Y-1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X+1,Y-1), false, chessboard))
                legalMoves.add(calculatePosition(X+1,Y-1));
            if (Y - 1 > -1 && !(chessboard.isOccupiedByColor(false,calculatePosition(X,Y-1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X,Y-1), false, chessboard))
                legalMoves.add(calculatePosition(X,Y-1));
            if (X -1 > -1 && Y -1 > - 1  && !(chessboard.isOccupiedByColor(false,calculatePosition(X-1,Y-1))) && !isKingUnderAttack(calculatePosition(X,Y),calculatePosition(X-1,Y-1), false, chessboard))
                legalMoves.add(calculatePosition(X-1,Y-1));
        }

        return legalMoves;
    }

    @Override
    public EnumPiece getType() {
        return EnumPiece.KING;
    }

    @Override
    public boolean canAttackThisTile(int position, boolean whiteColor, Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<>();
        int X = this.position % 8;
        int Y = this.position / 8;
        if(whiteColor) {
            if (X + 1 < 8 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(true,calculatePosition(X+1,Y+1))))
                legalMoves.add(calculatePosition(X+1,Y+1));
            if (Y + 1 < 8 && !(chessboard.isOccupiedByColor(true,calculatePosition(X,Y+1))))
                legalMoves.add(calculatePosition(X,Y+1));
            if (X - 1 > -1 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(true,calculatePosition(X-1,Y+1))))
                legalMoves.add(calculatePosition(X-1,Y+1));
            if (X + 1 < 8 &&  !(chessboard.isOccupiedByColor(true,calculatePosition(X+1,Y))))
                legalMoves.add(calculatePosition(X+1,Y));
            if (X - 1 > -1  && !(chessboard.isOccupiedByColor(true,calculatePosition(X-1,Y))))
                legalMoves.add(calculatePosition(X-1,Y));
            if (X + 1 < 8 && Y -1 > -1 && !(chessboard.isOccupiedByColor(true,calculatePosition(X+1,Y-1))))
                legalMoves.add(calculatePosition(X+1,Y-1));
            if (Y - 1 > -1 && !(chessboard.isOccupiedByColor(true,calculatePosition(X,Y-1))))
                legalMoves.add(calculatePosition(X,Y-1));
            if (X -1 > -1 && Y -1 > - 1  && !(chessboard.isOccupiedByColor(true,calculatePosition(X-1,Y-1))))
                legalMoves.add(calculatePosition(X-1,Y-1));
        }else{
            if (X + 1 < 8 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(false,calculatePosition(X+1,Y+1))))
                legalMoves.add(calculatePosition(X + 1, Y + 1));
            if (Y + 1 < 8 && !(chessboard.isOccupiedByColor(false,calculatePosition(X,Y+1))))
                legalMoves.add(calculatePosition(X,Y+1));
            if (X - 1 > -1 && Y + 1 < 8 && !(chessboard.isOccupiedByColor(false,calculatePosition(X-1,Y+1))))
                legalMoves.add(calculatePosition(X-1,Y+1));
            if (X + 1 < 8 &&  !(chessboard.isOccupiedByColor(false,calculatePosition(X+1,Y))))
                legalMoves.add(calculatePosition(X+1,Y));
            if (X - 1 > -1  && !(chessboard.isOccupiedByColor(false,calculatePosition(X-1,Y))))
                legalMoves.add(calculatePosition(X-1,Y));
            if (X + 1 < 8 && Y -1 > -1 && !(chessboard.isOccupiedByColor(false,calculatePosition(X+1,Y-1))))
                legalMoves.add(calculatePosition(X+1,Y-1));
            if (Y - 1 > -1 && !(chessboard.isOccupiedByColor(false,calculatePosition(X,Y-1))))
                legalMoves.add(calculatePosition(X,Y-1));
            if (X -1 > -1 && Y -1 > - 1  && !(chessboard.isOccupiedByColor(false,calculatePosition(X-1,Y-1))))
                legalMoves.add(calculatePosition(X-1,Y-1));
        }


        return legalMoves.contains(position);
    }
}
