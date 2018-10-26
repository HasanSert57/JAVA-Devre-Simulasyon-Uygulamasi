import java.awt.*;

class XNOR extends Gate
{
    private Device outRef, inRef[];
    private int iCount;
    private int in[],out = 0; 
    private boolean flag;
    
    public XNOR(int inputCount)
    {
        super(inputCount,9,0,0);
        this.iCount = 0;
        this.inRef = new Device[inputCount];
        this.in = new int[inputCount];
        
        for(int count = 0; count < inputCount; count++)
        {
            this.inRef[count] = null;
            this.in[count] = 0;
        }
    }
    public XNOR(int inputCount, int locationX, int locationY)
    {
        super(inputCount,9,locationX,locationY);
        this.iCount = 0;
        this.inRef = new Device[inputCount];
        this.in  =  new int[inputCount];
        
        for(int count = 0; count < inputCount; count++)
        {
            this.inRef[count] = null;
            this.in[count] = 0;
        }
    }
    
    public void Draw(Graphics g)
    {
        g.drawArc(this.getX(),this.getY(),80,40,0,-90);
        g.drawArc(this.getX(),this.getY(),80,40,0,90);
        g.drawArc(this.getX()+20,this.getY(),30,40,0,-90);
        g.drawArc(this.getX()+20,this.getY(),30,40,0,90);
        g.drawArc(this.getX()+15,this.getY(),30,40,0,-90);
        g.drawArc(this.getX()+15,this.getY(),30,40,0,90);
        g.drawOval(this.getX()+80,this.getY()+17,6,6);
        g.drawLine(this.getX()+86,this.getY()+20,this.getX()+100,this.getY()+20);
        
        int i = this.getInputCount();
        
        if(i == 2)
        {
            g.drawLine(this.getX()+25,this.getY()+10,this.getX()+47,this.getY()+10);
            g.drawLine(this.getX()+25,this.getY()+30,this.getX()+47,this.getY()+30);
        }
        
        else if(i == 3)
        {
            g.drawLine(this.getX()+25,this.getY()+10,this.getX()+47,this.getY()+10);
            g.drawLine(this.getX()+25,this.getY()+20,this.getX()+49,this.getY()+20);
            g.drawLine(this.getX()+25,this.getY()+30,this.getX()+47,this.getY()+30);
        }
        
        else if(i == 4)
        {
            g.drawLine(this.getX()+25,this.getY()+9,this.getX()+47,this.getY()+9);
            g.drawLine(this.getX()+25,this.getY()+16,this.getX()+49,this.getY()+16);
            g.drawLine(this.getX()+25,this.getY()+24,this.getX()+49,this.getY()+24);
            g.drawLine(this.getX()+25,this.getY()+31,this.getX()+47,this.getY()+31);
        }
        this.setLegLoaction(4);
    }
    
    public Device isOnInLeg(int x,int y)
    {   
        int i = this.getInputCount();
        
        if(x >= getX()+25 && x <= getX()+49)
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
        //System.out.println("indexToDelete: " + i);
        //System.out.println("iCountBeforDelete: " + iCount);
        this.inRef[i] = this.inRef[--iCount];
        //System.out.println("iCountToDelete: " + iCount);
        this.inRef[iCount] = null;
    }
    public Device getInRef(int index)
    {
        return this.inRef[index];
    }
    public void setOutRef(Device dref)
    {
        this.outRef = dref;
    }
    public Device getOutRef()
    {
        return this.outRef;
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
        int flag = 0;
            
        for(int count=0; count < this.getInputCount();count++)
        {
            if(this.in[count] == 0)
                flag++;
        }

        this.out = ((flag%2)==0) ? 1 : 0; 
    }
    public void setFlag(boolean b)
    {
    	this.flag = b;
    }
    public boolean getFlag()
    {
    	return this.flag;
    }
    public void setInput(int val)
    {
        for(int count = 0;count < this.getInputCount();count++)
        {
            this.in[count] = this.inRef[count].getOutput();
        }
    }
}

