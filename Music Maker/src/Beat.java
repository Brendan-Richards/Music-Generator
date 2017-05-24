import java.util.ArrayList;

public class Beat {
    public ArrayList<SingleNote> notes;
    public String type;
    public boolean isChord;
    
    public Beat(SingleNote note){
        notes = new ArrayList();
        notes.add(note);
        isChord = false;
    }
    
    public Beat(SingleNote[] notes){
        this.notes = new ArrayList();
        
        for(int i=0; i<notes.length; i++){
               this.notes.add(notes[i]);
        }
        
        isChord = true;
    }  
}
