package gui;

import javax.swing.*;
import java.awt.*;

public class ChessboardFrame extends JFrame {

    private int height = (int) (33/35 *Toolkit.getDefaultToolkit().getScreenSize().getHeight());
    ChessboardPanel panel;
    public ChessboardFrame(Chessboard chessboard){
        panel = new ChessboardPanel(chessboard);
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

}
