
package aygit;

import Simulasyon.Koordinat;
import Simulasyon.AygitEnum;
import Simulasyon.MainFrame;
import Simulasyon.ModEnum;
import java.awt.Color;
import java.awt.Graphics;


public class Source extends Kapi  {

    boolean flag;
    
    public Source(int locationX, int locationY) {
        super(0, AygitEnum.source, new Koordinat(locationX-10, locationY-10));
        flag = false;
    }

    public Source(Koordinat location) {
        super(0, AygitEnum.source, new Koordinat(location.x-10,location.y-10));
        flag = false;
    }
    
    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        Color c= g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawRect(x,y,20,20);
        String s = "0";
        if ( this.getOutput() && MainFrame.mode == ModEnum.run )   {
            s = "1";
            g.setColor(Color.red);
        }
        g.fillOval(x+2,y+2,16,16);
        g.drawLine(x+20,y+10,x+30,y+10);
        g.fillOval(x+28, y+8, 4, 4);
        g.setColor(Color.white);
        g.drawString(s,x+7, y+16);
        g.setColor(c);
        this.setOutLeg(new Koordinat(x+30,y+10));
    }

    @Override
    public boolean isOnOutLeg(Koordinat c) {
        return super.isOnOutLeg(c); 
    }
    
    @Override
    public int isOnInLeg(int x, int y) {
        return -1;
    }


    @Override
    public boolean isOnAygit(int x, int y) {
        if ( x >= this.getX() && x <= this.getX()+20 )  {
            if ( y >= this.getY() && y <= this.getY()+20 )
                return true;
        }
        else if ( x == this.getX()+30 && y >= this.getY() && y <= this.getY()+10 )  return true;
        return false;
    }

    @Override
    public void removeInRef(int index) {
        
    }

    public void toggleOutput() {
        setOutput(!this.getOutput());
    }

    @Override
    public void generateOutput() {
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }
    
}
