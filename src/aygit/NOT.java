
package aygit;

import Simulasyon.Koordinat;
import Simulasyon.ModEnum;
import Simulasyon.MainFrame;
import Simulasyon.AygitEnum;
import java.awt.*;

public class NOT extends Kapi {

    public NOT(int inputCount) {
        super(inputCount, AygitEnum.not, new Koordinat(0,0));
    }
    public NOT(int inputCount, Koordinat location) {
        super(inputCount, AygitEnum.not, new Koordinat(location.x-10, location.y-15));
        System.err.println("Coordinate: "+(location.x-10)+" "+(location.y-15));
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawLine(x, y+5, x, y+35);
        g.drawLine(x, y+5, x+20, y+20);
        g.drawLine(x+20, y+20, x, y+35);
        g.drawOval(x+20, y+16, 8, 8);
        
        if ( this.getGiris(0) && MainFrame.mode == ModEnum.run )  g.setColor(Color.red);
        else    g.setColor(c);
        g.fillOval(x-2,y+18,4,4);
        this.setInLeg(new Koordinat(x,y+20),0);
        
        if ( this.getOutput() && MainFrame.mode == ModEnum.run )  g.setColor(Color.red);
        else    g.setColor(c);
        g.fillOval(x+28,y+18,4,4);
        this.setOutLeg(new Koordinat(x+30,y+20));
    }

    @Override
    public void setKonum(Koordinat cd) {
        cd.x-= 10;
        cd.y-= 15;
        cd = new Koordinat(cd.x,cd.y);
        System.err.println("Coordinate: "+(cd.x)+" "+(cd.y));
        super.setKonum(cd);
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
        return (x >= this.getX() && x <= this.getX()+30 && y >= this.getY()+10 && y <= this.getY()+20);

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
        this.output = !this.input[0];
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }
    
    
}
