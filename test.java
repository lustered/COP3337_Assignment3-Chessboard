
public class test
{
    public static void main(String[] args) {
        int tmp = 10 ;
        KnightsTour tour1 = new KnightsTour(tmp);

        for(int i = 0 ; i < tmp ; i++)
            tour1.conductTour(i);
        
        System.out.println(tour1.bestTourResult());


    }
}
