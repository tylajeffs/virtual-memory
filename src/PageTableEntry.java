public class PageTableEntry {

    boolean inMemory;
    boolean isValid;
    

    //constructor
    public PageTableEntry() {
        inMemory = false;
        isValid = false;
    }

    public boolean getInMemory() {
        return inMemory;
    }

    public void setInMemory(boolean inMemory) {
        this.inMemory = inMemory;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    

    @Override
    public String toString() {
        return "isValid: " + isValid + "  --  inMemory " + inMemory;
    }
}