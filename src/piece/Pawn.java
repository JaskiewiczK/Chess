package piece;

import gui.Chessboard;



import java.util.ArrayList;

public class Pawn extends Piece{


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
            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(false, this.position-9) && !isKingUnderAttack(this.position,this.position-9, true, chessboard )){
                   legalMoves.add(this.position-9);
                }
            }else {
                if(chessboard.isOccupiedByColor(false,this.position-7) && !isKingUnderAttack(this.position,this.position-7, true, chessboard )) {
                    legalMoves.add(this.position-7);
                }
                if(chessboard.isOccupiedByColor(false, this.position-9) && !isKingUnderAttack(this.position,this.position-9, true, chessboard )){
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
                if(chessboard.isOccupiedByColor(true,this.position+9) && !isKingUnderAttack(this.position,this.position+9, false, chessboard )) {
                    legalMoves.add(this.position+9);
                }
            }else if(this.position%8==7){
                if(chessboard.isOccupiedByColor(true, this.position+7) && !isKingUnderAttack(this.position,this.position+7, false, chessboard )){
                    legalMoves.add(this.position+7);
                }
            }else {
                if(chessboard.isOccupiedByColor(true,this.position+7)&& !isKingUnderAttack(this.position,this.position+7, false, chessboard )) {
                    legalMoves.add(this.position+7);
                }
                if(chessboard.isOccupiedByColor(true, this.position+9) && !isKingUnderAttack(this.position,this.position+9, false, chessboard )){
                    legalMoves.add(this.position+9);
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
