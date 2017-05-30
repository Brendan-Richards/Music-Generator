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
        if(chance < restChance) {
            isRest = true;
            name = null;
        }
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
        if(isRest) name = null;
        volume = v;
    }
  
}
