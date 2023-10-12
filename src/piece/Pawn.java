package piece;

import gui.Chessboard;
import gui.ChessboardPanel;

import java.sql.SQLOutput;
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
            if((this.position/8)==6 && !(ChessboardPanel.isOccupiedByColor(true,this.position-16)) && !(ChessboardPanel.isOccupiedByColor(false,this.position-16))){
                legalMoves.add(this.position - 16);
            }
            if(!(ChessboardPanel.isOccupiedByColor(true, this.position-8))&& !(ChessboardPanel.isOccupiedByColor(false,this.position-8)))
                legalMoves.add(this.position - 8);
            if(this.position%8==0){
                if(ChessboardPanel.isOccupiedByColor(false,this.position-7)) {
                    legalMoves.add(this.position-7);
                }
            }else if(this.position%8==7){
                if(ChessboardPanel.isOccupiedByColor(false, this.position-9)){
                   legalMoves.add(this.position-9);
                }
            }else {
                if(ChessboardPanel.isOccupiedByColor(false,this.position-7)) {
                    legalMoves.add(this.position-7);
                }
                if(ChessboardPanel.isOccupiedByColor(false, this.position-9)){
                    legalMoves.add(this.position-9);
                }
            }
        }else{
            if((this.position/8)==1 && !(ChessboardPanel.isOccupiedByColor(true,this.position+16)) && !(ChessboardPanel.isOccupiedByColor(false,this.position+16))){
                legalMoves.add(this.position + 16);
            }
            if (!(ChessboardPanel.isOccupiedByColor(true,this.position+8)) && !(ChessboardPanel.isOccupiedByColor(false,this.position+8))) {
                legalMoves.add(this.position + 8);
            }
            if(this.position%8==0){
                if(ChessboardPanel.isOccupiedByColor(true,this.position+9)) {
                    legalMoves.add(this.position+9);
                }
            }else if(this.position%8==7){
                if(ChessboardPanel.isOccupiedByColor(true, this.position+7)){
                    legalMoves.add(this.position+7);
                }
            }else {
                if(ChessboardPanel.isOccupiedByColor(true,this.position+7)) {
                    legalMoves.add(this.position+7);
                }
                if(ChessboardPanel.isOccupiedByColor(true, this.position+9)){
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
                if(ChessboardPanel.isOccupiedByColor(false,this.position-7)) {
                    if(this.position-7==position){
                        return true;
                    }

                }
            }else if(this.position%8==7){
                if(ChessboardPanel.isOccupiedByColor(false, this.position-9)){
                    if(this.position-9==position){
                        return true;
                    }
                }
            }else {
                if(ChessboardPanel.isOccupiedByColor(false,this.position-7)) {
                    if(this.position-7==position){
                        return true;
                    }
                }
                if(ChessboardPanel.isOccupiedByColor(false, this.position-9)){
                    if(this.position-9==position){
                        return true;
                    }
                }
            }
        }else{
            if(this.position%8==0){
                if(ChessboardPanel.isOccupiedByColor(true,this.position+9)) {
                    if(this.position+9==position){
                        return true;
                    }
                }
            }else if(this.position%8==7){
                if(ChessboardPanel.isOccupiedByColor(true,this.position+7) ){
                    if (this.position+7 == position) {
                        return true;
                    }
                }
            }else {
                System.out.println("git  " + (this.position+7) +" "+(this.position+9)+" "+position);
                if(chessboard.isOccupiedByColor(true,this.position+7)) {
                    System.out.println("wchodze");
                    if(this.position+7==position){
                        return true;
                    }
                }
                if(ChessboardPanel.isOccupiedByColor(true, this.position+9)){
                    if(this.position+9==position){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
