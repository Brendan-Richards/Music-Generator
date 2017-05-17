import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class GA {

	protected static int target;//the value that the user wants to find a formula for
        
    private static final Scanner keyboard = new Scanner(System.in);
	
    private static int maxParts = 3;
    
	private int generationCount = 0,//the current generation
		currentAverageFitness,//the current average fitness of the whole population
		previousAverageFitness = 1000000,//the average fitness of the previous generation
		solutionGuy;//the index of the individual that has the winning formula 
			
	private static boolean done = false;//set to true if the user doesn't want to run it again

	private boolean targetReached = false;//flag that tells us when we have found a solution
	
	private Song []population,//holds the current population
			newPopulation;//used to temporarily store the new population
	
	private int maxGenerations = 999;//number of Individuals in the population

	private final int populationSize = 100;

	
/////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {	
        
        int numParts = Song.rand.nextInt(maxParts)+1;
        Instrument []insts = new Instrument[numParts];
        for(int i=0; i<numParts; i++){
            insts[i] = new Instrument();
        }
        Song b = new Song(insts);
        b.play();
        
//		while(!done){
//			GA a = new GA();
//			//get the target value from the user
//			a.getTarget();
//            //time the GA run by getting the start and end times
//            long start = System.nanoTime();
//			//run the genetic algorithm
//			a.runGA();
//            
//            long end = System.nanoTime();
//		}
		
	}//main

///////////////////////////////////////////////////////////////////////
//gets the user's value and stores it
	private void getTarget(){
		
	}//getTarget
///////////////////////////////////////////////////////////////////////	
 //main GA loop
	private void runGA(){
		createInitialPopulation();
		
		while(!targetReached && generationCount < maxGenerations){
			createNextGeneration();
		}
	}//runGA
///////////////////////////////////////////////////////////////////////////
 //creates a new population of Individuals
	private void createNextGeneration() {
		
		int parent1, parent2;
		
		newPopulation = new Song[populationSize];
		
		for(int i=0; i<populationSize; i++){
			
			parent1 = selectParent();
			parent2 = selectParent();
			
			newPopulation[i] = new Song(population[parent1], population[parent2]);
			
			//if the current guys formula is a solution, change our flag variable
			if(newPopulation[i].fitness == 0){
				targetReached = true;
				solutionGuy = i;
			} 
		}
		
		population = newPopulation;
		generationCount++;
		

	}//createNextGeneration

/////////////////////////////////////////////////////////////////////
//selects one parent using a tournament
	private int selectParent() {
		
	     int parent, //the index of the parent we want to return
	     tourneySize = 2;
	     
	     //array to hold the participants' indexes
	     int []tourneyGuys = new int[tourneySize];

	     //get the tournament participants
	     for(int i=0; i<tourneySize; i++){
	          tourneyGuys[i] = Song.rand.nextInt(populationSize);
	     }
	     
	     parent = 0;
	     
	     //find participant with highest fitness
	     for(int i=0; i<tourneySize; i++)
	           if(population[tourneyGuys[i]].fitness < population[tourneyGuys[parent]].fitness)
	                parent = i;
	     
	     //return winners index
	     return tourneyGuys[parent];
	}//selectParent
    
//////////////////////////////////////////////////////////////////////
//this method only creates generation 1
//all the individuals are given random formulas
	private void createInitialPopulation(){
		
		population = new Song[populationSize];
		
		//uses the individual's no-argument constructor, which makes random formulas
		for(int i=0; i<populationSize; i++){
			//population[i] = new Song();
		}
	}//createInitialPopulation
}

