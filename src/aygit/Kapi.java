package aygit;

import Simulasyon.Koordinat;
import Simulasyon.AygitEnum;
import java.util.ArrayList;

public class Kapi extends DevreCihazi
{

    private Koordinat inLeg[];
    private Koordinat outLeg;
    protected ArrayList<DevreCihazi> outRef;
    protected ArrayList<Tel> outWire;
    protected DevreCihazi inRef[];
    protected int iCount;
    protected boolean input[];
    protected boolean output=false;
    
    public Kapi(int inputCount, AygitEnum de, Koordinat location) {
        super(inputCount, de, location);
        this.input = new boolean[5];
        iCount = 0;
        for ( int i = 0; i < inputCount; i++ )  input[i] = false;
        output = false;
        this.inLeg = new Koordinat[5];
        outRef = new ArrayList();
        outWire = new ArrayList();
        inRef = new DevreCihazi[5];
        selected = false;
        
        for(int count = 0; count < inputCount; count++) {
            inRef[count] = null;
            input[count] = false;
            Tel w = new Tel();
        }
    }
    
    
    @Override
    public final void setGirisSayisi(int inc)    {
        this.girisSayisi = inc;
    }
    
    @Override
    public final void setInput()  {
        for(int count = 0;count < this.getGirisSayisi();count++)
        {
            this.input[count] = this.inRef[count].getOutput();
        }
        System.out.println("girdi oluşturuluyor "+this.getClass().toString());
        this.generateOutput();
        this.setOutWireState();
    }
    
    @Override
    public final void setIn(int index,boolean i)  {
        this.input[index] = i;
        this.generateOutput();
        this.setOutWireState();
    }
    
    @Override
    public final void setOutput(boolean b)   {
        this.output = b;
        this.generateOutput();
        this.setOutWireState();
    }
    
    public final void setOutWireState()  {
        int l = outWire.size();
        for ( int i = 0; i < l; i++ )   {
            outWire.get(i).setState(this.getOutput());
        }
    }
    
    @Override
    public final boolean getGiris(int index) {
        return this.input[index];
    }
    
    @Override
    public final int getInX(int index)    {
        return this.inLeg[index].x;
    }
    
    @Override
    public final int getInY(int index)    {
        return this.inLeg[index].y;
    }
    
    @Override
    public final int getOutX()    {
        return this.outLeg.x;
    }
    
    @Override
    public final int getOutY()    {
        return this.outLeg.y;
    }
    
    @Override
    public final boolean getOutput() {
        return this.output;
    }
    
    
    @Override
    public final boolean setInRef(int index, DevreCihazi d)  {
        if ( inRef[index] == null ) inRef[index] = d;
        else return false;
        return true;
    }
    
    @Override
    public final void setInLeg (Koordinat c, int i)    {
        inLeg[i] = c;
    }
   
    @Override
    public final Koordinat getInLeg(int i) {
        return inLeg[i];
    }

    @Override
    public final void setOutLeg(Koordinat c) {
        this.outLeg = c;
    }
    
    @Override
    public final Koordinat getOutLeg() {
        return outLeg;
    }

    @Override
    public boolean isValid() {
        for ( int i = 0; i < girisSayisi; i++ )
            if ( inRef[i] == null ) return false;
        return true;
    }

    @Override
    public final DevreCihazi getInRef(int index) {
        return inRef[index];
    }

    @Override
    public final void addOutRef(DevreCihazi dref) {
        outRef.add(dref);
    }

    @Override
    public void addOutWire(Tel w) {
        outWire.add(w);
    }

    
    @Override
    public final boolean removeOutRef (DevreCihazi ref)  {
        int l = outRef.size();
        for ( int i = 0; i < outRef.size(); i++ )   {
            if ( outRef.get(i) == ref )    {
                if ( outRef.remove(i) == null )    {
                    System.out.println("Tel çıkarılamadı");
                }
            }
            else    {
                i--;
            }
        }
        return outRef.remove(ref);
    }
    
    @Override
    public final ArrayList getOutRef() {
        return outRef;
    }

    @Override
    public void removeInRef(int index) {
        inRef[index] = null;
    }
    
    
    @Override
    public final boolean delete() {
        int inc = this.getGirisSayisi();
        for ( int i = 0; i < inc; i++ ) {   
            DevreCihazi d = this.getInRef(i);
            if ( d != null )    {
                d.removeOutRef(this);
            }
        }
        int l = 0;
        if ( outRef != null )   {
            for ( int i = 0; i < outRef.size(); i++ )   {   
                DevreCihazi d = outRef.get(i);
                        System.out.println("Cihazın giriş referansı kaldırılıyor "+d.getClass());
                for ( int j = 0; j < d.getGirisSayisi(); j++ )   {
                    if ( d.getInRef(j) == this )    {
                        d.removeInRef(j);
                    }
                }
            }
        }
        
        l = outWire.size();
        outWire.clear();
        outWire = null;
        outRef.clear();
        outRef = null;
        return true;
    }
    
    
}
