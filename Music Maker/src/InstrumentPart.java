import java.util.ArrayList;

public class InstrumentPart {
    public ArrayList<Bar> bars;
    public Instrument instrument;
       
    public InstrumentPart(Instrument instr){
        instrument = instr; 
        bars = new ArrayList();
    }
    
    public InstrumentPart(InstrumentPart p1, InstrumentPart p2, int c1, int c2, int choice1, int choice2){
        if(p1.instrument != p2.instrument){
            System.out.println("error, parent parts have different instruments");
            System.exit(1);
        }
        
        instrument = p1.instrument; 
        
        bars = new ArrayList();
        
        if(choice1 == 0){
            if(choice2 == 0){
                for(int i=0; i<=c1; i++){
                    this.bars.add(p1.bars.get(i));
                }
                for(int i=0; i<=c2; i++){
                    this.bars.add(p2.bars.get(i));
                }                
//                System.out.println("From parent1, copied bars: 1-" + (c1+1));
//                System.out.println("From parent2, copied bars: 1-" + (c2+1));
//                System.out.println("Total bars of child: " + (c1+c2+2));
            }
            else{
                for(int i=0; i<=c1; i++){
                    this.bars.add(p1.bars.get(i));
                }
                for(int i=c2; i<p2.bars.size(); i++){
                    this.bars.add(p2.bars.get(i));
                }  
//                System.out.println("From parent1, copied bars: 1-" + (c1+1));
//                System.out.println("From parent2, copied bars: " + (c2+1) + "-" + p2.bars.size());  
//                System.out.println("Total bars of child: " + (c1+1+(p2.bars.size()-(c2+1))));
            }  
        }
        else{
            if(choice2 == 0){
                for(int i=c1; i<p1.bars.size(); i++){
                    this.bars.add(p1.bars.get(i));
                }
                for(int i=0; i<=c2; i++){
                    this.bars.add(p2.bars.get(i));
                } 
//                System.out.println("From parent1, copied bars: " + (c1+1) + "-" + p1.bars.size());
//                System.out.println("From parent2, copied bars: 1-" + (c2+1)); 
//                System.out.println("Total bars of child: " + ((p1.bars.size()-(c1+1))+c2+1));
            }
            else{
                for(int i=c1; i<p1.bars.size(); i++){
                    this.bars.add(p1.bars.get(i));
                } 
                for(int i=c2; i<p2.bars.size(); i++){
                    this.bars.add(p2.bars.get(i));
                }   
//                System.out.println("From parent1, copied bars: " + (c1+1) + "-" + p1.bars.size());
//                System.out.println("From parent2, copied bars: " + (c2+1) + "-" + p2.bars.size()); 
//                System.out.println("Total bars of child: " + ((p1.bars.size()-(c1+1))+(p2.bars.size()-(c2+1))));
            }            
        }        
    }
    
}
