import java.util.Random;

public class Song {
    
    //music stuff
    private Part[] parts;
    private int numParts;
    private int maxParts = 3;
    private float length;
    private TSigChange[] tSigChanges;
    private TempoChange[] tempoChanges;
    private int numBars;
    private int maxBars = 50;
	
    protected static Random rand = new Random();	
	
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
            
            numParts = rand.nextInt(maxParts-1)+1;
            parts = new Part[numParts];
            for(int i=0; i<numParts; i++){
                parts[i] = new Part();
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


