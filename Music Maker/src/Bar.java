import java.util.ArrayList;

public class Bar {
    private ArrayList<OneNote> notes;
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
        int counter = 0;
        while(totalBeats < tSig.top){
            System.out.println("        making note");
            boolean found = false;
            counter++;
            if(counter>1000){
                System.out.println();
                System.out.println();
            }
            while(!found){
                OneNote temp = new OneNote(tempo, tSig);
                switch(temp.type){
                    case "whole": {
                        if(canAdd("whole", totalBeats)){ found = true; totalBeats += tSig.bottom; notes.add(temp);  }
                        else temp = new OneNote(tempo, tSig);
                         break;}
                    case "half":{
                        if(canAdd("half", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/2); notes.add(temp); }
                        else temp = new OneNote(tempo, tSig);
                         break;}
                    case "quarter":{
                        if(canAdd("quarter", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/4); notes.add(temp); }
                        else temp = new OneNote(tempo, tSig);
                         break;}
                    case "eighth":{
                        if(canAdd("eighth", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/8); notes.add(temp); }
                        else temp = new OneNote(tempo, tSig);
                         break;}
                    case "sixteenth":{
                        if(canAdd("sixteenth", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/16); notes.add(temp); }
                        else temp = new OneNote(tempo, tSig);
                         break;}
                    case "thirty-second":{
                        if(canAdd("thirty-second", totalBeats)){ found = true; totalBeats += (float)(tSig.bottom/32); notes.add(temp); }
                        else temp = new OneNote(tempo, tSig);
                         break;}
                }
            }
        }
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
