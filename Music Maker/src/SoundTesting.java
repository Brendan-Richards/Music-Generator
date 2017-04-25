import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

public class SoundTesting {

    public static void main(String []args){
        AudioContext ac = new AudioContext();
        WavePlayer wp = new WavePlayer(ac, 440.0f, Buffer.SINE);
        ac.out.addInput(wp);
        ac.start();   
    }//end main
    
}//end class
