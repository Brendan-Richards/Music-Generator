
import java.util.Arrays;


public class Section {
       
    public String type;
    public int sectionLength;
    TSig tSig;
    //range[0] is the index in the part's bars arraylist that this section starts on
    //range[1] is the index in the part's bars arraylist that this section ends on
    public int[] range = new int[2];
    private static int maxSectionLength = 20;
    
    public Section(String t, InstrumentPart[] parts, TSig timeSig){ 
        type = t;
        tSig = timeSig;
        range[0] = parts[0].bars.size();
        range[1] = Song.rand.nextInt(maxSectionLength)+range[0];
        
        sectionLength = range[1]-range[0]+1;
        
        switch(type){
            case "ChordMelody":{ makeChordMelody(parts); break; } 
            case "MultiMelody":{ makeMultiMelody(parts); break; }
            case "Solo": { makeSolo(parts); break; }
        }
    }
    
    private void makeChordMelody(InstrumentPart[] parts){
     
        int chordGuy = Song.rand.nextInt(parts.length);

        int low = 0;
        int high = NoteList.notes.length-1;

        for(int i=0, j=NoteList.notes.length-1; i<NoteList.notes.length; i++, j-- ){
            if(NoteList.notes[i].equals(parts[chordGuy].instrument.range[0]))
                low = i;
            if(NoteList.notes[j].equals(parts[chordGuy].instrument.range[1]))
                high = j+1;
        }

        String[] possibleNotes = Arrays.copyOfRange(NoteList.notes, low, high);
        
        //make all the chord progression bars
        //each loop makes one bar of chords
        for(int i=0; i<sectionLength; i++){
            parts[chordGuy].bars.add(new Bar(tSig, possibleNotes, true));
        }
        
        //make all the bars for the other instruments
        for(int i=0; i<parts.length; i++){
            if(i==chordGuy) continue;
            
            for(int j=0, k=NoteList.notes.length-1; j<NoteList.notes.length; j++, k-- ){
                if(NoteList.notes[j].equals(parts[i].instrument.range[0]))
                    low = j;
                if(NoteList.notes[k].equals(parts[i].instrument.range[1]))
                    high = k+1;
            }   
            
            //get new instrument's range
            possibleNotes = Arrays.copyOfRange(NoteList.notes, low, high);
            
            //add all the new bars
            for(int m=0; m<sectionLength; m++){
                parts[i].bars.add(new Bar(tSig, possibleNotes, false));  
            }
        }     
    }
    
    private void makeMultiMelody(InstrumentPart[] parts){
        
        int low=0, high=NoteList.notes.length;
        
        for(int i=0; i<parts.length; i++){
            
            for(int j=0, k=NoteList.notes.length-1; j<NoteList.notes.length; j++, k-- ){
                if(NoteList.notes[j].equals(parts[i].instrument.range[0]))
                    low = j;
                if(NoteList.notes[k].equals(parts[i].instrument.range[1]))
                    high = k+1;
            }   
            
            //get new instrument's range
            String[] possibleNotes = Arrays.copyOfRange(NoteList.notes, low, high);
            
            //add all the new bars
            for(int m=0; m<sectionLength; m++){
                parts[i].bars.add(new Bar(tSig, possibleNotes, false));  
            }
        } 
    
    }
    
    private void makeSolo(InstrumentPart[] parts){
    
        int soloGuy = Song.rand.nextInt(parts.length);
        
        int low=0, high=NoteList.notes.length;
        
        for(int j=0, k=NoteList.notes.length-1; j<NoteList.notes.length; j++, k-- ){
            if(NoteList.notes[j].equals(parts[soloGuy].instrument.range[0]))
                low = j;
            if(NoteList.notes[k].equals(parts[soloGuy].instrument.range[1]))
                high = k+1;
        }   

        //get new instrument's range
        String[] possibleNotes = Arrays.copyOfRange(NoteList.notes, low, high);

        //add all the new bars
        for(int m=0; m<sectionLength; m++){
            parts[soloGuy].bars.add(new Bar(tSig, possibleNotes, false));  
        }
        
        
        for(int i=0; i<parts.length; i++){
            if(i==soloGuy) continue;
            
            for(int m=0; m<sectionLength; m++){
                SingleNote rest = new SingleNote("whole", true, "", 0.0f);
                Beat b = new Beat(rest);
                parts[i].bars.add(new Bar(tSig, b));  
            }    
        }
    }
    
    
}
