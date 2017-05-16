import org.jfugue.*;
import java.io.File;

public class HelloWorld2 {
    public static void main(String[] args) {
        
        //not quite working
        Pattern top = new Pattern();
        
        Pattern one = new Pattern();

        one.addElement(new Tempo(100));
        one.addElement(new Instrument(Instrument.PAD_CHOIR));

        for(int i=0; i<10; i++){
            Note note = new Note((byte)(50+(i*5)), .0625);
            System.out.println(note.getValue());
            one.addElement(note);
        }
        for(int i=0; i<10; i++){
            Note note = new Note((byte)(32+(i*5)), .0625);
            System.out.println(note.getValue());
            one.addElement(note);
        }
        //top.add(one);
        
       Player p = new Player();
       p.play(one);        
        
        //not working
//        for(int i=0; i<128; i++){
//            System.out.print(i + ": ");
//            System.out.println(Note.getStringForNote((byte)i));
//        }        
//        one.add("T[190] C5q G5q A5q B5h G5q");
//        Pattern two = new Pattern();
//        two.add("T[130] F5w G5q B5q C5q");
        
        

//        p.saveMidi(top, new File("test.mid"));
//       }catch(Exception IOException){
//           System.out.println("io exception");
//       }
  
        
        
    // Define the value and decimal duration for each note
//    byte[] noteValues = new byte[]
//    { 64, 69, 72, 71, 64, 71, 74, 72, 76, 68, 76 };
//    double[] durations = new double[]
//    { 0.0625, 0.0625, 0.0625, 0.0625, 0.0625, 0.0625, 0.0625,
//    0.125, 0.125, 0.125, 0.125 };
//    // Create a Pattern and set the tempo and instrument
//    Pattern pattern = new Pattern();
//    pattern.addElement(new Tempo(60));
//    pattern.addElement(new Instrument(Instrument.HARPISCHORD));
//    // Build up the pattern using the note values and durations
//    for (int i=0; i < noteValues.length; i++) {
//    Note note = new Note(noteValues[i], durations[i]);
//    pattern.addElement(note);
//    }
//    // Play the pattern
//    Player player = new Player();
//    player.play(pattern);    
        
    }
}
