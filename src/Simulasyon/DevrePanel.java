
package Simulasyon;

import aygit.DevreCihazi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.JPanel;
    
public class DevrePanel extends JPanel {
    
    public static int distance;
    public Devre ckt;
    
    public DevrePanel() {
        this.setPreferredSize(new Dimension(1920,1080));
        this.distance = 10;
    }
    
    public DevrePanel(Devre ckt) {
        this.setPreferredSize(new Dimension(1920,1080));
        this.distance = 10;
        this.ckt = ckt; 
    }
    
    boolean paintPoint (Graphics g)    {    
        Color c = g.getColor();
        if ( ckt.pointFlag )    g.setColor(Color.RED);
        else    g.setColor(Color.BLUE);
        
        try {
            Koordinat cd = new Koordinat(MainFrame.mouseMove);
            g.fillRect(cd.x-3, cd.y-3, 6, 6);
            g.setColor(c);
            return true;
        }catch(Exception e) {            
            e.printStackTrace();
            g.setColor(c);
            return false;
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.DARK_GRAY);
        int height = this.getPreferredSize().height;
        int width = this.getPreferredSize().width;
        
        for ( int i = 0; i < height; i+= 20 )    {
            for ( int j = 0; j < width; j+= 20 ) {
                g.drawLine(j, i, j, i);
            }
        }
        
        g.setColor ( Color.BLACK);
        ckt.drawCircuit(g);
        
        if ( MainFrame.mode == ModEnum.drawing )   {
            if ( MainFrame.currentDev == AygitEnum.wire )  {
                paintPoint(g);
            }
            else    {
                g.setColor(Color.blue);
                paintTemp(g);
            }
        }
        

    }
    
    private boolean paintTemp(Graphics g)  {   
        
        g.setColor(Color.blue);
        try {
            if ( MainFrame.mode == ModEnum.drawing )
                if ( ckt != null )  {
                    DevreCihazi temp = ckt.getTemp();
                    
                    if ( temp != null ) {
                        temp.draw(g);
                    }
                    else if ( ckt.getTempSource() != null ) 
                        ckt.getTempSource().draw(g);
                }
            return true;
        }catch (Exception e)    {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
    }

}
