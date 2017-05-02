import java.util.Random;

public class Song {
    
    //music stuff
    private SongPart[] parts;
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
    public static int maxBars = 50;
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
//the constructor with no arguments makes a song,
//while the 2 argument constructor crosses 2 parents' genes to make a song
	public Song(){
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
            
            numParts = rand.nextInt(maxParts-1)+1;
            parts = new SongPart[numParts];
            for(int i=0; i<numParts; i++){
                System.out.println("making part " + (i+1) + " of " + numParts);
                parts[i] = new SongPart(numBars, tempoChanges, tSigChanges, startTempo, startTSig);
            }    
	}
	
	public Song(Song a, Song b){
		
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


