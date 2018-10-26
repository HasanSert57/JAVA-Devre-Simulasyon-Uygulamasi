import java.awt.*;

class LED extends Device
{
    private int LEDstate;
    private Device LEDin;
    private int inX,inY;
    private int in;
    private boolean flag;
    
    public LED(){
        super(1,6,0,0);
    }
    public LED(int locationX,int locationY)
    {
        super(1,6,locationX,locationY);
        this.LEDin = null;
        this.inX = locationX + 5;
        this.inY = locationY + 35;
    }
    
    public void setLegLocation(int l)
    {
        this.inX = this.getX() + 5;
        this.inY = this.getY() + 35;
    }
    
    public int getInX(int index)
    {
        return this.inX;
    }
    
    public int getInY(int index)
    {
        return this.inY;
    }
    
    public int getOutX()
    {
        return -1;
    }
    public int getOutY()
    {
        return -1;
    }
    
    public void setFlag(boolean b)
    {
    	this.flag = b;
    }
    public boolean getFlag()
    {
    	return this.flag;
    }
    public void Draw(Graphics g)
    {
        if(LEDstate==0)
        {
            g.drawOval(getX(),getY(),10,20);
        }
        else if(LEDstate == 1)
        {
            g.setColor(Color.RED);
            g.fillOval(getX(),getY(),10,25);
        }
        g.setColor(Color.GRAY);
        g.fillRect(getX()-2,getY()+15,15,10);
        g.drawLine(getX()+5,getY()+25,getX()+5,getY()+35);
    }
   
    public void setLEDstate(int i)
    {
        this.LEDstate = i;
    }
    public int getLEDstate()
    {
        return this.LEDstate; 
    }
    
    public void setInRef(Device d)
    {
        this.LEDin = d;
    }
    public void removeInRef(int i)
    {
        this.LEDin = null;
    }
    public Device getInRef(int index)
    {
        return this.LEDin; 
    }
    
    public void setOutRef(Device d){ }
    public Device getOutRef()
    {
        return null; 
    }
    
    public Device isOnInLeg(int x,int y)
    {
        if(x == getX()+5 && (y >= getY()+25 && y <= getY()+35))
        {
            return this;
        }
        return null;
    }

    public Device isOnOutLeg(int x,int y)
    {
        return null;
    }
    
    public Device isOnDevice(int x,int y)
    {
        if((x >= getX()-2 && x <= getX()+13) && (y >= getY() && y <= getY()+25))
        {
            return this;
        }
        return null;
    }
    public void setInput(int i)
    {
        this.in = this.LEDin.getOutput();
    }
    public int getInput(int index)
    {
        return this.in;
    }
    public int getOutput()
    {
        return this.LEDstate;
    }
    public void generateOutput()
    {
        this.LEDstate = this.in;
    }
}

