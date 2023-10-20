package piece;

import gui.Chessboard;


import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(int position, boolean whiteColor){
        this.position = position;
        this.isWhiteColor = whiteColor;
    }

    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<>();
        int X = position % 8;
        int Y = position / 8;
        int tempX = X-1;
        int tempY = Y-1;
        if(this.isWhiteColor){
            while(tempX>-1 && tempY>-1 && !(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), true, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                --tempY;
            }
            tempX=X-1;
            tempY=Y+1;
            while(tempX>-1 && tempY<8 && !(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), true, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                ++tempY;
            }
            tempX=X+1;
            tempY=Y-1;
            while(tempX<8 && tempY>-1 && !(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), true, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                --tempY;
            }
            tempX=X+1;
            tempY=Y+1;
            while(tempX<8 && tempY<8 && !( chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), true, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                ++tempY;
            }
        }else{
            while(tempX>-1 && tempY>-1 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), false, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                --tempY;
            }
            tempX=X-1;
            tempY=Y+1;
            while(tempX>-1 && tempY<8 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), false, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                ++tempY;
            }
            tempX=X+1;
            tempY=Y-1;
            while(tempX<8 && tempY>-1 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), false, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                --tempY;
            }
            tempX=X+1;
            tempY=Y+1;
            while(tempX<8 && tempY<8 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                if (!isKingUnderAttack(calculatePosition(X,Y),calculatePosition(tempX,tempY), false, chessboard))
                    legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
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
    public boolean canAttackThisTile(int tilePosition, boolean isWhiteColorAttacking, Chessboard chessboard) {

        ArrayList<Integer> legalMoves = new ArrayList<>();
        int X = this.position % 8;
        int Y = this.position / 8;
        int tempX = X-1;
        int tempY = Y-1;
        if(this.isWhiteColor){
            while(tempX>-1 && tempY>-1 && !(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                --tempY;
            }
            tempX=X-1;
            tempY=Y+1;
            while(tempX>-1 && tempY<8 && !(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                ++tempY;
            }
            tempX=X+1;
            tempY=Y-1;
            while(tempX<8 && tempY>-1 && !(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                --tempY;
            }
            tempX=X+1;
            tempY=Y+1;
            while(tempX<8 && tempY<8 && !( chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                ++tempY;
            }
        }else{
            while(tempX>-1 && tempY>-1 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                --tempY;
            }
            tempX=X-1;
            tempY=Y+1;
            while(tempX>-1 && tempY<8 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                --tempX;
                ++tempY;
            }
            tempX=X+1;
            tempY=Y-1;
            while(tempX<8 && tempY>-1 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                --tempY;
            }
            tempX=X+1;
            tempY=Y+1;
            while(tempX<8 && tempY<8 && !(chessboard.isOccupiedByColor(false,calculatePosition(tempX,tempY)))){
                legalMoves.add(calculatePosition(tempX,tempY));
                if(chessboard.isOccupiedByColor(true,calculatePosition(tempX,tempY))){
                    break;
                }
                ++tempX;
                ++tempY;
            }
        }
        return  legalMoves.contains(tilePosition);
    }
}
