
package aygit;

import Simulasyon.Koordinat;
import Simulasyon.ModEnum;
import Simulasyon.MainFrame;
import Simulasyon.AygitEnum;
import java.awt.*;

public class OR extends Kapi    {

    public OR(int inputCount) {
        super(inputCount, AygitEnum.or, new Koordinat(0,0));
    }
    
    public OR(int inputCount, Koordinat location) {
        super(inputCount, AygitEnum.or, new Koordinat(location.x-80,location.y-30));
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawArc(x,y+5,100,50,0,-90);
        g.drawArc(x,y+5,100,50,0,90);                           // OR Kapısı çiziliyor .
        g.drawArc(x+40,y+5,20,50,0,-90);
        g.drawArc(x+40,y+5,20,50,0,90);
        
        if ( this.getOutput()&& MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
        else    g.setColor(c);
        g.fillOval(x+98,y+28,4,4);
        this.setOutLeg(new Koordinat(x+100,y+30));
        
        int i = this.getGirisSayisi();
        
        if(i == 2)   //2 girisli or
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
        
        else if(i == 3) //3 girisli or 
        {
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
        super.setKonum(new Koordinat(cd.x-80, cd.y-30)); 
        Koordinat c = new Koordinat(cd.x-80, cd.y-30);
    }

    
    @Override
    public int isOnInLeg(Koordinat c) {
        return super.isOnInLeg(c); 
    }

    @Override
    public boolean isOnOutLeg(Koordinat c) {
        return super.isOnOutLeg(c);
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
        if ( x >= this.getX()+50 && x <= this.getX()+100)   {
            if ( y >= this.getY() && y <= this.getY()+60 )
                return true;
        }
        return super.isOnAygit(x, y); 
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
                this.output = true;
                break;
            }
        }
        if(count == this.girisSayisi)
            this.output = false;
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }

    
}
