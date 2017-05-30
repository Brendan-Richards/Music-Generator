import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Song {
    
    //music stuff
    public InstrumentPart[] parts;
    public Section[] sections;
    private static String[] sectionTypes = {"ChordMelody", "MultiMelody", "Solo"};
    private static float mutationChance = .1f;
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
    private int numberOfNoteMutations = 5;
	
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
        
        findnumBeats();
            
        mutate();
        calcFitness();
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
        
        findnumBeats();
        
        //System.out.println("Time Signiture of child: " + this.firstTSig.top + "/" + this.firstTSig.bottom);
        mutate();
        calcFitness();
	}
    
    private void findnumBeats(){
        
    }
    
//plays the song using JFugue
    public void play(){
        JMusicStuff.play(this);
    }
    public void save(String fileName){
        JMusicStuff.save(this, fileName);
    }

////////////////////////////////////////////////////////////////
//fitness is calculated in the following way:
	private void calcFitness() {

	}

///////////////////////////////////////////////////////////////////
//mutates an individual
	private void mutate() {
        
        float chance = rand.nextFloat();
        
        if(chance < mutationChance){
            int mutationType = rand.nextInt(2);

            switch(mutationType){
                case 0:{//individual note changes
                    for(int i=0; i<parts.length; i++){
                        int low=0, high=0;
                        for(int j=0, k=NoteList.notes.length-1; j<NoteList.notes.length; j++, k-- ){
                            if(NoteList.notes[j].equals(parts[i].instrument.range[0]))
                                low = j;
                            if(NoteList.notes[k].equals(parts[i].instrument.range[1]))
                                high = k+1;
                        }   
                        //get instrument's range
                        String[] possibleNotes = Arrays.copyOfRange(NoteList.notes, low, high);
                        
                        for(int m=0; m<numberOfNoteMutations; m++){
                            //randomly select a bar
                            int a = rand.nextInt(parts[i].bars.size());
                            //randomly select a beat from within that bar
                            int b = rand.nextInt(parts[i].bars.get(a).beats.size());
                            
                            boolean makeChord = rand.nextBoolean();
                            
                            if(!makeChord){                             
                                SingleNote n = new SingleNote(possibleNotes);
                                n.type = parts[i].bars.get(a).beats.get(b).type;
                                
                                Beat c = new Beat(n);
                                parts[i].bars.get(a).beats.set(b, c);
                                
                            }else{
                                SingleNote n = new SingleNote(possibleNotes);
                                n.type = parts[i].bars.get(a).beats.get(b).type;
                                if(!n.isRest){
                                    SingleNote[] myNotes = Bar.getOthers(n, possibleNotes);
                                    Beat c = new Beat(myNotes);
                                    parts[i].bars.get(a).beats.set(b, c);
                                }else{
                                    Beat c = new Beat(n);
                                    parts[i].bars.get(a).beats.set(b, c);
                                }
                              
                            }
                            
                        }
                    }
                }
                case 1:{//bar swaps
                    //swap 2 bars in each part
                    for(int i=0; i<parts.length; i++){
                        int first = rand.nextInt(this.parts[i].bars.size());
                        int second;
                        do{
                            second = rand.nextInt(this.parts[i].bars.size());
                        }while(second == first);
                        
                        Bar temp = this.parts[i].bars.get(first);
                        this.parts[i].bars.set(first, this.parts[i].bars.get(second));
                        this.parts[i].bars.set(second, temp);
                    }
                }

            }        
        }

	}
}


