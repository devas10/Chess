package Type;
import javax.swing.JButton;

import Pieces.Pieces;
import Board.takePiece;

public class Pawn {
    public static Boolean isValid(int start1, int end1, int start2, int end2, Pieces[][] pie){
        if ((Math.abs(start2-start1)==1)&&(Math.abs(end2-end1)==1)){
            return true;
        }
        if ((Math.abs(start2-start1)==1)&&(Math.abs(end2-end1)==0)){
            return true;
        }
        else if ((Math.abs(start2-start1)==2)&&(Math.abs(end2-end1)==0)){

            return pie[start1][end1].FirstMove;
        }
        return false;
    }
    public static Boolean CheckPath(int start1,int end1,int start2,int end2,JButton [][] pack, Pieces [][] pie){

        int opp1 = ((start2 - start1) >= 0) ? 1 : -1;
        //  int opp2 = ((end2 - end1) >= 0) ? 1 : -1;

        if ((Math.abs(start2-start1)==1)&&(Math.abs(end2-end1)==1)){
            if(pie[start2][end2]== null){
                return false;
            }
        }
        else{
            if(pie[start2][end2] != null){
                return false;
            }
        }

        if(pie[start1][end1].isWhite()){
            System.out.println(pie[start1][end1].isWhite());
            if(opp1 == -1){
                if(!pie[start1][end1].FirstMove) pie[start1][end1].FirstMove();
                if(start2 == 0){
                    takePiece takePieceClass = new takePiece();
                    takePieceClass.initialize(true);}
                return true;}
        }
        else{
            if(opp1 == 1){
                if(start2 == 7){
                    takePiece takePieceClass = new takePiece();
                    takePieceClass.initialize(false);}
                if(!pie[start1][end1].FirstMove) pie[start1][end1].FirstMove();
                return true;}
            //   else if(opp2 == 1){return true;}
        }
        return false;
    }
}
