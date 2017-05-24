public class Instrument {
    public String name;
    public boolean canPlayChords;
    public static int numInstruments = 2;
    public String[] range;
    
    public Instrument(){
        int num = Song.rand.nextInt(numInstruments);
        
        switch(num){
            case 0:{
                name = "piano";
                canPlayChords = true;
                range = new String[]{"A0", "C8"};
                break;
            }
            case 1:{
                name = "guitar";
                canPlayChords = true;
                range = new String[]{"E3", "E6"};
                break;
            }
//            case 2:{
//                name = "trumpet";
//                canPlayChords = false;
//                range = new String[]{"Gb3", "D6"};
//                break;
//            }
//            case 3:{
//                name = "alto saxophone";
//                canPlayChords = false;
//                range = new String[]{"Db3", "Ab5"};
//                break;
//            }
//            case 4:{
//                name = "flute";
//                canPlayChords = false;
//                range = new String[]{"C4", "D7"};
//                break;
//            }
        }     
    }
}
