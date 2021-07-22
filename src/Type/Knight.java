package Type;

public class Knight {
    public static Boolean isValid(int start1,int end1,int start2,int end2){
        return Math.abs((start1 - start2) * (end1 - end2)) == 2;
    }
}
