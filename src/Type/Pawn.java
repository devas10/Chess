package Type;
import javax.swing.JButton;

import Pieces.Pieces;
import Board.takePiece;

public class Pawn {
    public static Boolean isValid(int start1, int end1, int start2, int end2, Pieces[][] pie){

        int Direction = ((start2 - start1) >= 0)? 1 : -1;   //white : -1  ::  black : 1

        if(Direction == -1 && !pie[start1][end1].isWhite()) return false;
        else if(Direction == 1 && pie[start1][end1].isWhite()) return false;

        if ((Math.abs(start2-start1)==1)&&(Math.abs(end2-end1)==1)) return true;
        if(pie[start2][end2] != null) return false;
        if ((Math.abs(start2-start1)==1)&&(Math.abs(end2-end1)==0)) return true;

        else if ((Math.abs(start2-start1)==2)&&(Math.abs(end2-end1)==0)){
            if(Direction==-1) return pie[start1-1][end1]==null && pie[start1][end1].FirstMove;
            else if(Direction==1) return pie[start1+1][end1]==null && pie[start1][end1].FirstMove;
        }

        return false;
    }
    public static Boolean CheckPath(int start1,int end1,int start2,int end2,JButton [][] pack, Pieces [][] pie){

        //  int opp2 = ((end2 - end1) >= 0) ? 1 : -1;

        if ((Math.abs(start2-start1)==1)&&(Math.abs(end2-end1)==1)){
            if(pie[start2][end2]!=null) {

                if(start2 == 7 || start2==0){ new takePiece().initialize(pie[start1][end1].isWhite(),start2,end2,pack,pie);}
                return true;
            }
            return false;
        }

        if(start2 == 7 || start2==0){ new takePiece().initialize(pie[start1][end1].isWhite(),start2,end2,pack,pie);}
        if(pie[start1][end1].FirstMove) pie[start1][end1].FirstMove();
        return true;
    }
}


