import java.lang.reflect.Field;

public class OneNote {
    public boolean isRest;
    public static final double restChance = .2;
    public String type; // beat subdivision
    private float duration; // in seconds
    private String name; // example: C5
    private double pitch; //frequency in hertz
    private float volume; // range from 0 to 1.0
    
    public OneNote(int tempo, TSig tSig){
        int num = Song.rand.nextInt(6);
        
        switch(num){
            case 0: { type="whole"; duration = (tSig.bottom/tempo)*60; break;}
            case 1: { type="half"; duration = ((tSig.bottom/2)/tempo)*60;  break;}
            case 2: { type="quarter"; duration = ((tSig.bottom/4)/tempo)*60;  break;}
            case 3: { type="eighth"; duration = ((tSig.bottom/8)/tempo)*60;  break;}
            case 4: { type="sixteenth"; duration = ((tSig.bottom/16)/tempo)*60;  break;}
            case 5: { type="thirty-second"; duration = ((tSig.bottom/32)/tempo)*60;  break;}                    
        }
        
        Field[] allFields = NoteList.class.getDeclaredFields();
        num = Song.rand.nextInt(allFields.length);
        name = allFields[num].getName();
        
        try{
            pitch = allFields[num].getDouble(new NoteList());        
        } catch(Exception IllegalAccessException){
            System.out.println("illegal access");
        }

        volume = Song.rand.nextFloat();
        
        float chance = Song.rand.nextFloat();
        if(chance < restChance) isRest = true;
        else isRest = false;
    }
}
