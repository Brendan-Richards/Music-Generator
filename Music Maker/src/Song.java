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
	public Song(Instrument[] insts, int top, int bottom){

        tempo = rand.nextInt(maxTempo-minTempo)+minTempo;

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
        
        tempo = (a.tempo + b.tempo)/2;
        
        if(a.numParts != b.numParts){
            System.out.println("error two parent songs have different number of parts");
            System.exit(1);
        }
        
         if(!a.firstTSig.equals(b.firstTSig)){
            System.out.println("error two parent songs have different time sigs");
            System.out.println("parent 1 tsig: " + a.firstTSig.top + "/" + a.firstTSig.bottom);
            System.out.println("parent 2 tsig: " + b.firstTSig.top + "/" + b.firstTSig.bottom);
            System.exit(1);
        }       
        
        firstTSig = a.firstTSig;
         
        numParts = a.numParts;
        
        parts = new InstrumentPart[numParts];
        
        int c1 = rand.nextInt(a.parts[0].bars.size()-1)+1;
        int c2 = rand.nextInt(b.parts[0].bars.size()-1)+1;
        int choice1 = Song.rand.nextInt(2);//if 0 the begginning until c1 is copied,
                                           //if 1, then c1 to the end is copied from parent
        int choice2 = Song.rand.nextInt(2);
        
        
        for(int i=0; i<a.numParts; i++){
            parts[i] = new InstrumentPart(a.parts[i], b.parts[i], c1, c2, choice1, choice2);
        }
        
        System.out.println("Time Signiture of child: " + this.firstTSig.top + "/" + this.firstTSig.bottom);
	}
    
//plays the song using JFugue
    public void play(){
        JMusicStuff.play(this);
    }
    public void save(String fileName){
        JMusicStuff.save(this, fileName);
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


