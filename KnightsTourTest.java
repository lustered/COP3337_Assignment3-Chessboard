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
     * @param args kargs to pass.
     */
    public static void main(String[] args) {
        // Create tour.
        KnightsTour tour1 = new KnightsTour();

        // Run n tours.
        int n = 1000 ;
        for(int i = 0 ; i < n ; i++)
            tour1.conductTour();
        
        // Print results
        System.out.println(tour1);
        
        // Writing to file 
        try
        {
            PrintWriter output = new PrintWriter("TourResults.txt") ;
            output.write(tour1.toString()) ;
            output.close() ;
        }
        catch (Exception e) {
            System.out.println("File error: " + e);
        }
    }
}
