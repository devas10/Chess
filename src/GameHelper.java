import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import Board.*;
import Pieces.Pieces;
import Board.Move;
import Pieces.Player;

public class GameHelper {

    enum GameColor{
        WHITE, BLACK
    }
    static Player [] players = new Player[2];
    static JButton [][] spots =new  JButton [8][8];
    static Pieces[][] p = new Pieces[8][8];
    static JFrame frame = new JFrame("CHESS");
    static JPanel f = new JPanel();

    void start(){
        Board b =new Board();
        b.initializeboard(spots,p,f);
        Player black = new Player();
        Player white = new Player();
        players[0]=white;
        players[1]=black;
        b.SetupPieces(players,p,spots);
        frame.add(f);
        frame.getContentPane().setBackground(new Color(73, 69, 69));
        WhiteButton wh = new WhiteButton();
        Dimension ButtonSize = new Dimension(105,105);
        Arrays.stream(spots).flatMap(Arrays::stream).forEach(spotTemp -> {
            spotTemp.setPreferredSize(ButtonSize);
            spotTemp.addActionListener(wh);
        });
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    } // close
    public static class WhiteButton implements ActionListener{
        JButton move1 =new JButton();
        int move = 0;
        int m1,n1;
        GameColor CurrentColor = GameColor.WHITE;
        @Override
        public void actionPerformed(ActionEvent a){
            br:
            if(move == 0){
                move1 =(JButton)a.getSource();
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
                System.out.println(CurrentColor);

                try{
                    if(move1.getComponent(0)!=null ){
                        if(CurrentColor == GameColor.BLACK && !p[m1][n1].isWhite()){move = 1;}
                        else if(CurrentColor == GameColor.WHITE && p[m1][n1].isWhite()){move = 1;}
                        else {JOptionPane.showMessageDialog(null, "PLEASE SELECT ONLY " + CurrentColor + " PIECES"); }
                    }
                }catch (Exception e){}
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
                    JButton temp1 = move1;
                    JButton temp2 = move2;
                    Move.Remover(move1,move2,p,m1,n1,m2,n2);
                  //  if(Check.Checker(p,spots,p[m1][n1].isWhite())){System.out.println("chek")}
                    CurrentColor = (CurrentColor==GameColor.WHITE)? GameColor.BLACK : GameColor.WHITE;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Move.");
                }
                move = 0;

            } // close else

            frame.revalidate();
            frame.repaint();

        }// actionPerformed


    } //Whitebutton




}