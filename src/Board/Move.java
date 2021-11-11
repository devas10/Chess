package Board;

import javax.swing.*;
import Pieces.Pieces;

import Type.*;

public class Move{
    public static boolean Mover (int m1,int n1 ,int m2,int n2,Pieces [][] pack,JButton [][] spots){

        boolean is = false;

        if(pack[m1][n1]==null){
            return false;
        }

        switch (pack[m1][n1].getType()) {
            case "H" -> {
                is = Knight.isValid(m1, n1, m2, n2);
                //knight(m1,n1,m2,n2);
                return is;
            }
            case "Q" -> {
                char QueenType;
                QueenType = Queen.isValid(m1, n1, m2, n2);
                return Queen.CheckPath(m1, n1, m2, n2, spots,QueenType);
            }
            case "B" -> {
                is = Bishop.isValid(m1, n1, m2, n2);
                if (is) {
                    is = Bishop.CheckPath(m1, n1, m2, n2, spots);
                }
                return is;
            }
            case "R" -> {
                is = Rook.isValid(m1, n1, m2, n2);
                if (is) {
                    is = Rook.CheckPath(m1, n1, m2, n2, spots);
                }
                return is;
            }
            case "P" -> {
                is = Pawn.isValid(m1, n1, m2, n2, pack);
                if (is) {
                    is = Pawn.CheckPath(m1, n1, m2, n2, spots, pack);
                }
                return is;
            }
            case "K" -> {
                is = King.isValid(m1, n1, m2, n2);
                if (is) {
                    is = King.CheckPath(m1, n1, m2, n2, spots, pack);
                }
                return is;
            }
            default -> is = false;
        }
        return is;
    }

    public static void Remover(JButton move1, JButton move2, Pieces[][] p, int m1, int n1, int m2, int n2){
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
        return;
    }
}
