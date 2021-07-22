package Board;

import Pieces.Pieces;
import Pieces.Player;
import Type.SetPieces;

import javax.swing.*;
import java.awt.*;

public class   Board {

    public static Player [] players = new Player[2];
    public static JButton[][] spots = new JButton[8][8];

  /*  public static void main(String[] args){
        JButton [][] spots = new JButton[8][8];
        Pieces[][] pack = new Pieces[8][8];
        JPanel panel = new JPanel();
        Board b =new Board();
        players =b.initializeboard(spots,pack,panel);
    }
*/

    public Player [] initializeboard(JButton [][] spots,Pieces [][] pack,JPanel panel){
        Font font = new Font("Sans-Serif",Font.BOLD,60);
        Pieces[][] set = new Pieces[8][8];

        panel.setSize(800,800);
        GridLayout layout =new GridLayout(8,8,1,1);
        panel.setLayout(layout);

        int iterator1=0;
        Player[] play = new Player[2];
        Player black = new Player();
        Player white = new Player();

        for(int ver=0;ver<8;ver++){
            for(int hor=0;hor<8;hor++){

                JButton button = new JButton();
                Pieces p =new Pieces();

                if((ver+hor)%2==0) { button.setBackground(new Color(213, 157, 48));}
                else{ button.setBackground(new Color(212, 192, 192));}

                JLabel label = new JLabel();
                label.setFont(font);

                switch(ver){
                    case 0:
                    case 1:  black.pack[iterator1]=button;

                    case 6:
                    case 7:   if((ver!=0)&&(ver!=1)){
                        label.setForeground(Color.WHITE);
                        white.pack[iterator1-16]=button;
                        p.setWhite(true);
                    }
                        label =new JLabel("");

                        label.setText(SetPieces.pieces[iterator1]);
                        p.setType(SetPieces.type[iterator1++]);
                     //   label.setForeground(Color.WHITE);
                        p.setX(hor);
                        p.setY(ver);
                        p.setButton(button);
                        label.setFont(font);
                        button.add(label);
                        pack[ver][hor]= p;
                        set[ver][hor]= p;
                        break;
                    default:
                        break;
                }// close switch
                panel.add(button);
                spots[ver][hor]=button;
            }
        }
        play[0]=white;
        play[1]=black;

        return play;
    } // close initializeboard
}// close board

