package aygit;

import Simulasyon.Koordinat;
import Simulasyon.AygitEnum;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class DevreCihazi implements Serializable
{
    protected int girisSayisi;
    protected Koordinat location;
    protected AygitEnum type;
    protected boolean selected;
    
    public DevreCihazi(){}
    public DevreCihazi(int inputCount,AygitEnum de,int locationX,int locationY)
    {
        this.girisSayisi = inputCount;
        this.location = new Koordinat(locationX, locationY);
        this.type = de;
    }
    public DevreCihazi(int inputCount,AygitEnum de,Koordinat location) {
        this.girisSayisi = inputCount;
        this.location = new Koordinat(location);
        this.type = de;
    }
    public void setGirisSayisi(int i)    {
        this.girisSayisi = i;
    }
 
    public void setKonum(Koordinat cd)    {
        location = cd;
    }
    
    public final Koordinat getLocation()    {
        return location;
    }
    
    public final void setX(int i)    {
        this.location.x = i;
    }
    
    public final void setY(int i)    {
        this.location.y = i;
    }
    
    public final int getGirisSayisi()    {
        return girisSayisi;
    }
    
    public final int getX()    {
        return location.x;
    }
    
    public final int getY()    {
        return location.y;
    }
    
    public boolean isSelected()    {return selected;}
    public void setSelected(boolean b)   {selected = b;}
    
    public void draw(Graphics g){}
    
    public int isOnInLeg(Koordinat c){return isOnInLeg(c.x,c.y);}
    public boolean isOnOutLeg(Koordinat c){return isOnOutLeg(c.x,c.y);}
    
    public int isOnInLeg(int x,int y)   {
        int in = this.getGirisSayisi();
        for ( int i = 0; i < in; i++ )  {
            Koordinat c = this.getInLeg(i);
            if ( c.x == x && c.y == y ) return i;
        }
        return -1;
    }
    
    
 
    public boolean isOnOutLeg(int x,int y){
        Koordinat c = this.getOutLeg();
        return ( c.x == x && c.y == y );
    }
    
  
    public boolean isOnAygit(int x,int y){return false;}
    
    public boolean setInRef(int index, DevreCihazi dref){return true;}
    public boolean delete() {return false;}
    
    public void removeInRef(int index){}
    public DevreCihazi getInRef(int index){return null;}
    public void addOutRef(DevreCihazi dref){}
    public void addOutWire(Tel w)  {}
    public boolean removeOutRef(DevreCihazi d)  {return false;}
    public boolean removeOutWire (Tel w)   {return false;}
    public ArrayList getOutRef(){return null;}
    public int getInX(int index){return -1;}
    public int getInY(int index){return -1;}
    public int getOutX(){return -1;}
    public int getOutY(){return -1;}
    public void setFlag(){};
    public boolean getFlag(){return false;}
    public void setBayrak(boolean b){}
    public final void setType(AygitEnum de)  {
        this.type = de;
    }    
    public final AygitEnum getType()    {
        return this.type;
    }
    public void setIn(int index,boolean i) {}
    public boolean getGiris(int index){return false;}
    public void generateOutput(){}
    public boolean getOutput(){return false;}
    public void setInput(){}
    public boolean isValid()    {return true;}
    public void setInLeg (Koordinat c, int i) {}
    public Koordinat getInLeg(int i) {return null;}
    public void setOutput(boolean b) {}
    public void setOutLeg (Koordinat c) {}
    public Koordinat getOutLeg() {return null;}
}
