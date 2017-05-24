import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import java.lang.reflect.*;
import jm.constants.*;

public class JMusicStuff implements JMC {
    public static void play(Song theSong){
       
        Score s = new Score("test Score");
        s.setTempo(theSong.tempo);
          
        Part[] parts = new Part[theSong.numParts];
          
        for(int i=0; i<theSong.numParts; i++){
            if(theSong.parts[i].instrument.name.equals("guitar")){
                parts[i] = new Part("guitar" + i, GUITAR, i); 
            }
            else
                parts[i] = new Part("piano" + i, PIANO, i); 
        }
        
        //add notes to parts
        for(int i=0; i<theSong.numParts; i++){
            for(int j=0; j<theSong.parts[i].bars.size(); j++){
                if(!theSong.parts[i].bars.get(j).isChordProg){
                    Phrase phr = new Phrase();
                    for(int k=0; k<theSong.parts[i].bars.get(j).beats.size(); k++){
                        String noteName = theSong.parts[i].bars.get(j).beats.get(k).notes.get(0).name;
                        //System.out.println("beat is a single note, noteName is: " + noteName);
                        String noteType = theSong.parts[i].bars.get(j).beats.get(k).notes.get(0).type;
                        Note n = makeNote(noteName, noteType);
                        phr.addNote(n);
                    }
                    parts[i].add(phr);
                }
                else{
                    CPhrase phr2 = new CPhrase();
                    //make the chords and add to the cphrase and add cphrase to part 
                    for(int k=0; k<theSong.parts[i].bars.get(j).beats.size(); k++){         
                        Note[] chordNotes = new Note[theSong.parts[i].bars.get(j).beats.get(k).notes.size()];
                        for(int m=0; m<theSong.parts[i].bars.get(j).beats.get(k).notes.size(); m++){
                            String noteName = theSong.parts[i].bars.get(j).beats.get(k).notes.get(m).name;
                            //System.out.println("beat is a chord, noteName is: " + noteName);
                            String noteType = theSong.parts[i].bars.get(j).beats.get(k).notes.get(m).type;
                            chordNotes[m] = makeNote(noteName, noteType);
                        }
                        phr2.addChord(chordNotes);
                    }
                    parts[i].addCPhrase(phr2);
                }
            }
        }
        
        for(int i=0; i<theSong.numParts; i++){
            s.addPart(parts[i]);
        }
 
       
        Write.midi(s);
        //Play.midi(s);
        
    }
    
    private static Note makeNote(String noteName, String noteType){
 
        String newName = "";
        
        if(noteName != null) newName = noteName.replace('b', 'F');
        
        Class c = Pitches.class;
        
        int theName = 0;
        Field f = null;
        try{
            if(noteName != null){ 
                newName = noteName.replace('b', 'F');
                f =  c.getDeclaredField(newName);
                theName = f.getInt(new JMusicStuff());
            }
            else{
                theName = REST;
            }
            switch(noteType){
                case "whole": return new Note(theName, 4.0);
                case "half": return new Note(theName, 2.0);
                case "quarter": return new Note(theName, 1.0);
                case "eighth": return new Note(theName, 0.5);
                case "sixteenth": return new Note(theName, 0.25);
                case "thirty-second":  return new Note(theName, 0.125);
            }
            return new Note(theName, 12);
        }catch(Exception x){
            System.out.println("couldnt find field or something");
        }
        return null;
    }
}
