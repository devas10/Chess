package Type;

import javax.swing.JButton;

public class Bishop {
    public static Boolean isValid(int start1,int end1,int start2,int end2){
        return (Math.abs(start2 - start1)) == (Math.abs(end1 - end2));
    }
    public static Boolean CheckPath(int start1,int end1,int start2,int end2,JButton [][] pack){

        int opp1 = ((start2 - start1) > 0) ? 1 : -1;
        int opp2 = ((end2 - end1) > 0) ? 1 : -1;

        int s = start1 + opp1;
        int e = end1 + opp2;

        while((s!=start2)&&(e!=end2)){
            try{
                if(pack[s][e].getComponent(0)!=null){
                    return false;
                }
            }catch(Exception Ex) {
                Ex.printStackTrace();
            }
            s+= opp1;
            e+= opp2;

        }
        return true;
    }
}