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
    static int compMisses = 0;
    static int currentPageTable = 0;


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
                int num = Integer.parseInt(line.split(" ")[1]);

                //check the instruction
                if(instruction == "new") {
                    //we've already created all the page tables, so we don't need to worry about that here
                    currentPageTable = num;

                } else if(instruction == "switch") {
                    //switch page tables
                    currentPageTable = num;

                } else if(instruction == "access") {
                    //move the int down so we have a number between 0-63
                    num = num >> 10;

                    
                }

            }

            //close scanner
            s.close();














        } catch(FileNotFoundException e) {
            System.out.println("Error! ");
            e.printStackTrace();
        }
        

        



        //print out sum, median, and mean
        System.out.println("sum: " );
        System.out.println("mean: " );
        System.out.println("median: ");

    }


    /**
     * method to get the current page table
     * @param n the id of the page table
     * @return the correct page table
     */
    public PageTable getCurrentPageTable(int n) {
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
