public class TestPoint {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD1   - ex6                                        *\n" +
                "* ----------------------------------------------------------- *\n");

        Point A = new Point(1.0, 1.0);
        Point B = new Point(5.0, 4.0);

        System.out.println("point A " + A);
        System.out.println("point B " + B);
        System.out.println();
        System.out.println("projection du point A sur abscisses X = " + A.projX());
        System.out.println("projection du point A sur ordonnées Y = " + A.projY());
        System.out.println("projection du point B sur abscisses X = " + B.projX());
        System.out.println("projection du point B sur ordonnées Y = " + B.projY());

    }
}
