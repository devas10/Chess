package Pieces;
import javax.swing.JButton;

public class Player {

    public boolean white = false;
    Pieces[] playerset = new Pieces[16];
    public JButton[] pack = new JButton[16];

    public void white() {
        this.white = true;
    }

    void changePlayer(Player[] player, Player current) {
        if (current == player[0]) {
            current = player[1];
        } else {
            current = player[0];
        }
    }

}
