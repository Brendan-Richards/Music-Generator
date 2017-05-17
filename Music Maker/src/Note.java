import java.lang.reflect.Field;
import java.util.ArrayList;

public class Note {
    public boolean isRest;
    public boolean isChord = false;
    private ArrayList chordNotes;
    public static final double restChance = .2;
    public String type; // beat subdivision
    private float duration; // in seconds
    private String name; // example: C5
    private double pitch; //frequency in hertz
    private float volume; // range from 0 to 1.0
    
    public Note(int tempo, TSig tSig, String[] range, boolean isChordal){

        
        int a = 1;
        
        if(isChordal){    
            a = Song.rand.nextInt(5)+1;
            if(a > 1){
                chordNotes = new ArrayList();
                this.isChord = true;
            }
        }
        
        for(int j=0; j<a; j++){
            int num = Song.rand.nextInt(6);
            switch(num){
                case 0: { type="whole"; duration = (tSig.bottom/tempo)*60; break;}
                case 1: { type="half"; duration = ((tSig.bottom/2)/tempo)*60;  break;}
                case 2: { type="quarter"; duration = ((tSig.bottom/4)/tempo)*60;  break;}
                case 3: { type="eighth"; duration = ((tSig.bottom/8)/tempo)*60;  break;}
                case 4: { type="sixteenth"; duration = ((tSig.bottom/16)/tempo)*60;  break;}
                case 5: { type="thirty-second"; duration = ((tSig.bottom/32)/tempo)*60;  break;}                    
            }
        
            float chance = Song.rand.nextFloat();
            if(chance < restChance) isRest = true;
            else isRest = false;
            
            if(!isRest){
//                Field[] allFields = NoteList.class.getDeclaredFields();
//                System.out.println("String[] notes = new String[]{ ");
//                for(int i=1; i<allFields.length; i++){
//                    System.out.print("\"" + allFields[i].getName() + "\",");
//                    if(i%5 == 0) System.out.print("\n");
//                }
//                System.out.println("};");
//                System.exit(1);
                int low = 0;
                int high = NoteList.notes.length-1;
                
                for(int i=0; i<NoteList.notes.length; i++ ){
                    if(NoteList.notes[i].equals(range[0]))
                        low = i;
                    if(NoteList.notes[i].equals(range[1]))
                        high = i;
                }
                
                num = Song.rand.nextInt(high+1-low)+low;
                
                if(isChord)
                    chordNotes.add(NoteList.notes[num]);
                else
                    name = NoteList.notes[num];

                volume = Song.rand.nextFloat();
            }     
//            try{
//                pitch = allFields[num].getDouble(new NoteList());        
//            } catch(Exception IllegalAccessException){
//                System.out.println("illegal access");
//            }
        
        }
    }
}
