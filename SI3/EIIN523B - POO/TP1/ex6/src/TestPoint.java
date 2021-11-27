public class TestPoint {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                            "* TP java                                                     *\n" +
                            "*                                                             *\n" +
                            "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                            "* @version TD1 - ex6                                          *\n" +
                            "* ----------------------------------------------------------- *\n");

        Point pointA = new Point(1.0, 1.0);
        Point pointB = new Point(5.0, 4.0);

        System.out.println("projection du point A sur abscisses X = " + pointA.projX());
        System.out.println("projection du point A sur ordonnées Y = " + pointA.projY());
        System.out.println("projection du point B sur abscisses X = " + pointB.projX());
        System.out.println("projection du point B sur ordonnées Y = " + pointB.projY());

    }
}
