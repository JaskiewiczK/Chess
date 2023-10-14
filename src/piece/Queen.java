package piece;

import gui.Chessboard;

import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(int position, boolean whiteColor){
        this.position = position;
        this.whiteColor = whiteColor;
    }
    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<>();

        Rook rook = new Rook(this.position, whiteColor);
        Bishop bishop = new Bishop(this.position, whiteColor);
        legalMoves.addAll(rook.getLegalMoves(chessboard));
        legalMoves.addAll(bishop.getLegalMoves(chessboard));
        return legalMoves;
    }

    @Override
    public EnumPiece getType() {
        return EnumPiece.QUEEN;
    }

    @Override
    public boolean canAttackThisTile(int position, boolean whiteColor, Chessboard chessboard) {
        Rook rook = new Rook(this.position, whiteColor);
        Bishop bishop = new Bishop(this.position, whiteColor);
        return (rook.canAttackThisTile(position, whiteColor, chessboard) || bishop.canAttackThisTile(position, whiteColor, chessboard));
    }
}
