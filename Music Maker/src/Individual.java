import java.util.Random;

public class Individual {

	protected int fitness;
	
	protected static Random rand = new Random();	
	
	protected static final double mutationProb = 0.01,
			crossoverProb = 1.0;
	
	private int crossoverPoint;

/////////////////////////////////////////////////////////////
//constructors:
//the only difference between the 2 is that 
//the constructor with no arguments makes a random formula,
//while the 2 argument constructor crosses 2 parents' formulas to make its own
	public Individual(){

	}
	
	public Individual(Individual a, Individual b){
		
	}

/////////////////////////////////////////////////////////////////
//this method takes 2 individuals and crosses their 
//genes to make a child
	private void crossover(Individual a, Individual b) {

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


