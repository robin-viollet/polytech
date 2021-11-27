public class TestPoint {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                            "* TP java                                                     *\n" +
                            "*                                                             *\n" +
                            "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                            "* @version TD1 - ex5                                          *\n" +
                            "* ----------------------------------------------------------- *\n");

        Point pointA = new Point(1.0, 1.0);
        Point pointB = new Point(5.0, 4.0);

        System.out.println("point A " + pointA);
        System.out.println("point B " + pointB);
        System.out.println("distance du point A au point B = " + pointA.distanceP(pointB));

    }
}
