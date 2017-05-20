import java.lang.reflect.Field;
import java.util.ArrayList;

public class SingleNote {
    public boolean isRest;
    public static final double restChance = .2;
    public String type; // beat subdivision
    public String name; // example: C5
    public float volume; // range from 0 to 1.0
    
    public SingleNote(String[] possibleNotes){
        
        int num = Song.rand.nextInt(5);
        switch(num){
            case 0: { type="whole"; break;}
            case 1: { type="half";  break;}
            case 2: { type="quarter"; break;}
            case 3: { type="eighth"; break;}
            case 4: { type="sixteenth"; break;}
            case 5: { type="thirty-second"; break;}                    
        }

        float chance = Song.rand.nextFloat();
        if(chance < restChance) isRest = true;
        else isRest = false;

        if(!isRest){
            num = Song.rand.nextInt(possibleNotes.length);
            name = possibleNotes[num];
            volume = Song.rand.nextFloat();
        } 
    }
    
    public SingleNote(String t, boolean ir, String n, float v){
        type = t;
        isRest = ir;
        name = n;
        volume = v;
    }
    
    
//    private void makeChord(int tempo, TSig tSig, String[] range, int a){
//   
//        int num = Song.rand.nextInt(5);
//        switch(num){
//            case 0: { type="whole"; duration = (tSig.bottom/tempo)*60; break;}
//            case 1: { type="half"; duration = ((tSig.bottom/2)/tempo)*60;  break;}
//            case 2: { type="quarter"; duration = ((tSig.bottom/4)/tempo)*60;  break;}
//            case 3: { type="eighth"; duration = ((tSig.bottom/8)/tempo)*60;  break;}
//            case 4: { type="sixteenth"; duration = ((tSig.bottom/16)/tempo)*60;  break;}
//            case 5: { type="thirty-second"; duration = ((tSig.bottom/32)/tempo)*60;  break;}                    
//        }       
//        
//        for(int j=0; j<a; j++){
//        
//            float chance = Song.rand.nextFloat();
//            if(chance < restChance) isRest = true;
//            else isRest = false;
//            
//            if(!isRest){
//                int low = 0;
//                int high = NoteList.notes.length-1;
//                
//                for(int i=0; i<NoteList.notes.length; i++ ){
//                    if(NoteList.notes[i].equals(range[0]))
//                        low = i;
//                    if(NoteList.notes[i].equals(range[1]))
//                        high = i;
//                }
//                
//                num = Song.rand.nextInt(high+1-low)+low;
//                
//                if(isChord)
//                    chordNotes.add(NoteList.notes[num]);
//                else
//                    name = NoteList.notes[num];
//
//                while(volume != 0.0){
//                    volume = Song.rand.nextFloat();
//                }
//            }           
//        }          
//    }   
}
