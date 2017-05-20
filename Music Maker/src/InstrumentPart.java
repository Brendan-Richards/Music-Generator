import java.util.ArrayList;

public class InstrumentPart {
    public ArrayList<Bar> bars;
    public Instrument instrument;
       
    public InstrumentPart(Instrument instr){
        instrument = instr; 
        bars = new ArrayList();
    }
    
}//end part
