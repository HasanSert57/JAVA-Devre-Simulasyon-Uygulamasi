package aygit;

import Simulasyon.Koordinat;
import Simulasyon.ModEnum;
import Simulasyon.MainFrame;
import Simulasyon.AygitEnum;
import java.awt.*;

public class NAND extends Kapi
{
    private boolean flag;
    
    public NAND(int inputCount)
    {
        super(inputCount, AygitEnum.nand,new Koordinat(0,0));
    }
    
    public NAND(int inputCount,Koordinat location){
        super(inputCount,AygitEnum.nand, new Koordinat(location.x-20,location.y-30));
    }
    
    @Override
    public void draw(Graphics g)
    {
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        
        g.drawArc(x,y+5,50,50,0,-90);
        g.drawArc(x,y+5,50,50,0,90);
        g.drawLine(x,y+5,x+25,y+5);                 //Nand kapısı çiziliyor
        g.drawLine(x,y+55,x+25,y+55);
        g.drawLine(x,y+5,x,y+55);
        g.drawOval(x+50,y+26,8,8);
        g.fillOval(x+58,y+28,4,4);
        this.setOutLeg(new Koordinat(x+60,y+30));
        
        int i = this.getGirisSayisi();
        
        if(i == 2)
        {
            if ( this.getGiris(0) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Koordinat(x,y+20), 0);
            
            if ( this.getGiris(1) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Koordinat(x,y+40), 1);
        }
        
        else if(i == 3)
        {
            if ( this.getGiris(0) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Koordinat(x,y+20), 0);
            
            if ( this.getGiris(1) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+28, 4, 4);
            this.setInLeg(new Koordinat(x,y+30), 1);
            
            if ( this.getGiris(2) && MainFrame.mode == ModEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Koordinat(x,y+40), 2);
        }
    }
    
    @Override
    public void setKonum(Koordinat cd) {
        super.setKonum(new Koordinat(cd.x-20,cd.y-30)); 
    }
    
    @Override
    public boolean isOnAygit(int x,int y)  {
        int lx = this.getX(), ly = this.getY();
        return (lx <= x && x <= lx+60 && ly <= y && y <= ly+60);
    }
    

    @Override
    public void removeInRef(int i)  {
        DevreCihazi temp = this.inRef[i];
        this.inRef[i] = this.inRef[--iCount];
        this.inRef[iCount] = null;
    }

    @Override
    public void generateOutput()    {
        int count = 0;
        for(count=0; count < this.girisSayisi; count++)
        {
            if(this.input[count] == false)
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

    @Override
    public void setBayrak(boolean b)  {
    	this.flag = b;
    }
  
    @Override
    public boolean getFlag()
    {
    	return this.flag;
    }    
}
