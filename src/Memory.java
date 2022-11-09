public class Memory {

    //array of 30 page table entries
    PageTableEntry[] entries = new PageTableEntry[30];
    int currentPageFrameIndex;

    //constructor
    public Memory() {
        currentPageFrameIndex = 0;

        //initialize all array entries to null
        for(int i=0; i<30; i++) {
            entries[i] = null;
        }
    }

    /**
     * method to put new entries into memory
     * @param needsMemory
     */
    public void putIntoMemory(PageTableEntry needsMemory) {


        //get the first free frame and store it
        if(entries[currentPageFrameIndex] == null) {
            //the slot is empty, fill it
            entries[currentPageFrameIndex] = needsMemory;
        } else {
            //the slot is already full. kick the other page out of memory and then refill it
            entries[currentPageFrameIndex].setInMemory(false);
            entries[currentPageFrameIndex] = needsMemory;
        }
        

        //increment the counter
        currentPageFrameIndex++;

        //if the counter is above 30, start over
        if(currentPageFrameIndex > 29) {
            currentPageFrameIndex = 0;
        }

    }
}
