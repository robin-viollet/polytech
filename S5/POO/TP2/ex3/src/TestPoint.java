public class TestPoint {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD2   - ex3                                        *\n" +
                "* ----------------------------------------------------------- *\n");

        Point A = new Point(1.0, 1.0);
        Point B = new Point(5.0, 4.0);
        Point C = new Point(0.3333333333333333, 3.141592);
        Point D = new Point(0.3333333, 3.141592653589793);

        System.out.println("point A " + A);
        System.out.println("point B " + B);
        System.out.println("point C " + C);
        System.out.println("point D " + D);
        System.out.println();
        System.out.println("projection du point A sur abscisses X = " + A.projX());
        System.out.println("projection du point A sur ordonnées Y = " + A.projY());
        System.out.println("projection du point B sur abscisses X = " + B.projX());
        System.out.println("projection du point B sur ordonnées Y = " + B.projY());
        System.out.println();
        System.out.println("point A =?= A " + A.equals(A));
        System.out.println("point A =?= C " + A.equals(C));
        System.out.println("point C =?= D " + C.equals(D));

    }
}
