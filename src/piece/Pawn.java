package piece;

import gui.Chessboard;
import gui.ChessboardPanel;


import java.util.ArrayList;

public class Pawn extends Piece{

    public int longMoveNumber = -1;
    public Pawn(int position, boolean whiteColor){
        this.position = position;
        this.isWhiteColor = whiteColor;
    }

    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<>();
        if(this.isWhiteColor){
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
    public boolean canAttackThisTile(int tilePosition, boolean isWhiteColorAttacking, Chessboard chessboard) {
        if(isWhiteColorAttacking){
            if(this.position%8==0){
                if(chessboard.isOccupiedByColor(false,this.position-7)) {
                    return this.position - 7 == tilePosition;

                }
            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(false, this.position-9)){
                    return this.position - 9 == tilePosition;
                }
            }else {
                if(chessboard.isOccupiedByColor(false,this.position-7)) {
                    if(this.position-7== tilePosition){
                        return true;
                    }
                }
                if(chessboard.isOccupiedByColor(false, this.position-9)){
                    return this.position - 9 == tilePosition;
                }
            }
        }else{
            if(this.position%8==0){
                if(chessboard.isOccupiedByColor(true,this.position+9)) {
                    return this.position + 9 == tilePosition;
                }
            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(true,this.position+7) ){
                    return this.position + 7 == tilePosition;
                }
            }else {
                if(chessboard.isOccupiedByColor(true,this.position+7)) {
                    if(this.position+7== tilePosition){
                        return true;
                    }
                }
                if(chessboard.isOccupiedByColor(true, this.position+9)){
                    return this.position + 9 == tilePosition;
                }
            }
        }
        return false;
    }
}
