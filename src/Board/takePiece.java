package Board;

import javax.swing.*;

public class takePiece {
    public JFrame frame;
    public int initialize(boolean pieceColor){
        frame = new JFrame("hello");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        JButton[] pieceButtons = new JButton[4];
        String [] type = {"R","H","B","Q"};
        return 0;
    }
}
