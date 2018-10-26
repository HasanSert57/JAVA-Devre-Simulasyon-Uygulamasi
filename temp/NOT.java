import java.awt.*;

class NOT extends Gate
{
    private Device inRef,outRef;
    private int in=0,out=0;
    private boolean flag;
    
    public NOT()
    {
        super(1,1,0,0);
    }
    
    public NOT(int locationX, int locationY)
    {
        super(1,1,locationX,locationY);
    }
    
    public void Draw(Graphics g)
    {
        g.drawLine(this.getX(),this.getY(),this.getX()+20,this.getY()+10);
        g.drawLine(this.getX(),this.getY()+20,this.getX()+20,this.getY()+10);
        g.drawLine(this.getX(),this.getY(),this.getX(),this.getY()+20);
        g.drawOval(this.getX()+20,this.getY()+7,5,5);
        g.drawLine(this.getX()-10,this.getY()+10,this.getX(),this.getY()+10);
        g.drawLine(this.getX()+25,this.getY()+10,this.getX()+35,this.getY()+10);
        this.setLegLoaction(1);
    }
    
    public Device isOnInLeg(int x,int y)
    {
        if((x >= getX()-10 && x <= getX()) && y == getY()+10)
        {
            return this;
        }
        return null;
    }

    public Device isOnOutLeg(int x,int y)
    {
        if((x >= getX()+25 && x <= getX()+35) && y == getY()+10)
        {
            return this;
        }
        return null;
    }
    
    public Device isOnDevice(int x,int y)
    {
        if((x >= getX() && x <= getX()+20) && (y >= getY() && y <= getY()+20))
        {
            return this;
        }
        return null;
    }
    
    public void setInRef(Device dref)
    {
        this.inRef = dref;
    }
    public void removeInRef(int i)
    {
        this.inRef = null;
    }
    public Device getInRef(int index)
    {
        return this.inRef; 
    }
    public void setOutRef(Device dref)
    {
        this.outRef = dref;
    }
    public Device getOutRef()
    {
        return this.outRef; 
    }
    public void setInput(int val)
    {
        this.in = this.inRef.getOutput();
    }
    public int getInput(int index)
    {
        return this.in;
    }
    public int getOutput()
    {
        return this.out;
    }
    public void generateOutput()
    {
        this.out = (this.in == 1) ? 0 : 1; 
    }
    public void setFlag(boolean b)
    {
    	this.flag = b;
    }
    public boolean getFlag()
    {
    	return this.flag;
    }
}
