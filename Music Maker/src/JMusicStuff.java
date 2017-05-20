import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class JMusicStuff implements JMC {
    public static void play(Song theSong){
        
        Score s = new Score("test Score");
        s.setTempo(100);
//        Part[] parts = new Part[theSong.numParts];
//        
//        for(int i=0; i<theSong.numParts; i++){
//            parts[i] = new Part(theSong.parts[i].instrument.name); 
//        }
        Part p1 = new Part("Guitar", GUITAR, 0);
        Part p2 = new Part("piano", PIANO, 1 );

        
		Phrase phr1 = new Phrase();
        phr1.addNote(new Note(E4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(FS4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(G4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(FS4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(G4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(A4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(G4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(FS4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(B4, EIGHTH_NOTE));
        phr1.addNote(new Note(G4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(FS4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(G4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(FS4, SIXTEENTH_NOTE));
        phr1.addNote(new Note(E4, EIGHTH_NOTE));
        phr1.addNoteList(phr1.getNoteArray());
        phr1.addNoteList(phr1.getNoteArray());

        
        CPhrase phr2 = new CPhrase();

        phr2.addChord(new Note[]{new Note(E4, WHOLE_NOTE), new Note(B5, WHOLE_NOTE), new Note(E5, WHOLE_NOTE)});
        phr2.addChord(new Note[]{new Note(C4, WHOLE_NOTE), new Note(G3, WHOLE_NOTE), new Note(C5, WHOLE_NOTE)});
        phr2.addChord(new Note[]{new Note(D4, WHOLE_NOTE), new Note(A5, WHOLE_NOTE), new Note(D5, WHOLE_NOTE)});
        phr2.addChord(new Note[]{new Note(D4, WHOLE_NOTE), new Note(A5, WHOLE_NOTE), new Note(D5, WHOLE_NOTE)});
        
        
        Phrase phr3 = new Phrase();
        phr3.add(new Note(G5, WHOLE_NOTE));
        phr3.add(new Note(E5, WHOLE_NOTE));
        phr3.add(new Note(FS5, WHOLE_NOTE));
        phr3.add(new Note(EF5, WHOLE_NOTE));

        
        CPhrase phr4 = new CPhrase();
        phr4.addChord(new Note[]{new Note(E4, WHOLE_NOTE), new Note(B5, WHOLE_NOTE), new Note(E5, WHOLE_NOTE)});
        phr4.addChord(new Note[]{new Note(C4, WHOLE_NOTE), new Note(G3, WHOLE_NOTE), new Note(C5, WHOLE_NOTE)});
        phr4.addChord(new Note[]{new Note(D4, WHOLE_NOTE), new Note(A5, WHOLE_NOTE), new Note(D5, WHOLE_NOTE)});
        phr4.addChord(new Note[]{new Note(B4, WHOLE_NOTE), new Note(FS5, WHOLE_NOTE), new Note(B5, WHOLE_NOTE)});   
        
//        phr1.setTempo(100);
//        phr2.setTempo(100);
//        phr3.setTempo(140);
//        phr4.setTempo(140);
        
        p1.addPhrase(phr1);
        p1.addPhrase(phr3);
        p2.addCPhrase(phr2);
        p2.addCPhrase(phr4);
		s.addPart(p1);
        s.addPart(p2);
        
        System.out.println(s.getNumerator() + "/" + s.getDenominator());
        System.out.println(s.getTempo());
        //Write.midi(s);
        //Play.midi(s);
    }
}
