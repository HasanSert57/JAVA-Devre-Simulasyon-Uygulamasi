
package Simulasyon;

import aygit.NAND;
import aygit.Tel;
import aygit.NOR;
import aygit.Source;
import aygit.LED;
import aygit.NOT;
import aygit.XOR;
import aygit.AND;
import aygit.DevreCihazi;
import aygit.OR;
import static Simulasyon.AygitEnum.not;
import java.io.Serializable;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Devre implements Serializable{
    
    public boolean pointFlag;
    public ArrayList<DevreCihazi> device;
    public ArrayList<Source> source;
    public DevreCihazi temp;
    public Source tempSource;
    public ArrayList<Tel> wire;
    public int countD, countS, countW; 
    public Koordinat start, end;
    
    public Devre() {

        device = new ArrayList<DevreCihazi> ();
        source = new ArrayList<Source>();
        wire = new ArrayList<Tel>();
        countD = 0;
        countS = 0;
        countW = 0;
    }
    
    public Devre ( Devre ckt )  {
        this.device = ckt.device;
        this.source = ckt.source;

        this.countD = ckt.countD;
        this.countS = ckt.countS;
        this.countW = ckt.countW;
    }
    public void drawCircuit ( Graphics g)   {
        countD = device.size();
        for ( int i = 0; i < countD; i++ )  {
            g.setColor(Color.BLACK);
            device.get(i).draw(g);
        }

        countS = source.size();
        for ( int i = 0; i < countS; i++ )  {
            g.setColor(Color.BLACK);
            source.get(i).draw(g);
        }
        
        countW = wire.size();
        for ( int i = 0; i < countW; i++ )  {
            g.setColor(Color.BLACK);
            wire.get(i).draw(g);
        }
        g.setColor(Color.BLUE);
        drawTempWire(g);
    }
    
    public boolean addWire (Koordinat startingPoint, DevreCihazi startDevice, Koordinat endingPoint, DevreCihazi endingDevice )   {
        if ( startDevice == null || endingDevice == null )  {
            JOptionPane.showMessageDialog(null, "Geçersiz Bağlantı.");
            return false;
        }
        if ( startDevice.isOnOutLeg(startingPoint) )    {
            if ( endingDevice.isOnOutLeg(endingPoint) ) {
                JOptionPane.showMessageDialog(null, "Devredeki giriş bağlantılarını kontrol ediniz.");
                start = null;
                end = null;
                return false;
            }
            else    {
                int indx = endingDevice.isOnInLeg(endingPoint);
                if (indx < -1)  {
                    JOptionPane.showMessageDialog(null, "Invalid connection.");
                    return false;
                }
                if ( endingDevice.setInRef(indx, startDevice) == false )    {
                    JOptionPane.showMessageDialog(null," Cihazda zaten bir giriş var");
                    return false;
                }
                startDevice.addOutRef(endingDevice);
                wire.add(new Tel(startingPoint, endingPoint, startDevice, endingDevice));
                System.out.println("Tel boş değil: "+(wire.get(0) != null));
            }
        }
        else if ( endingDevice.isOnOutLeg(endingPoint) )    {
            if ( startDevice.isOnOutLeg(startingPoint) ) {
                JOptionPane.showMessageDialog(null, "Devredeki giriş bağlantılarını kontrol ediniz.");
                start = null;
                end = null;
                return false;
            }
            else    {
                int indx = startDevice.isOnInLeg(startingPoint);
                if (indx < -1)  {
                    JOptionPane.showMessageDialog(null, "Geçersiz bağlantı.");
                    return false;
                }
                if ( startDevice.setInRef(indx, endingDevice) == false )    {
                    JOptionPane.showMessageDialog(null, " Cihazda zaten bir giriş var");
                    return false;
                }
                endingDevice.addOutRef(startDevice);
                wire.add(new Tel(endingPoint, startingPoint, endingDevice, startDevice));
                System.out.println("Tel boş değil "+(wire.get(0) != null));
            }
        }
        return false;
    }
    
    public void drawTempWire (Graphics g) {
        try {
            int midx = (start.x+end.x)/2;
            midx = (midx+5);
            midx-= midx%10;

            g.drawLine(start.x, start.y, midx, start.y);
            g.drawLine(midx, start.y, midx, end.y);
            g.drawLine(midx, end.y, end.x, end.y);
        }   catch(Exception e)  {
        }
    }
    
    public void setTemp ( MouseEvent evt, int inputCount )   {
        try {
            Koordinat cd = new Koordinat(evt);
            switch ( MainFrame.currentDev ) {
                case and:
                    if ( temp == null || temp.getType() != AygitEnum.and ) temp = new AND(inputCount, cd);
                    else    temp.setKonum(cd);
                    break;
                case or:
                    if ( temp == null || temp.getType() != AygitEnum.or ) temp = new OR(inputCount, cd);
                    else    temp.setKonum(cd);
                    break;
                case not:
                    if ( temp == null || temp.getType() != AygitEnum.not ) temp = new NOT(inputCount, cd);
                    else    temp.setKonum(cd);
                    break;
                case xor:
                    if ( temp == null || temp.getType() != AygitEnum.xor ) temp = new XOR(inputCount, cd);
                    else    temp.setKonum(cd);
                    break;
                case nand:
                    if ( temp == null || temp.getType() != AygitEnum.nand ) temp = new NAND(inputCount, cd);
                    else    temp.setKonum(cd);
                    break;
                case nor:
                    if ( temp == null || temp.getType() != AygitEnum.not ) temp = new NOR(inputCount, cd);
                    else    temp.setKonum(cd);
                    break;
                case led:
                    if ( temp == null || temp.getType() != AygitEnum.led ) temp = new LED(cd);
                    else    temp.setKonum(cd);
                    break;
                case source:
                    temp = null;
                    setTempSource (cd);
                    break;
            }
        } catch (Exception e)   {
            System.err.println("Hata..");
            e.printStackTrace();
            temp = null;
        }
        System.gc();
    }
    
    public void setTempSource ( Koordinat cd ) {
        try {
            tempSource = new Source(cd);
        }   catch(Exception e)  {
            e.printStackTrace();
        }
    }
    
    public DevreCihazi getTemp() {
        return temp;
    }
    
    public Source getTempSource()   {
        return tempSource;
    }
    
    public void placeTemp ()    {
        try {
            if ( temp != null ) {
                device.add(temp);
                countD++;
                temp = null;
            }
            else if ( tempSource != null )  {
                source.add(tempSource);
                countS++;
                tempSource = null;
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public DevreCihazi searchForDevice (Koordinat cd)   {
        for ( int i = 0; i < countD; i++ )
            if ( device.get(i).isOnAygit(cd.x, cd.y) )
                return device.get(i);
        return searchForSource(cd);
    }
    
    public Source searchForSource (Koordinat cd)   {
        for ( int i = 0; i < countS; i++ )
            if ( source.get(i).isOnAygit(cd.x, cd.y))
                return source.get(i);
        return null;
    }
    
    public Tel searchForWire (Koordinat cd)   {
        
        return null;
    }
    
    public boolean isValid()    {
        countD = device.size();
        for ( int i = 0; i < countD; i++ )
            if ( !device.get(i).isValid() ) return false;
        
        return true;
    }
    
    public void clear() {    
        device = new ArrayList<DevreCihazi> ();
        source = new ArrayList<Source>();
        wire = new ArrayList<Tel>();
        countD = 0;
        countS = 0;
        countW = 0;
    }
    
    public boolean deleteDevice (DevreCihazi d)  {
        d.delete();
        if ( device.remove(d) ) {
            for ( int i = 0; i < wire.size(); i++ ) {
                Tel w = wire.get(i);
                if ( w.getInRef() == d || w.getOutRef() == d )  {
                    if ( wire.remove(i) != null )   i--;
                }
            }
            return true;
        }
        if ( !source.remove(d) )    return false;
        return true;
    }
    
    public String toString()    {
        String str = new String("");
        str+= countD + " " + device.get(0).getX()+" "+device.get(0).getY();
        return str;
    }
    
    public void copy ( Devre ckt )  {
        this.device = null;
        this.device = ckt.device;
        this.source = null;
        this.source = ckt.source;
        this.wire = null;
        this.wire = ckt.wire;

        this.countD = device.size();
        this.countS = source.size();
    }
}
