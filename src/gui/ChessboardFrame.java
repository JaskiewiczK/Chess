package gui;

import javax.swing.*;


public class ChessboardFrame extends JFrame {
    public ChessboardFrame(Chessboard chessboard){
        ChessboardPanel panel = new ChessboardPanel(chessboard);
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

}
