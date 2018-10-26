package aygit;

import Simulasyon.Koordinat;
import Simulasyon.ModEnum;
import Simulasyon.MainFrame;
import Simulasyon.AygitEnum;
import java.awt.*;

public class AND extends Kapi
{
    private boolean bayrak;
    
    public AND(int girisSayisi)
    {
        super(girisSayisi, AygitEnum.and,new Koordinat(0,0)); // and kapısının kaç girişli oldugunu gösterir.
    }
    
    public AND(int girisSayisi,Koordinat konum){
        super(girisSayisi,AygitEnum.and, new Koordinat(konum.x-20,konum.y-30)); //koordinat tutuluyor
    }
    
    @Override
    public void draw(Graphics g)
    {
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawArc(x,y+5,50,50,0,-90);    
        g.drawArc(x,y+5,50,50,0,90);
        g.drawLine(x,y+5,x+25,y+5);                 //And kapısının şekli çiziliyor
        g.drawLine(x,y+55,x+25,y+55);
        g.drawLine(x,y+5,x,y+55);
        
        if ( this.getOutput()  && MainFrame.mode == ModEnum.run ) g.setColor(Color.red); //Program çalışıyorsa ve çıkış üzerindeyse kırmızı yapar..
        g.fillOval(x+48,y+28,4,4);
        this.setOutLeg(new Koordinat(x+50,y+30));
        g.setColor(c);
        
        int i = this.getGirisSayisi();
        
        if(i == 2)   // 2 girişli ise
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
        
        else if(i == 3) // 3 girişli ise
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
    public int isOnInLeg(int x, int y)  {   // Giris bacagı kordinatı ..
        return super.isOnInLeg(x, y);
    }
    
    @Override
    public boolean isOnOutLeg(int x,int y)  { // Çıkış bacagında mı ..
        return super.isOnOutLeg(x, y);
    }
    
    @Override
    public boolean isOnAygit(int x,int y)  {  // Aygıtın üstünde mi 
        int lx = this.getX(), ly = this.getY();
        return (lx <= x && x <= lx+50 && ly+5 <= y && y <= ly+55);
    }
    

    @Override
    public void removeInRef(int i)  {
        super.removeInRef(i);
    }

    @Override
    public void generateOutput()    {
        int count = 0;
        for(count=0; count < this.girisSayisi; count++)
        {
            if(!this.input[count])
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

    @Override
    public void setBayrak(boolean b)  {
    	this.bayrak = b;
    }
  
    @Override
    public boolean getFlag()
    {
    	return this.bayrak;
    }    
}
