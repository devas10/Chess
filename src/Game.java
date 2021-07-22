import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Board.Board;
import Pieces.Pieces;
import Board.Move;
import Pieces.Player;

public class Game {

    static Player [] players = new Player[2];
    static JButton [][] spots =new  JButton [8][8];
    static Pieces[][] p = new Pieces[8][8];
    static JFrame frame = new JFrame("CHESS");
    static JPanel f = new JPanel();

    public static void main(String [] args){


        Board b =new Board();
        b.initializeboard(spots,p,f);
        frame.add(f);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(73, 69, 69));

        WhiteButton wh = new WhiteButton();

        for(JButton [] spotv : spots){
            for(JButton spoth : spotv){
                spoth.addActionListener(wh);
            }
        }
    } // close
    public static class WhiteButton implements ActionListener{
        JButton move1 =new JButton();
        int move = 0;
        int m1,n1;

        @Override
        public void actionPerformed(ActionEvent a){
            br:
            if(move == 0){
                move1 =(JButton)a.getSource();
                try{
                    if(move1.getComponent(0)!=null){
                        move = 1;
                        move1.getModel().setPressed(true);
                    }
                }catch (Exception e){}
                //  System.out.println(move1);
                int i=0,j=0;
                dev:
                for(i=0;i<8;i++){
                    for(j=0;j<8;j++){
                        if(spots[i][j]==move1){
                            break dev;}
                    } // close i
                }  // close j
                System.out.println(i+"  "+j);
                //System.out.println(move1);
                m1=i;
                n1=j;
            } // close if

            else if(move==1) {
                JButton move2 =(JButton)a.getSource();
                if(move1==move2){
                    move=0;
                    break br;
                }

                int k=0,l=0;
                spark:
                for(k=0;k<8;k++){
                    for(l=0;l<8;l++){
                        if(spots[k][l]==move2){
                            System.out.println(k+"  "+l);
                            break spark;}
                    } // close i
                }  // close j
                int m2=k;
                int n2=l;
                try{
                    if(p[m1][n1].isWhite()==p[m2][n2].isWhite()){
                        move=0;
                        break br;
                    }
                } catch (Exception e){}
                //System.out.print(chess.Move.Move(m1,n1,m2,n2,p,spots));
                if(Move.Mover(m1,n1,m2,n2,p,spots)){
                    try{
                        move2.remove((JLabel)move2.getComponent(0));
                    } catch (Exception e){}
                    JLabel button = (JLabel)move1.getComponent(0);

                    move2.add(button);
                    move1.remove(button);
                    move1 = null;

                    try{
                        p[m2][n2]=p[m1][n1];
                        p[m1][n1]=null;
                    } catch (Exception e){}



                    //System.out.println(move1+"      "+move2);
                }
                move = 0;

            } // close else
            frame.revalidate();
            frame.repaint();

        }// actionPerformed
    } //whtebutton
    void changeplayer (Player current){
        if(current == players[0]){
            current = players[1];
        }
        else{
            current = players[0];
        }
    }
}