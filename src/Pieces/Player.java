package Pieces;
import javax.swing.JButton;
import java.util.ArrayList;

public class Player {

    public boolean white = false;
    ArrayList<Pieces> playerSet = new ArrayList<Pieces>();
    ArrayList<JButton> playerButton = new ArrayList<JButton>();

    public void white() {
        this.white = true;
    }
    public void addPiece(Pieces pieceToBeAdded){
        this.playerSet.add(pieceToBeAdded);
        return;
    }

    public void addButton(JButton buttonToBeAdded){
        this.playerButton.add(buttonToBeAdded);
        return;
    }

    void removeButton(JButton buttonToBeRemoved){
        this.playerButton.remove(buttonToBeRemoved);
        return;
    }

    void removePiece(Pieces pieceToBeAddedRemoved){
        this.playerSet.remove(pieceToBeAddedRemoved);
        return;
    }
    void changePlayer(Player[] player, Player current) {
        if (current == player[0]) {
            current = player[1];
        } else {
            current = player[0];
        }
    }

}
