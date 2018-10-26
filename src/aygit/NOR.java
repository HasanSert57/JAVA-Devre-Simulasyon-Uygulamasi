
package aygit;

import Simulasyon.Koordinat;
import Simulasyon.ModEnum;
import Simulasyon.MainFrame;
import Simulasyon.AygitEnum;
import java.awt.*;

public class NOR extends Kapi    {

    public NOR(int inputCount) {
        super(inputCount, AygitEnum.nor, new Koordinat(0,0));
    }
    
    public NOR(int inputCount, Koordinat location) {
        super(inputCount, AygitEnum.nor, new Koordinat(location.x-80,location.y-30));
        System.out.println("Building an NOR gate...");
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("Printing NOR gate.");
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        
        g.drawArc(x,y+5,100,50,0,-90);
        g.drawArc(x,y+5,100,50,0,90);
        g.drawArc(x+40,y+5,20,50,0,-90);
        g.drawArc(x+40,y+5,20,50,0,90);      
        g.drawOval(x+100, y+26, 8, 8);
        g.fillOval(x+108,y+28,4,4);
        this.setOutLeg(new Koordinat(x+110,y+30));
        int i = this.getGirisSayisi();
        
        if(i == 2)
        {
            if ( this.getGiris(0) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Koordinat(x+50,y+20), 0);
            
            if ( this.getGiris(1) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Koordinat(x+50,y+40), 1);
        }
        
        else if(i == 3) {
            if ( this.getGiris(0) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Koordinat(x+50,y+20), 0);
            
            if ( this.getGiris(1) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+29, 10, 2);
            g.fillOval(x+48, y+28, 4, 4);
            this.setInLeg(new Koordinat(x+50,y+30), 1);
            
            if ( this.getGiris(2) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Koordinat(x+50,y+40), 2);
        }
    }

    @Override
    public void setKonum(Koordinat cd) {
        new Koordinat(cd.x-80,cd.y-30);
    }
    
    @Override
    public boolean isOnAygit(int x, int y) {
        if ( x >= this.getX()+50 && x <= this.getX()+110)   {
            if ( y >= this.getY() && y <= this.getY()+60 )
                return true;
        }
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
        
        int count = 0;
        for(count=0; count < this.girisSayisi; count++)
        {
            if(this.input[count])
            {
                this.output = false;
                break;
            }
        }
        if(count == this.girisSayisi)
            this.output = true;
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }

    
}
