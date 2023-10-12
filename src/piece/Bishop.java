package piece;

import gui.Chessboard;
import gui.ChessboardPanel;

import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(int position, boolean whiteColor){
        this.position = position;
        this.whiteColor = whiteColor;
    }

    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<Integer>();
        int X = position % 8;
        int Y = position / 8;
        int tempX = X-1;
        int tempY = Y-1;
        if(this.whiteColor){
            while(tempX>-1 && tempY>-1 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                --tempY;
            }
            tempX=X-1;
            tempY=Y+1;
            while(tempX>-1 && tempY<8 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                ++tempY;
            }
            tempX=X+1;
            tempY=Y-1;
            while(tempX<8 && tempY>-1 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                --tempY;
            }
            tempX=X+1;
            tempY=Y+1;
            while(tempX<8 && tempY<8 && !(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                ++tempY;
            }
        }else{
            while(tempX>-1 && tempY>-1 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                --tempY;
            }
            tempX=X-1;
            tempY=Y+1;
            while(tempX>-1 && tempY<8 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                ++tempY;
            }
            tempX=X+1;
            tempY=Y-1;
            while(tempX<8 && tempY>-1 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                --tempY;
            }
            tempX=X+1;
            tempY=Y+1;
            while(tempX<8 && tempY<8 && !(ChessboardPanel.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(ChessboardPanel.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                ++tempY;
            }
        }
        return legalMoves;
    }

    @Override
    public EnumPiece getType() {
        return EnumPiece.BISHOP;
    }

    @Override
    public boolean canAttackThisTile(int position, boolean whiteColor, Chessboard chessboard) {
        return false;
    }
}
