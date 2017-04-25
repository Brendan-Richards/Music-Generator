import java.util.ArrayList;

public class Bar {
    private ArrayList<Note> notes;
    private TSig tSig;
    private int tempo;
    
    public Bar(int currTempo, TSig currTSig){
        tempo = currTempo;
        tSig = currTSig;
        notes = new ArrayList();
        makeNotes();
    }
    
    private void makeNotes(){
        float totalBeats = 0;
        
        while(totalBeats < tSig.top){
            
            boolean found = false;
            while(!found){
                Note temp = new Note();
                switch(temp.type){
                    case "whole": 
                        if(canAdd("whole", totalBeats)){ found = true; totalBeats += tSig.bottom; notes.add(temp); }
                        else temp = new Note();
                    case "half":
                        if(canAdd("half", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/2); notes.add(temp); }
                        else temp = new Note();
                    case "quarter":
                        if(canAdd("quarter", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/4); notes.add(temp); }
                        else temp = new Note();
                    case "eighth":
                        if(canAdd("quarter", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/8); notes.add(temp); }
                        else temp = new Note();
                    case "sixteenth":
                        if(canAdd("sixteenth", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/16); notes.add(temp); }
                        else temp = new Note();
                    case "thirty-second":
                        if(canAdd("thirty-second", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/32); notes.add(temp); }
                        else temp = new Note();
                    case "sixty-fourth":
                        if(canAdd("sixty-fourth", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/64); notes.add(temp); }
                        else temp = new Note();
                }
            }
        }
    }
    
    private boolean canAdd(String noteType, float totalBeats){
        switch(noteType){
            case "whole": if(totalBeats == 0) return true; else return false;
            case "half": if(totalBeats + (float)(tSig.bottom/2) <= totalBeats) return true; else return false;
            case "quarter": if(totalBeats + (float)(tSig.bottom/4) <= totalBeats) return true; else return false;
            case "eighth": if(totalBeats + (float)(tSig.bottom/8) <= totalBeats) return true; else return false;
            case "sixteenth": if(totalBeats + (float)(tSig.bottom/16) <= totalBeats) return true; else return false;
            case "thirty-second": if(totalBeats + (float)(tSig.bottom/32) <= totalBeats) return true; else return false;
            case "sixty-fourth": if(totalBeats + (float)(tSig.bottom/64) <= totalBeats) return true; else return false;               
        }
        return false;
    }
    
}
