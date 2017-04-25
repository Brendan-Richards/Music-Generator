
public class Part {
    private Bar[] bars;
    private String instrument;
    
    public Part(int numBars, TempoChange[] tempoChanges, TSigChange[] tSigChanges, int startTempo, TSig startTSig){
        bars = new Bar[numBars];

        int currTemp = startTempo;
        TSig currTSig = new TSig(startTSig.top, startTSig.bottom);
        
        for(int i=0; i<numBars; i++){
            
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
            
            bars[i] = new Bar(currTemp, currTSig);
        }
    }
    
}//end part
