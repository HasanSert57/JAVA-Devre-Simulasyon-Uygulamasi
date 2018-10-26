import java.awt.*;

class NAND extends Gate
{
    private Device outRef,inRef[];
    private int iCount;
    private int in[],out=0;
    private boolean flag;
    
    public NAND(int inputCount)
    {
        super(inputCount,7,0,0);
        this.iCount = 0;
        inRef = new Device[inputCount];
        in = new int[inputCount];
        
        for(int count = 0; count < inputCount; count++)
        {
            inRef[count] = null;
            in[count] = 0;
        }
    }
    public NAND(int inputCount,int locationX, int locationY)
    {
        super(inputCount,7,locationX,locationY);
        this.iCount = 0;
        inRef = new Device[inputCount];
        in = new int[inputCount];
        
        for(int count = 0; count < inputCount; count++)
        {
            inRef[count] = null;
            in[count] = 0;
        }
    }
    
    public void Draw(Graphics g)
    {
        g.drawArc(this.getX(),this.getY(),80,40,0,-90);
        g.drawArc(this.getX(),this.getY(),80,40,0,90);
        g.drawLine(this.getX()+40,this.getY(),this.getX()+40,this.getY()+40);
        g.drawOval(this.getX()+80,this.getY()+17,6,6);
        g.drawLine(this.getX()+86,this.getY()+20,this.getX()+100,this.getY()+20);
        
        int i = this.getInputCount();
        
        if(i == 2)
        {
            g.drawLine(this.getX()+20,this.getY()+10,this.getX()+40,this.getY()+10);
            g.drawLine(this.getX()+20,this.getY()+30,this.getX()+40,this.getY()+30);
        }
        
        else if(i == 3)
        {
            g.drawLine(this.getX()+20,this.getY()+10,this.getX()+40,this.getY()+10);
            g.drawLine(this.getX()+20,this.getY()+20,this.getX()+40,this.getY()+20);
            g.drawLine(this.getX()+20,this.getY()+30,this.getX()+40,this.getY()+30);
        }
        
        else if(i == 4)
        {
            g.drawLine(this.getX()+20,this.getY()+9,this.getX()+40,this.getY()+9);
            g.drawLine(this.getX()+20,this.getY()+16,this.getX()+40,this.getY()+16);
            g.drawLine(this.getX()+20,this.getY()+24,this.getX()+40,this.getY()+24);
            g.drawLine(this.getX()+20,this.getY()+31,this.getX()+40,this.getY()+31);
        }
        this.setLegLoaction(2);
    }
    public Device isOnInLeg(int x,int y)
    {   
        int i = this.getInputCount();
        
        if(x >= getX()+20 && x <= getX()+40)
        {
            if(i == 2)
            {
                if(y == getY()+10 || y == getY()+30)
                    return this;
            }

            else if(i == 3)
            {
                if(y == getY()+10 || y == getY()+20 || y == getY()+30)
                    return this;
            }

            else if(i == 4)
            {
                if(y == getY()+9 || y == getY()+16 || y == getY()+24 || y == getY()+31)
                    return this;
            }
        }
        return null;
    }
    
    public Device isOnOutLeg(int x,int y)
    {   
        if((x >= getX()+86 && x <= getX()+100)&&y == getY()+20)
            return this;
        return null;
    }
    
    public Device isOnDevice(int x,int y)
    {
        if((x >= getX()+40 && x <= getX()+80) && (y >= getY() && y <= getY()+40))
        {
            return this;
        }
        return null;
    }
    
    public void setInRef(Device d)
    {
        if(iCount < this.getInputCount())
            this.inRef[iCount++] = d;
    }
    public void removeInRef(int i)
    {
        Device temp = this.inRef[i];
        this.inRef[i] = this.inRef[--iCount];
        this.inRef[iCount] = null;
    }
    public Device getInRef(int index)
    {
        return this.inRef[index];
    }
    
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
        for(int count = 0;count < this.getInputCount();count++)
        {
            this.in[count] = this.inRef[count].getOutput();
        }
    }
    public int getInput(int index)
    {
        return this.in[index];
    }
    public int getOutput()
    {
        return this.out;
    }
    public void generateOutput()
    {
        int count = 0;
        for(count=0; count < this.getInputCount(); count++)
        {
            if(this.in[count] == 0)
            {
                this.out = 1;
                break;
            }
        }
        if(count == this.getInputCount())
            this.out = 0;
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