
public class Part {
    private Bar[] bars;
    private Instrument instrument;
    
    public Part(int numBars, TempoChange[] tempoChanges, TSigChange[] tSigChanges, int startTempo, TSig startTSig, Instrument instr){
        bars = new Bar[numBars];
        instrument = instr; 
        int currTemp = startTempo;
        TSig currTSig = new TSig(startTSig.top, startTSig.bottom);
        
        for(int i=0; i<numBars; i++){
            
            System.out.println("    making bar " + (i+1) + " of " + numBars);
            //if there is a tempo or time signiture change on this bar, change it
            for(int j=0; j<tempoChanges.length; j++){
                if(tempoChanges[j].bar == (i+1)) currTemp = tempoChanges[j].tempo;
            }
            for(int j=0; j<tSigChanges.length; j++){
                if(tSigChanges[j].bar == (i+1)){
                    currTSig.top = tSigChanges[j].timeSig.top;
                    currTSig.bottom = tSigChanges[j].timeSig.bottom;
                }
            }
            
            bars[i] = new Bar(currTemp, currTSig, instrument);
        }
    }
    
}//end part
