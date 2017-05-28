
public class TSig {
    public int top;
    public int bottom;
    
    public TSig(int t, int b){
        top = t;
        bottom = b;
    }
    
    public boolean equals(TSig other){
        if(other.top == this.top && other.bottom == this.bottom) return true;
        else return false;
    }
}
