package Type;

import javax.swing.JButton;

public class Queen {
    public static char isValid(int start1,int end1,int start2,int end2){
        if(Rook.isValid(start1,end1,start2,end2)) return 'R';
        if(Bishop.isValid(start1, end1, start2, end2)) return 'B';
        return 0;
    }
    public static Boolean CheckPath(int start1,int end1,int start2,int end2,JButton [][] pack,char type){
        if(type=='R' && Rook.CheckPath(start1,end1,start2,end2,pack)) return true;
        else if (type=='B' && Bishop.CheckPath(start1, end1, start2, end2, pack)) return true;
        return false;
    }
}
