import java.awt.*;

class Switch extends Device
{
    private int switchState=0;
    private Device outRef;
    private int outX,outY;
    private int out=0;
    private boolean flag; 
    
    public Switch()
    {
        super(0,5,0,0);
    }
    public Switch(int locationX,int locationY)
    {
        super(0,5,locationX,locationY);
        this.outRef = null;
        this.outX = locationX + 30;
        this.outY = locationY + 3;
    }
    
    public void setLegLocation(int l)
    {
        this.outX = this.getX() + 30;
        this.outY = this.getY() + 3;
    }
    
    public int getInX(int index)
    {
        return -1;
    }
    
    public int getInY(int index)
    {
        return -1;
    }
    
    public int getOutX()
    {
        return this.outX;
    }
    
    public int getOutY()
    {
        return this.outY;
    }
    public void Draw(Graphics g)
    {
        g.drawLine(getX()+6,getY()+3,getX()+10,getY()+3);
        
        if(switchState==0)
        {
            g.drawOval(getX(),getY(),6,6);
            g.drawLine(getX()+10,getY()-5,getX()+20,getY()+3);
            g.drawLine(getX()+20,getY()+3,getX()+30,getY()+3);
        }
        else if(switchState == 1)
        {
            g.setColor(Color.RED);
            g.fillOval(getX(),getY(),8,8);
            g.setColor(Color.BLUE);
            g.drawLine(getX()+10,getY()+3,getX()+30,getY()+3);
        }
    }
   
    public void setSwitchState(int i)
    {
        this.switchState = i;
    }
    public int getSwitchState()
    {
        return this.switchState; 
    }
    
    public Device isOnInLeg(int x,int y)
    {
        return null;
    }
    
    public Device isOnOutLeg(int x,int y)
    {
        if((x >= getX()+20 && x <= getX()+30) && y == getY()+3)
        {
            return this;
        }
        return null;
    }
    
    public Device isOnDevice(int x,int y)
    {
        if((x >= getX() && x <= getX()+20) && (y >= getY() && y <= getY()+3))
        {
            return this;
        }
        return null;
    }
    
    public void setInRef(Device d){}
    public void removeInRef(int i){}
    public Device getInRef(int index){return null;}
    public void setOutRef(Device d)
    {
        this.outRef = d;
    }
    public Device getOutRef()
    {
        return this.outRef; 
    }
    public void setInput(int val)
    {
        this.switchState = val;
    }
    public int getInput(int index)
    {
        return this.switchState;
    }
    public int getOutput()
    {
        return this.out;
    }
    public void generateOutput()
    {
        this.out = this.switchState;
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
