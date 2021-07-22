package Type;

import Pieces.Pieces;

import javax.swing.*;

public class King {

    public static boolean isValid(int start1, int end1, int start2, int end2) {
       return (Math.abs(start1-start2)==1||Math.abs(end1-end2)==1);
    }

    public static boolean CheckPath(int start1, int end1, int start2, int end2, JButton[][] spots, Pieces[][] pack) {
        return (Math.abs(start1-start2)==1||Math.abs(end1-end2)==1);
    }
}
