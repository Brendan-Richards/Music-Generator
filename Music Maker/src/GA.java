import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class GA {

	protected static int target;//the fitness value that is acceptable
        
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
	
	private int maxGenerations = 1000;//number of Individuals in the population

	private final int populationSize = 100;
    
    public static int maxBeats = 32;

	
/////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {	
        
        int numParts = Song.rand.nextInt(maxParts)+1;
        Instrument []insts = new Instrument[numParts];
        for(int i=0; i<numParts; i++){
            insts[i] = new Instrument();
        }

        int bottom = (int)Math.pow(2, (Song.rand.nextInt(3)+2));
        int top = Song.rand.nextInt(maxBeats)+1;
        
        Song b = new Song(insts, top, bottom);
        System.out.println(b.toString());
//        Song c = new Song(insts, top, bottom);
//        b.save("parent1");
//        c.save("parent2");
//        Song d = new Song(b, c);
//        d.save("child");

        
//		while(!done){
//			GA a = new GA();
//			//get the target value from the user
//			a.getTarget();
//            //time the GA run by getting the start and end times
//            long start = System.nanoTime();
//			//run the genetic algorithm
//			a.runGA(insts, top, bottom);
//            
//            long end = System.nanoTime();
//		}
		
	}//main

///////////////////////////////////////////////////////////////////////
//gets the user's value and stores it
	private void getTarget(){
		System.out.println("Target fitness value: ");
        target = keyboard.nextInt();
	}//getTarget
///////////////////////////////////////////////////////////////////////	
 //main GA loop
	private void runGA(Instrument[] insts, int top, int bottom){
		createInitialPopulation(insts, top, bottom);
		
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
			if(newPopulation[i].fitness >= target){
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
		
	     int parent = 0, //the index of the parent we want to return
	     tourneySize = 20;
	     
	     //array to hold the participants' indexes
	     int []tourneyGuys = new int[tourneySize];

	     //get the tournament participants
	     for(int i=0; i<tourneySize; i++){
	          tourneyGuys[i] = Song.rand.nextInt(populationSize);
	     }
	     
	     //find participant with highest fitness
	     for(int i=0; i<tourneySize; i++)
	           if(population[tourneyGuys[i]].fitness > population[tourneyGuys[parent]].fitness)
	                parent = i;
	     
	     //return winners index
	     return tourneyGuys[parent];
	}//selectParent
    
//////////////////////////////////////////////////////////////////////
//this method only creates generation 1
//all the individuals are given random formulas
	private void createInitialPopulation(Instrument[] insts, int top, int bottom){
		
		population = new Song[populationSize];
		
		for(int i=0; i<populationSize; i++){
			population[i] = new Song(insts, top, bottom);
		}
	}//createInitialPopulation
}

