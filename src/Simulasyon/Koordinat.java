
package Simulasyon;

import java.awt.event.MouseEvent;
import java.io.Serializable;


public class Koordinat implements Serializable{

    public int x, y;

    public Koordinat() {
        x = 0;
        y = 0;
    }

    public Koordinat(int x, int y) {
        this.x = x - x % DevrePanel.distance;
        this.y = y - y % DevrePanel.distance;
    }

    public Koordinat(MouseEvent evt) {
        if ( evt == null )  {
            x = 0;
            y = 0;
        }
        else    {
            x = evt.getX() - evt.getX() % DevrePanel.distance;
            y = evt.getY() - evt.getY() % DevrePanel.distance;
        }
    }
    
    public Koordinat(Koordinat coord) {
        if ( coord == null )    {
            x = 0;
            y = 0;
        }
        else    {
            x = coord.x;
            y = coord.y;
        }
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
    
    
}