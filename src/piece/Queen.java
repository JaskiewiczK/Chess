package piece;

import gui.Chessboard;

import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(int position, boolean whiteColor){
        this.position = position;
        this.isWhiteColor = whiteColor;
    }
    @Override
    public ArrayList<Integer> getLegalMoves(Chessboard chessboard) {
        ArrayList<Integer> legalMoves = new ArrayList<>();

        Rook rook = new Rook(this.position, isWhiteColor);
        Bishop bishop = new Bishop(this.position, isWhiteColor);
        legalMoves.addAll(rook.getLegalMoves(chessboard));
        legalMoves.addAll(bishop.getLegalMoves(chessboard));
        return legalMoves;
    }

    @Override
    public EnumPiece getType() {
        return EnumPiece.QUEEN;
    }

    @Override
    public boolean canAttackThisTile(int tilePosition, boolean isWhiteColorAttacking, Chessboard chessboard) {
        Rook rook = new Rook(this.position, isWhiteColorAttacking);
        Bishop bishop = new Bishop(this.position, isWhiteColorAttacking);
        return (rook.canAttackThisTile(tilePosition, isWhiteColorAttacking, chessboard) || bishop.canAttackThisTile(tilePosition, isWhiteColorAttacking, chessboard));
    }
}
