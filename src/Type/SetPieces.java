package Type;

import java.nio.charset.StandardCharsets;

public class SetPieces {
    public static String[] pieces;  //peices arrranged in order

    static {
        pieces = new String[]{ "\u265C", "\u265E", "\u265D", "\u265A", "\u265B", "\u265D", "\u265E", "\u265C",
                               "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F",
                               "\u2659", "\u2659", "\u2659", "\u2659", "\u2659", "\u2659", "\u2659", "\u2659",
                               "\u2656", "\u2658", "\u2657", "\u2654", "\u2655", "\u2657", "\u2658", "\u2656"};
 //       pieces = new String(piece,StandardCharsets.UTF_16);
    }

    public static String [] type = {"R","H","B","Q","K","B","H","R",
                                    "P","P","P","P","P","P","P","P",
                                    "P","P","P","P","P","P","P","P",
                                    "R","H","B","Q","K","B","H","R"};
}
