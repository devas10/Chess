package Board;

import Pieces.Pieces;
import Pieces.Player;
import Type.SetPieces;

import javax.swing.*;
import java.awt.*;

public class Board {

    public void initializeboard(JButton [][] spots,Pieces [][] pack,JPanel panel){

        Pieces[][] set = new Pieces[8][8];
        panel.setSize(800,800);

        GridLayout layout =new GridLayout(8,8,0,0);
        panel.setLayout(layout);
        for(int ver=0;ver<8;ver++) {
            for (int hor = 0; hor < 8; hor++) {

                JButton button = new JButton();


                if ((ver + hor) % 2 == 0) {
                    button.setBackground(new Color(213, 157, 48));
                } else {
                    button.setBackground(new Color(212, 192, 192));
                }

                panel.add(button);
                spots[ver][hor] = button;
            }
        }
        return;
    } // close initializeboard

    public void SetupPieces(Player[] play, Pieces[][] set, JButton[][] spots) {

        int iterator1 = 0;
        Font font = new Font("Sans-Serif",Font.BOLD,60);
        JLabel label = new JLabel();
        label.setFont(font);
        for(int ver=0;ver<8;ver++) {
            for (int hor = 0; hor <8; hor++) {
                Pieces p = new Pieces();
                if (ver == 2 ) {
                    ver += 4;
                }
                label = new JLabel("");
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                label.setAlignmentY(Component.CENTER_ALIGNMENT);
                label.setText(SetPieces.pieces[iterator1]);
                p.setType(SetPieces.type[iterator1++]);

                p.setX(hor);
                p.setY(ver);
                p.setButton(spots[ver][hor]);
                label.setFont(font);
                spots[ver][hor].setHorizontalAlignment(JButton.CENTER);
                spots[ver][hor].add(label);
                set[ver][hor] = p;
                if (ver < 2) {play[1].addButton(spots[ver][hor]); play[1].addPiece(p); }
                if (ver > 5) {play[0].addButton(spots[ver][hor]); p.setWhite(true); play[0].addPiece(p);}
            }

            System.out.println();
        }

     return;
    }

}// close board

