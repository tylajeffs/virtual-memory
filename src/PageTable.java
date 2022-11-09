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


}
