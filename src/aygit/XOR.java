
package aygit;

import Simulasyon.Koordinat;
import Simulasyon.ModEnum;
import Simulasyon.MainFrame;
import Simulasyon.AygitEnum;
import java.awt.*;

public class XOR extends Kapi    {

    public XOR(int inputCount) {
        super(inputCount, AygitEnum.xor, new Koordinat(0,0));
    }
    
    public XOR(int inputCount, Koordinat location) {
        super(inputCount, AygitEnum.xor, new Koordinat (location.x-80, location.y-30) );
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        
        g.drawArc(x,y+5,100,50,0,-90);
        g.drawArc(x,y+5,100,50,0,90);
        g.drawArc(x+40,y+5,20,50,0,-90);
        g.drawArc(x+40,y+5,20,50,0,90);
        g.drawArc(x+30,y+5,20,50,0,-90);
        g.drawArc(x+30,y+5,20,50,0,90);
        g.fillOval(x+98,y+28,4,4);
        this.setOutLeg(new Koordinat(x+100,y+30));
        int i = this.getGirisSayisi();
        
        if(i == 2)
        {
            if ( this.getGiris(0) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+19, 10, 2);
            g.fillOval(x+40, y+18, 4, 4);
            this.setInLeg(new Koordinat(x+40,y+20), 0);
            
            if ( this.getGiris(1) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+39, 10, 2);
            g.fillOval(x+40, y+38, 4, 4);
            this.setInLeg(new Koordinat(x+40,y+40), 1);
        }
        
        else if(i == 3) {
            if ( this.getGiris(0) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+19, 10, 2);
            g.fillOval(x+40, y+18, 4, 4);
            this.setInLeg(new Koordinat(x+40,y+20), 0);
            
            
            if ( this.getGiris(1) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+29, 10, 2);
            g.fillOval(x+40, y+28, 4, 4);
            this.setInLeg(new Koordinat(x+40,y+30), 1);
            
            if ( this.getGiris(2) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+39, 10, 2);
            g.fillOval(x+40, y+38, 4, 4);
            this.setInLeg(new Koordinat(x+40,y+40), 2);
        }
    }

    @Override
    public void setKonum(Koordinat cd) {
        super.setKonum(new Koordinat(cd.x-80, cd.y-30));
        System.out.println("XOR location: "+this.getLocation());
    }

    @Override
    public boolean isOnAygit(int x, int y) {
        if ( x >= this.getX()+40 && x <= this.getX()+100 )  {
            if ( y >= this.getY() && y <= this.getY()+60 )  return true;
        }
        return false;
    }

    @Override
    public void generateOutput() {
        int freq = 0, l = getGirisSayisi();
        for ( int i = 0; i < l; i++ )   {
            if ( getGiris(i) )  {
                freq++;
            }
        }
        if ( freq != 1 )    this.output = false;
        else    this.output = true;
        
        l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
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
    
}
