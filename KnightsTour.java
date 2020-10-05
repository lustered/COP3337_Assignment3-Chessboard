import java.awt.Point; // To start the knight at a non-default position.

/**
 * Conducts the Knight's Tour.  
 */
public class KnightsTour
{
    // Number of moves of the longest tour
    private int bestTour ; 
    private ChessBoard bestBoard ;  
    private int[][] tourRecords  ; 

    /**
     * Create a tour, initialize records table and best tour. 
     */
    public KnightsTour(int tours)
    {
        tourRecords = new int[tours][64]  ; 
        bestBoard = new ChessBoard() ; 
        bestTour = 0  ; 
    }
    public KnightsTour()
    {
        // Set one tour as default for the noarg constructor
        this(1);
    }
    
    /**
     * Can conduct a tour, I.e, create ChessBoard and Knight objects, place the Knight
     * on the board, and have the Knight move until there are no more legal moves.
     */
    public void conductTour(int tourNum)
    {
        // count variables
        int tourMoves = 1  ; 

        // Reset board, needed in case multiple tours are ran.
        ChessBoard board = new ChessBoard()  ; 
        Knight knight = new Knight()  ; 

        /* Set the knight at the initial position .
        * The Knight's position is default to (0,0).
        * If you want to start the knight at another position
        * pass a Point object with the position.
        *
        * Eg. Point position = new Point(3,5) ;
        * knight.move(board, position, tourMove)
        */
        knight.move(board, knight.getPosition(), 1) ; 


        while(knight.canMove(board) && tourMoves < 64)
        {
            System.out.println(tourMoves);
            knight.move(board, knight.getPosition(),++tourMoves)  ; 
        }
        
        // Increase the tour's length count by 1 
        tourRecords[tourMoves]++;

        System.out.println("asdasdasd" + tourNum);
        if(tourMoves > tourRecords[bestTour])
        {
            bestTour =  tourRecords[tourMoves] ;
            bestBoard = board ; 

        } 

        tourMoves = 1 ;
       
    }
    public String bestTourResult()
    {
        String divider = new String(new char[40]).replace("\0", "-") ; 
        String ret = "" ; 

        ret += String.format("%15s%2s\n" ,"Best Tour Moves: " , bestTour) ; 
        // ret += "\tNumber of Moves: " + bestTour  ; 

        ret += bestTour == 63 ? " (a complete tour)\n" : "\n" ; 

        
        // All the tour records
        for(int i = 0 ; i < tourRecords.length ; i++)
            if(tourRecords[i] != 0)
                ret += String.format("Tour: %2s Moves: %2s\n", tourRecords[i], i) ;
       
        ret += bestBoard.toString();

        // System.out.format("%15s%15s\n", "Moves", "Count");
        ret += "\n\n" + divider ; 

        return ret ; 
    }
    
}
