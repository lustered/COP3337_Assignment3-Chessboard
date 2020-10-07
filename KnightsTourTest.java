/*
Carlos Luis
U08
KnightsTourTest.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

import java.io.PrintWriter;
/**
 * Testing class for the Knight's Tour Problem.   
 */
public class KnightsTourTest
{
    /**
     * Main driver.
     *
     * @param args Args for runtime.
     */
    public static void main(String[] args) {
        int runs = 100000 ;
        // Create tour.
        KnightsTour tour1 = new KnightsTour();

        // Run it.
        for(int i = 0 ; i < runs ; i++)
            tour1.conductTour();
        
        // Print results
        System.out.println(tour1.bestTourResult());
        
        // Writing to file 
        try
        {
            PrintWriter output = new PrintWriter("TourResults.txt") ;
            output.write(tour1.bestTourResult()) ;
            output.close() ;
        }
        catch (Exception e) {
            System.out.println("File error " + e);
        }


    }
}
