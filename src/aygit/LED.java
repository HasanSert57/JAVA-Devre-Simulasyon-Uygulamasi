
package aygit;

import Simulasyon.Koordinat;
import Simulasyon.ModEnum;
import Simulasyon.MainFrame;
import Simulasyon.AygitEnum;
import java.awt.*;

public class LED extends Kapi {

    public LED() {
        super(1, AygitEnum.led, new Koordinat(0,0));
    }
    public LED(Koordinat location) {
        super(1, AygitEnum.led, new Koordinat(location.x-10,location.y-10));
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(x,y+20,20,10);
        if ( this.selected )    g.setColor(Color.blue);
        g.setColor(c);
        g.drawRect(x,y+20,20,10);
        this.setInLeg(new Koordinat(x+10,y+40),0);
        if ( getGiris(0) && MainFrame.mode == ModEnum.run )  {
            g.setColor(Color.blue);
            g.drawLine(x+10,y+30,x+10,y+40);
            g.fillArc(x+3,y,14,40,0,180);
            g.fillOval(x+8, y+38, 4, 4);
        }
        else    {
            g.fillOval(x+8, y+38, 4, 4);
            g.drawLine(x+10,y+30,x+10,y+40);
        }
           
        g.setColor(c);
        g.drawArc(x+3, y, 14, 40, 0, 180);
        
    }

    @Override
    public void setKonum(Koordinat cd) {
        super.setKonum(new Koordinat(cd.x-10,cd.y-10)); 
    }
    
    @Override
    public int isOnInLeg(Koordinat c) {
        return super.isOnInLeg(c); 
    }

    @Override
    public boolean isOnOutLeg(Koordinat c) {
        return false;
    }

    @Override
    public int isOnInLeg(int x, int y) {
        return super.isOnInLeg(x, y); 
    }

    @Override
    public boolean isOnOutLeg(int x, int y) {
        return super.isOnOutLeg(x, y); 
    }

    @Override
    public boolean isOnAygit(int x, int y) {
        if ( x >= this.getX() && x <= this.getX()+20 )  {
            if ( y >= this.getY() && y <= this.getY()+40 )  {
                return true;
            }
        }
        else if ( x == this.getX()+10 && y >= this.getY()+40 && y <= this.getY()+10 )  return true;
        return false;
    }

    @Override
    public void removeInRef(int index) {
        super.removeInRef(index); 
    }

    @Override
    public boolean getFlag() {
        return super.getFlag(); 
    }

    @Override
    public void setBayrak(boolean b) {
        super.setBayrak(b); 
    }

    @Override
    public void generateOutput() {
        super.generateOutput(); 
    }
    
    
}
