import java.util.Random;

public class Song {
    
    //music stuff
    private Part[] parts;
    private int numParts;
    private float length;
    private TSigChange[] tSigChanges;
    private int numTSigChanges;
    private TempoChange[] tempoChanges;
    private int numTempoChanges;
    private int numBars;
    
    public static int maxParts = 3;
    public static int maxTSigChanges = 3;
    public static int maxTempoChanges = 3;
    public static int maxBars = 20;
    public static int minTempo = 50;
    public static int maxTempo = 200;
    public static int maxBeats = 32;
	
    public static Random rand = new Random();	
	
    //GA stuff
    protected int fitness;
    protected static final double mutationProb = 0.01,
                                  crossoverProb = 1.0;
    private int crossoverPoint;

/////////////////////////////////////////////////////////////
//constructors:
//the only difference between the 2 is that 
//the constructor with no arguments makes a random song,
//while the 2 argument constructor crosses 2 parents' genes to make a song
	public Song(Instrument[] insts){
            numBars = rand.nextInt(maxBars-10)+10;
            int startTempo = rand.nextInt(maxTempo-minTempo)+minTempo;
            
            int bottom = (int)Math.pow(2, (rand.nextInt(3)+2));
            int top = rand.nextInt(maxBeats)+1;
            TSig startTSig = new TSig(top, bottom);
            
            numTSigChanges = rand.nextInt(maxTSigChanges);
            tSigChanges = new TSigChange[numTSigChanges];
            for(int i=0; i<numTSigChanges; i++){
                tSigChanges[i] = new TSigChange();
            }
            
            numTempoChanges = rand.nextInt(maxTempoChanges);
            tempoChanges = new TempoChange[numTempoChanges];
            for(int i=0; i<numTempoChanges; i++){
                tempoChanges[i] = new TempoChange();
            }
            
            numParts = insts.length;
            parts = new Part[numParts];
            for(int i=0; i<numParts; i++){
                System.out.println("making part " + (i+1) + " of " + numParts);
                parts[i] = new Part(numBars, tempoChanges, tSigChanges, startTempo, startTSig, insts[i]);
            }    
	}
	
	public Song(Song a, Song b){
		
	}
    
//plays the song using JFugue
    public void play(){
        
    }

/////////////////////////////////////////////////////////////////
//this method takes 2 individuals and crosses their 
//genes to make a child
	private void crossover(Song a, Song b) {

	}
////////////////////////////////////////////////////////////////
//fitness is calculated in the following way:
	private void calcFitness() {

	}

///////////////////////////////////////////////////////////////////
//mutates an individual
	private void mutate() {

	}
}


