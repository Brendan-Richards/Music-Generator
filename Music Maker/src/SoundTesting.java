import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.event.*;
 
public class SoundTesting implements JMC {
    public void soundTest() { 

        Score myscore = new Score("my score!", 84);
        Part mypart = new Part("melody", PIPE_ORGAN, 1);
        Phrase phr = new Phrase();

        for(int i=0; i<14; i++){
            Note n;
            n = new Note(C4, EIGHTH_NOTE);
            phr.addNote(n);
        }
        mypart.appendPhrase(phr);
        myscore.addPart(mypart);
        myscore.setTempo(120);
        Write.midi(myscore, "testMidiFile.mid");
        
        
        
        
    }
}
