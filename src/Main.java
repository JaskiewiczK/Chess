import gui.Chessboard;
import gui.ChessboardFrame;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        new ChessboardFrame(chessboard);
    }

}