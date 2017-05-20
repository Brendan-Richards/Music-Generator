import java.util.ArrayList;

public class Bar {
    public ArrayList<Beat> beats;
    private TSig tSig;
    public int tempo;
    private Instrument instrument;
    String[] possibleNotes;
    
    public Bar(TSig t, String[] notes, boolean isChordProgression){
        tSig = t;
        possibleNotes = notes;
        beats = new ArrayList();
        
        if(isChordProgression)
            makeChords();
        else
            makeNotes();
    }
    
    private void makeNotes(){
        float totalBeats = 0;
 
        while(totalBeats < tSig.top){
            System.out.println("        making note");
            boolean found = false;

            while(!found){
                SingleNote temp = new SingleNote(possibleNotes);
                switch(temp.type){
                    case "whole": {
                        if(canAdd("whole", totalBeats)){ found = true; totalBeats += tSig.bottom; beats.add(new Beat(temp));  }
                        else temp = new SingleNote(possibleNotes);
                         break;}
                    case "half":{
                        if(canAdd("half", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/2); beats.add(new Beat(temp)); }
                        else temp = new SingleNote(possibleNotes);
                         break;}
                    case "quarter":{
                        if(canAdd("quarter", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/4); beats.add(new Beat(temp));}
                        else temp = new SingleNote(possibleNotes);
                         break;}
                    case "eighth":{
                        if(canAdd("eighth", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/8); beats.add(new Beat(temp));}
                        else temp = new SingleNote(possibleNotes);
                         break;}
                    case "sixteenth":{
                        if(canAdd("sixteenth", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/16); beats.add(new Beat(temp));}
                        else temp = new SingleNote(possibleNotes);
                         break;}
                    case "thirty-second":{
                        if(canAdd("thirty-second", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/32); beats.add(new Beat(temp));}
                        else temp = new SingleNote(possibleNotes);
                         break;}
                }
            }
        }
    }
    
    private void makeChords(){
        float totalBeats = 0;
 
        while(totalBeats < tSig.top){
            System.out.println("        making note");
            boolean found = false;

            while(!found){
                SingleNote temp = new SingleNote(possibleNotes);
                switch(temp.type){
                    case "whole": {
                        if(canAdd("whole", totalBeats)){ 
                            found = true; 
                            totalBeats += tSig.bottom; 
                            beats.add(new Beat(getOtherNotes(temp))); 
                        }
                        else 
                            temp = new SingleNote(possibleNotes);
                         break;
                    }
                    case "half":{
                        if(canAdd("half", totalBeats)){ 
                            found = true; 
                            totalBeats += (float)(tSig.bottom/2); 
                            beats.add(new Beat(getOtherNotes(temp))); 
                        }
                        else 
                            temp = new SingleNote(possibleNotes);
                         break;
                    }
                    case "quarter":{
                        if(canAdd("quarter", totalBeats)){ 
                            found = true; 
                            totalBeats += (float)(tSig.bottom/4); 
                            beats.add(new Beat(getOtherNotes(temp))); 
                        }
                        else 
                            temp = new SingleNote(possibleNotes);
                         break;
                    }
                    case "eighth":{
                        if(canAdd("eighth", totalBeats)){ 
                            found = true; 
                            totalBeats += (float)(tSig.bottom/8); 
                            beats.add(new Beat(getOtherNotes(temp))); 
                        }
                        else 
                            temp = new SingleNote(possibleNotes);
                         break;
                    }
                    case "sixteenth":{
                        if(canAdd("sixteenth", totalBeats)){ 
                            found = true; 
                            totalBeats += (float)(tSig.bottom/16); 
                            beats.add(new Beat(getOtherNotes(temp))); 
                        }
                        else 
                            temp = new SingleNote(possibleNotes);
                         break;
                    }
                    case "thirty-second":{
                        if(canAdd("thirty-second", totalBeats)){ 
                            found = true; 
                            totalBeats += (float)(tSig.bottom/32); 
                            beats.add(new Beat(getOtherNotes(temp))); 
                        }
                        else 
                            temp = new SingleNote(possibleNotes);
                         break;
                    }
                }
            }
        }
    }
    
    private SingleNote[] getOtherNotes(SingleNote temp){
        int num = Song.rand.nextInt(5)+2;
        
        SingleNote[] theNotes = new SingleNote[num];
        theNotes[0] = temp;
        
        for(int i=1; i<num; i++){
            int val = Song.rand.nextInt(possibleNotes.length);
            while(possibleNotes[val].equals(temp.name)){
                val = Song.rand.nextInt(possibleNotes.length);
            }
            theNotes[i] = new SingleNote(temp.type, possibleNotes[val], temp.volume);
        }
        
        return theNotes;
    }
    
    private boolean canAdd(String noteType, float totalBeats){
        switch(noteType){
            case "whole": if(totalBeats == 0) return true; else return false;
            case "half": if(totalBeats + (float)(tSig.bottom/2) <= tSig.top) return true; else return false;
            case "quarter": if(totalBeats + (float)(tSig.bottom/4) <= tSig.top) return true; else return false;
            case "eighth": if(totalBeats + (float)(tSig.bottom/8) <= tSig.top) return true; else return false;
            case "sixteenth": if(totalBeats + (float)(tSig.bottom/16) <= tSig.top) return true; else return false;
            case "thirty-second": if(totalBeats + (float)(tSig.bottom/32) <= tSig.top) return true; else return false;              
        }
        return false;
    }
    
}
