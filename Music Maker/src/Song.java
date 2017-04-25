import java.util.Random;

public class Song {
    
    //music stuff
    private Part[] parts;
    private float length;
    private TSigChange[] tSigChanges;
    private TempoChange[] tempoChanges;
    private int numBars;
	
	protected static Random rand = new Random();	
	
    //GA stuff
    protected int fitness;
	protected static final double mutationProb = 0.01,
			crossoverProb = 1.0;
	private int crossoverPoint;

/////////////////////////////////////////////////////////////
//constructors:
//the only difference between the 2 is that 
//the constructor with no arguments makes a random formula,
//while the 2 argument constructor crosses 2 parents' formulas to make its own
	public Song(){

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


