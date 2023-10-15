package piece;

import gui.Chessboard;
import gui.ChessboardPanel;


import java.util.ArrayList;

public class Pawn extends Piece{

    public int longMoveNumber = -1;
    public Pawn(int position, boolean whiteColor){
        this.position = position;
        this.whiteColor = whiteColor;
    }

    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<Integer>();
        if(this.whiteColor){
            if(!(chessboard.isOccupiedByColor(true, this.position-8))&& !(chessboard.isOccupiedByColor(false,this.position-8))&& !isKingUnderAttack(this.position,this.position-8, true, chessboard )) {
                legalMoves.add(this.position - 8);
                if((this.position/8)==6 && !(chessboard.isOccupiedByColor(true,this.position-16)) && !(chessboard.isOccupiedByColor(false,this.position-16)) && !isKingUnderAttack(this.position,this.position-16, true, chessboard ) ){
                    legalMoves.add(this.position - 16);
                }
            }
            if(this.position%8==0){
                if(chessboard.isOccupiedByColor(false,this.position-7) && !isKingUnderAttack(this.position,this.position-7, true, chessboard )) {
                    legalMoves.add(this.position-7);
                }
                if(this.position/8==3 && chessboard.isOccupiedByColor(false,this.position+1) && chessboard.blackPlayer.pieceMap.get(this.position+1).getType()==EnumPiece.PAWN){Pawn temp = (Pawn) chessboard.blackPlayer.pieceMap.get(this.position+1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.blackPlayer.pieceMap.remove(this.position+1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position-7, true, tempChessboard ))
                        legalMoves.add(this.position-7);
                }

            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(false, this.position-9) && !isKingUnderAttack(this.position,this.position-9, true, chessboard )){
                   legalMoves.add(this.position-9);
                }
                if(this.position/8==3 && chessboard.isOccupiedByColor(false,this.position-1) && chessboard.blackPlayer.pieceMap.get(this.position-1).getType()==EnumPiece.PAWN){
                    Pawn temp = (Pawn) chessboard.blackPlayer.pieceMap.get(this.position-1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.blackPlayer.pieceMap.remove(this.position-1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position-9, true, tempChessboard))
                        legalMoves.add(this.position-9);
                }
            }else {
                if(chessboard.isOccupiedByColor(false,this.position-7) && !isKingUnderAttack(this.position,this.position-7, true, chessboard )) {
                    legalMoves.add(this.position-7);
                }
                if(chessboard.isOccupiedByColor(false, this.position-9) && !isKingUnderAttack(this.position,this.position-9, true, chessboard )){
                    legalMoves.add(this.position-9);
                }
                if(this.position/8==3 && chessboard.isOccupiedByColor(false,this.position+1) && chessboard.blackPlayer.pieceMap.get(this.position+1).getType()==EnumPiece.PAWN){
                    Pawn temp = (Pawn) chessboard.blackPlayer.pieceMap.get(this.position+1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.blackPlayer.pieceMap.remove(this.position+1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position-7, true, tempChessboard ))
                        legalMoves.add(this.position-7);
                }
                if(this.position/8==3 && chessboard.isOccupiedByColor(false,this.position-1) && chessboard.blackPlayer.pieceMap.get(this.position-1).getType()==EnumPiece.PAWN){
                    Pawn temp = (Pawn) chessboard.blackPlayer.pieceMap.get(this.position-1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.blackPlayer.pieceMap.remove(this.position-1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position-9, true, tempChessboard))
                        legalMoves.add(this.position-9);
                }

            }
        }else{
            if (!(chessboard.isOccupiedByColor(true,this.position+8)) && !(chessboard.isOccupiedByColor(false,this.position+8)) && !isKingUnderAttack(this.position,this.position+8, false, chessboard )) {
                legalMoves.add(this.position + 8);
                if((this.position/8)==1 && !(chessboard.isOccupiedByColor(true,this.position+16)) && !(chessboard.isOccupiedByColor(false,this.position+16)) && !isKingUnderAttack(this.position,this.position+16, false, chessboard )){
                    legalMoves.add(this.position + 16);
                }
            }
            if(this.position%8==0){
                if(chessboard.isOccupiedByColor(true,this.position+9) && !isKingUnderAttack(this.position,this.position+9, false, chessboard )){
                    legalMoves.add(this.position+9);
                }
                if(this.position/8==4 && chessboard.isOccupiedByColor(true,this.position+1) && chessboard.whitePlayer.pieceMap.get(this.position+1).getType()==EnumPiece.PAWN){
                    Pawn temp = (Pawn) chessboard.whitePlayer.pieceMap.get(this.position+1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.whitePlayer.pieceMap.remove(this.position+1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position+9, false, tempChessboard ))
                        legalMoves.add(this.position+9);
                }

            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(true, this.position+7) && !isKingUnderAttack(this.position,this.position+7, false, chessboard )){
                    legalMoves.add(this.position+7);
                }
                if(this.position/8==4 && chessboard.isOccupiedByColor(true,this.position-1) && chessboard.whitePlayer.pieceMap.get(this.position-1).getType()==EnumPiece.PAWN){
                    Pawn temp = (Pawn) chessboard.whitePlayer.pieceMap.get(this.position-1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.whitePlayer.pieceMap.remove(this.position-1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position+7, false, tempChessboard))
                        legalMoves.add(this.position+7);
                }
            }else {
                if(chessboard.isOccupiedByColor(true,this.position+7)&& !isKingUnderAttack(this.position,this.position+7, false, chessboard )) {
                    legalMoves.add(this.position+7);
                }
                if(chessboard.isOccupiedByColor(true, this.position+9) && !isKingUnderAttack(this.position,this.position+9, false, chessboard )){
                    legalMoves.add(this.position+9);
                }

                if(this.position/8==4 && chessboard.isOccupiedByColor(true,this.position+1) && chessboard.whitePlayer.pieceMap.get(this.position+1).getType()==EnumPiece.PAWN){
                    Pawn temp = (Pawn) chessboard.whitePlayer.pieceMap.get(this.position+1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.whitePlayer.pieceMap.remove(this.position+1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position+9, false, tempChessboard ))
                        legalMoves.add(this.position+9);
                }
                if(this.position/8==4 && chessboard.isOccupiedByColor(true,this.position-1) && chessboard.whitePlayer.pieceMap.get(this.position-1).getType()==EnumPiece.PAWN){
                    Pawn temp = (Pawn) chessboard.whitePlayer.pieceMap.get(this.position-1);
                    Chessboard tempChessboard = Chessboard.deepCopyChessboard(chessboard);
                    tempChessboard.whitePlayer.pieceMap.remove(this.position-1);
                    if(temp.longMoveNumber == (ChessboardPanel.moveNumber-1) && !isKingUnderAttack(this.position,this.position+7, false, tempChessboard))
                        legalMoves.add(this.position+7);
                }

            }
        }
        return legalMoves;
    }


    @Override
    public EnumPiece getType() {
        return EnumPiece.PAWN;
    }

    @Override
    public boolean canAttackThisTile(int position, boolean whiteColor, Chessboard chessboard) {
        if(whiteColor){
            if(this.position%8==0){
                if(chessboard.isOccupiedByColor(false,this.position-7)) {
                    if(this.position-7==position){
                        return true;
                    }

                }
            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(false, this.position-9)){
                    if(this.position-9==position){
                        return true;
                    }
                }
            }else {
                if(chessboard.isOccupiedByColor(false,this.position-7)) {
                    if(this.position-7==position){
                        return true;
                    }
                }
                if(chessboard.isOccupiedByColor(false, this.position-9)){
                    if(this.position-9==position){
                        return true;
                    }
                }
            }
        }else{
            if(this.position%8==0){
                if(chessboard.isOccupiedByColor(true,this.position+9)) {
                    if(this.position+9==position){
                        return true;
                    }
                }
            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(true,this.position+7) ){
                    if (this.position+7 == position) {
                        return true;
                    }
                }
            }else {
                if(chessboard.isOccupiedByColor(true,this.position+7)) {
                    if(this.position+7==position){
                        return true;
                    }
                }
                if(chessboard.isOccupiedByColor(true, this.position+9)){
                    if(this.position+9==position){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
