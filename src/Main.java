import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {

    //create array of 8 page tables
    static ArrayList<PageTable> pageTables = new ArrayList<PageTable>();

    //global variables
    static int accesses = 0;
    static int hits = 0;
    static int misses = 0;
    static int compMisses = 0; //compulsory miss (will happen no matter what)
    static int currentPageTable = 0;
    static PageTable ptable = null;


    public static void main(String[] args) {

        

        //create 8 page tables
        for(int i=0; i<8; i++) {
            PageTable p = new PageTable(i);
            pageTables.add(p);
        }


        
        try {
            //create scanner to read file
            File f = new File("VMInput1.txt");
            Scanner s = new Scanner(f);

            //read through every line 
            while(s.hasNextLine()) {

                //store the instruction and the bits
                String line = s.nextLine();
                String instruction = line.split(" ")[0];

                System.out.println("instruction: " + instruction);
                int num = Integer.parseInt(line.split(" ")[1]);
                System.out.println("num: " + num);

                //check the instruction
                if(instruction == "new") {
                    //we've already created all the page tables, so we don't need to worry about that here
                    currentPageTable = num;

                } else if(instruction == "switch") {
                    //get the current page table
                    ptable = getCurrentPageTable(num);

                } else if(instruction == "access") {
                    //move the int down so we have a number between 0-63 (Page Index)
                    int pageIndex = num >> 10;

                    //check to see if the entry is valid
                    if(ptable.getPageTableEntry(pageIndex).getIsValid() == false) {
                        //not valid
                        misses++;
                        accesses++;
                        compMisses++;
                    } else {

                        //entry is valid, check to see if it is in memory
                        if(ptable.getPageTableEntry(pageIndex).getInMemory() == false) {
                            //not in memory
                            misses++;
                            accesses++;
                        } else {
                            //yes, is in memory
                            hits++;
                            accesses++;
                        }

                    }
                    


                    
                }

            }

            //close scanner
            s.close();














        } catch(FileNotFoundException e) {
            System.out.println("Error! ");
            e.printStackTrace();
        }
        

        



        //print out sum, median, and mean
        System.out.println("hits: " + hits);
        System.out.println("misses: " + misses);
        System.out.println("accesses: " + accesses);
        System.out.println("compulsory misses: " + compMisses);

    }


    /**
     * method to get the current page table
     * @param n the id of the page table
     * @return the correct page table
     */
    public static PageTable getCurrentPageTable(int n) {
        PageTable pt = null;

        //go through all the PageTables to find the right one
        for(int i=0; i<8; i++) {
            if(n == pageTables.get(i).pageTableId) {
                pt = pageTables.get(i);
            }
        }

        return pt;
    }

}
