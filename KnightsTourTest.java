public class test
{
    public static void main(String[] args) {
        int runs = 100000 ;
        KnightsTour tour1 = new KnightsTour();

        for(int i = 0 ; i < runs ; i++)
            tour1.conductTour();
        
        System.out.println(tour1.bestTourResult());


    }
}
