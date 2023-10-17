package piece;

import gui.Chessboard;
import gui.ChessboardPanel;


import java.util.ArrayList;

public class King extends Piece{

    public boolean hasAlreadyMoved;
    public King(int position, boolean whiteColor){
        this.position = position;
        this.whiteColor = whiteColor;
    }

    private boolean isLongCastlingLegal(Chessboard chessboard){
        if(this.hasAlreadyMoved){
            return false;
        }
        if(this.whiteColor){
            if(chessboard.whitePlayer.pieceMap.containsKey(56) && chessboard.whitePlayer.pieceMap.get(56).getType()==EnumPiece.ROOK){
                Rook temp = (Rook) chessboard.whitePlayer.pieceMap.get(56);
                if(temp.hasAlreadyMoved){
                    return  false;
                }
                if(chessboard.isOccupiedByColor(true, 59) || chessboard.isOccupiedByColor(false, 59) || chessboard.isOccupiedByColor(true, 58) || chessboard.isOccupiedByColor(false, 58)){
                    return false;
                }
                if(ChessboardPanel.isKingTileUnderAttack(true, chessboard) || isKingUnderAttack(60,59,true,chessboard) || isKingUnderAttack(60,58,true,chessboard)){
                    return false;
                }
            }else{
                return false;
            }
        }else{
            if(chessboard.blackPlayer.pieceMap.containsKey(0) && chessboard.blackPlayer.pieceMap.get(0).getType()==EnumPiece.ROOK){
                Rook temp = (Rook) chessboard.blackPlayer.pieceMap.get(0);
                if(temp.hasAlreadyMoved){
                    return  false;
                }
                if(chessboard.isOccupiedByColor(true, 3) || chessboard.isOccupiedByColor(false, 3) || chessboard.isOccupiedByColor(true, 2) || chessboard.isOccupiedByColor(false, 2)){
                    return false;
                }
                if(ChessboardPanel.isKingTileUnderAttack(false, chessboard) || isKingUnderAttack(4,3,false,chessboard) || isKingUnderAttack(4,2,false,chessboard)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean isShortCastlingLegal(Chessboard chessboard){
        if(this.hasAlreadyMoved){
            return false;
        }
        if(this.whiteColor){
            if(chessboard.whitePlayer.pieceMap.containsKey(63) && chessboard.whitePlayer.pieceMap.get(63).getType()==EnumPiece.ROOK){
                Rook temp = (Rook) chessboard.whitePlayer.pieceMap.get(63);
                if(temp.hasAlreadyMoved){
                    return  false;
                }
                if(chessboard.isOccupiedByColor(true, 61) || chessboard.isOccupiedByColor(false, 61) || chessboard.isOccupiedByColor(true, 62) || chessboard.isOccupiedByColor(false, 62)){
                    return false;
                }
                if(ChessboardPanel.isKingTileUnderAttack(true, chessboard) || isKingUnderAttack(60,61,true,chessboard) || isKingUnderAttack(60,62,true,chessboard)){
                    return false;
                }
            }else{
                return false;
            }
        }else{
            if(chessboard.blackPlayer.pieceMap.containsKey(7) && chessboard.blackPlayer.pieceMap.get(7).getType()==EnumPiece.ROOK){
                Rook temp = (Rook) chessboard.blackPlayer.pieceMap.get(7);
                if(temp.hasAlreadyMoved){
                    return  false;
                }
                if(chessboard.isOccupiedByColor(true, 5) || chessboard.isOccupiedByColor(false, 5) || chessboard.isOccupiedByColor(true, 6) || chessboard.isOccupiedByColor(false, 6)){
                    return false;
                }
                if(ChessboardPanel.isKingTileUnderAttack(false, chessboard) || isKingUnderAttack(4,5,false,chessboard) || isKingUnderAttack(4,6,false,chessboard)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
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
            if(isShortCastlingLegal(chessboard))
                legalMoves.add(62);
            if(isLongCastlingLegal(chessboard))
                legalMoves.add(58);


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
            if(isShortCastlingLegal(chessboard))
                legalMoves.add(6);
            if(isLongCastlingLegal(chessboard))
                legalMoves.add(2);

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
