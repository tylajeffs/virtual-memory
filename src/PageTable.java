import java.util.ArrayList;

public class PageTable {
    
    PageTableEntry[] pages = new PageTableEntry[64];
    int pageTableId;


    //constructor
    public PageTable(int id) {

        //set the id
        pageTableId = id;

        //create 64 page table entries and store them in an array
        for(int i=0; i<64; i++) {
            PageTableEntry p = new PageTableEntry();
            pages[i] = p;
        }
    }

    /**
     * method to find the correct page table entry given the index
     * @param n index
     * @return page table entry
     */
    public PageTableEntry getPageTableEntry(int n) {
        PageTableEntry p = null;

        System.out.println("n =  " + n);


        //find the page table entry at the index
        for(int i=0; i<64; i++) {
            if(n == i) {
                p = pages[i];
                System.out.println("return value is now " + p);
            }
        }

        return p;
    }

    /**
     * getter to get the id of the page table
     * @return
     */
    public int getId() {
        return pageTableId;
    }


    @Override
    public String toString() {
        return "" + this.pageTableId;
    }

}
