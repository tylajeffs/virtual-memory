import java.util.Arrays;
import java.util.Scanner;


public class Main {

    //global variables
    static int accesses = 0;
    static int hits = 0;
    static int misses = 0;
    static int compMisses = 0;
    static int currentPageTable = 0;


    public static void main(String[] args) {

        //create scanner to read file
        Scanner s = new Scanner(System.in);

        //read through every line 
        while(s.hasNextLine()) {

            //store the instruction and the bits
            String line = s.nextLine();
            String instruction = line.split(" ")[0];
            int num = Integer.parseInt(line.split(" ")[1]);

            //CHANGE THE BITS DOWN??

            //check the instruction
            if(instruction == "new") {
                //create a new page table

            } else if(instruction == "switch") {
                //switch page tables
                currentPageTable = num;

            } else if(instruction == "access") {
                //access the memory

            }

        }

        //close scanner
        s.close();


  
        //print out sum, median, and mean
        System.out.println("sum: " + sum);
        System.out.println("mean: " + mean);
        System.out.println("median: " + median);

    }
}
