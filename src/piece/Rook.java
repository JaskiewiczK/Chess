package piece;

import gui.Chessboard;



import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(int position, boolean whiteColor){
        this.position = position;
        this.whiteColor = whiteColor;
    }

    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<Integer>();
        int X = position % 8;
        int Y = position / 8;
        int tempX = X - 1;
        int tempY = Y - 1;
        if (this.whiteColor) {
            while (tempX > -1 && !(chessboard.isOccupiedByColor(true, calculatePosition(tempX, Y)))) {
                legalMoves.add(calculatePosition(tempX, Y));
                if (chessboard.isOccupiedByColor(false, calculatePosition(tempX, Y))) {
                    break;
                }
                --tempX;
            }
            tempX = X + 1;
            while (tempX < 8 && !(chessboard.isOccupiedByColor(true, calculatePosition(tempX, Y)))) {
                legalMoves.add(calculatePosition(tempX, Y));
                if (chessboard.isOccupiedByColor(false, calculatePosition(tempX, Y))) {
                    break;
                }
                ++tempX;
            }
            while (tempY > -1 && !(chessboard.isOccupiedByColor(true, calculatePosition(X, tempY)))) {
                legalMoves.add(calculatePosition(X, tempY));
                if (chessboard.isOccupiedByColor(false, calculatePosition(X, tempY))) {
                    break;
                }
                --tempY;
            }
            tempY = Y + 1;
            while (tempY < 8 && !(chessboard.isOccupiedByColor(true, calculatePosition(X, tempY)))) {
                legalMoves.add(calculatePosition(X, tempY));
                if (chessboard.isOccupiedByColor(false, calculatePosition(X, tempY))) {
                    break;
                }
                ++tempY;
            }

        }else{
            while (tempX > -1 && !(chessboard.isOccupiedByColor(false, calculatePosition(tempX, Y)))) {
                legalMoves.add(calculatePosition(tempX, Y));
                if (chessboard.isOccupiedByColor(true, calculatePosition(tempX, Y))) {
                    break;
                }
                --tempX;
            }
            tempX = X + 1;
            while (tempX < 8 && !(chessboard.isOccupiedByColor(false, calculatePosition(tempX, Y)))) {
                legalMoves.add(calculatePosition(tempX, Y));
                if (chessboard.isOccupiedByColor(true, calculatePosition(tempX, Y))) {
                    break;
                }
                ++tempX;
            }
            while (tempY > -1 && !(chessboard.isOccupiedByColor(false, calculatePosition(X, tempY)))) {
                legalMoves.add(calculatePosition(X, tempY));
                if (chessboard.isOccupiedByColor(true, calculatePosition(X, tempY))) {
                    break;
                }
                --tempY;
            }
            tempY = Y + 1;
            while (tempY < 8 && !(chessboard.isOccupiedByColor(false, calculatePosition(X, tempY)))) {
                legalMoves.add(calculatePosition(X, tempY));
                if (chessboard.isOccupiedByColor(true, calculatePosition(X, tempY))) {
                    break;
                }
                ++tempY;
            }
        }
        return legalMoves;
    }

    @Override
    public EnumPiece getType() {
        return EnumPiece.ROOK;
    }

    @Override
    public boolean canAttackThisTile(int position, boolean whiteColor, Chessboard chessboard) {
        ArrayList<Integer> arrayList = getLegalMoves(chessboard);
        if(arrayList.contains(position)){
            return true;
        }
        return false;
    }
}
