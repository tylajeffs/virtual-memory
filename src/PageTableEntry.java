public class PageTableEntry {

    int pageTableId;
    boolean inMemory;
    

    //constructor
    public PageTableEntry() {
        inMemory = false;
    }

    public boolean getInMemory() {
        return inMemory;
    }

    public void setInMemory(boolean inMemory) {
        this.inMemory = inMemory;
    }
    
}