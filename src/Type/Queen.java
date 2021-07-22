package Type;

import javax.swing.JButton;

public class Queen {
    public static Boolean isValid(int start1,int end1,int start2,int end2){
        if ((Math.abs(start2-start1))==(Math.abs(end1-end2))){
            return true;
        }
        return Math.abs((start1 - start2) * (end1 - end2)) == 0;
    }
    public static Boolean CheckPath(int start1,int end1,int start2,int end2,JButton [][] pack){
        if(Rook.CheckPath(start1,end1,start2,end2,pack)){
            return true;
        }
        return Bishop.CheckPath(start1, end1, start2, end2, pack);
    }
}
