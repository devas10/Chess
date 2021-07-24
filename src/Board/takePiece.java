package Board;
import Pieces.Pieces;

import javax.swing.*;
import java.awt.*;

public class takePiece{
    private JFrame frame;
    private JButton[] takepieceset = new JButton[4];
    private final String [] type = {"R","H","B","Q"};
    private final String [] typeName = {"ROOK","KHIGHT","BISHOP","QUEEN"};
    private final String [] label = { "\u265C", "\u265E", "\u265D", "\u265B"};

    public void initialize(boolean pieceColor, int x, int y,JButton[][] pack,Pieces[][] set){
        Pieces newPiece = new Pieces();
        Font font = new Font("Sans-Serif",Font.BOLD,60);
        Font font1 = new Font("Sans-Serif",Font.PLAIN,15);
        frame = new JFrame("Consider Taking a Piece");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setSize(400,150);

        JPanel takePiecePanel = new JPanel();
        GridLayout layout =new GridLayout(1,4,0,0);
        takePiecePanel.setLayout(layout);
        takePiecePanel.setFont(font);
        GridLayout layout2 =new GridLayout(2,1,0,0);
        for(int temp=0;temp<4;temp++) {
            JButton tempButton = new JButton();
            tempButton.setLayout(layout2);
            tempButton.setBackground(new Color(213, 157, 48));
            JLabel label1 = new JLabel("");
            JLabel label2 = new JLabel("");
            if(pieceColor){
                label1.setForeground(Color.WHITE);
                label2.setForeground(Color.WHITE);
            }
            label1.setFont(font);
            label2.setFont(font1);
            label2.setText(typeName[temp]);
            label1.setText(label[temp]);
            tempButton.add(label1,JButton.CENTER);
            tempButton.add(label2,Component.CENTER_ALIGNMENT);
            takepieceset[temp] = tempButton;
            takePiecePanel.add(tempButton);
            tempButton.addActionListener(e -> {
                int temp1;
                for(temp1 =0; temp1 <4; temp1++) if (takepieceset[temp1] == (JButton) e.getSource()) break;
                JLabel templ = (JLabel)pack[x][y].getComponent(0);
                if(pieceColor) {
                    templ.setForeground(Color.WHITE);
                }
                templ.setText(label[temp1]);
                set[x][y].setType(type[temp1]);
                frame.dispose();
            });

        }
        frame.setResizable(false);
        frame.add(takePiecePanel);
        frame.repaint();
        frame.setAlwaysOnTop(true);
        frame.requestFocus();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return ;
    }
}
