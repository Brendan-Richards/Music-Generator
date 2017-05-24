import java.util.Random;

public class Song {
    
    //music stuff
    public InstrumentPart[] parts;
    public Section[] sections;
    private static String[] sectionTypes = {"ChordMelody", "MultiMelody", "Solo"};
    public int numParts;
    private float length;
    public int numberOfSections;
    public int tempo;
    private TSigChange[] tSigChanges;
    private int numTSigChanges;
    private TempoChange[] tempoChanges;
    private int numTempoChanges;
    private int numBars;
    private TSig firstTSig;
    
    public static int maxParts = 3;
    public static int maxTSigChanges = 3;
    public static int maxTempoChanges = 3;
    public static int maxSections = 5;
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

            tempo = rand.nextInt(maxTempo-minTempo)+minTempo;
            
            int bottom = (int)Math.pow(2, (rand.nextInt(3)+2));
            int top = rand.nextInt(maxBeats)+1;
            firstTSig = new TSig(top, bottom);
    
            numberOfSections = rand.nextInt(maxSections-1)+1;
            
            numParts = insts.length;
            parts = new InstrumentPart[numParts];
            for(int i=0; i<numParts; i++){
                parts[i] = new InstrumentPart(insts[i]);
            }  
 
            sections = new Section[numberOfSections];
            for(int i=0; i<numberOfSections; i++){
                int num = rand.nextInt(sectionTypes.length);
                sections[i] = new Section(sectionTypes[num], parts, firstTSig);
            }  
            
	}
	
	public Song(Song a, Song b){
		
	}
    
//plays the song using JFugue
    public void play(){
        JMusicStuff.play(this);
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


