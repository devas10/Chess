package Board;

import Pieces.Pieces;
import Board.Move;

import javax.swing.*;

public class Check {

    static Boolean Check(Pieces[][] set, JButton[][] pack, int x, int y, boolean white){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
               if(set[j][i].isWhite() == white){ return Move.Mover(i,j,x,y,set,pack); }
            }
        }
        return false;
    }

    public static Boolean Checker(Pieces[][] set, JButton[][] pack, boolean white){
       int x=0,y=0;
       breaker1:
       for(x=0;x<8;x++){ for(y=0;y<8;y++){ if(set[x][y].isWhite()==white && set[x][y].getType()=="K") break breaker1; } }
       return Check(set,pack,x,y,white);
    }
}
