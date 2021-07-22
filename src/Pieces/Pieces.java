package Pieces;

import javax.swing.JButton;
public class Pieces{
    public enum Type {R,H,B,K,Q,P}

    public boolean alive = true;
    public boolean white = false;
    public boolean FirstMove = true;
    public int mx;
    public int my;
    public Type types = null;

    public String getType (){ return this.types.name();}
    public void setType(String ty){ this.types = Type.valueOf(ty);}

    public JButton button=new JButton();

    public boolean isWhite(){return this.white;}
    public void setWhite(boolean wh){this.white=wh;}

    public void Killed(){this.alive=false;}

    public void setX(int x){this.mx=x;}
    public void setY(int y){this.my=y;}

    public void setButton(JButton b){ this.button=b;}
    public void FirstMove(){this.FirstMove=false;}

} // close pieces