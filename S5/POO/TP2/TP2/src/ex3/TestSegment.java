package ex3;

public class TestSegment {

    public static void main(String[] args){

        System.out.println("* ------------------------------------------------------------------------------- *\n" +
            "* TP java                                                        *\n" +
            "*                                                                *\n" +
            "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr    *\n" +
            "* @version TD2   - ex3                                           *\n" +
            "* -------------------------------------------------------------- *\n");

        Point A = new Point(1.0, 1.0);
        Point B = new Point(2.0, 5.0);

        Segment AB = new Segment(A, B);
        Segment S = new Segment(new Point(0.0, 0.0), new Point(0.0, 1.0));

        System.out.println("point A " + A);
        System.out.println("point B " + B);
        System.out.println("segment AB=" + AB);
        System.out.println("segment S=" + S);
        System.out.println();
        System.out.println("---------- longueur");
        System.out.println("longueur du segment AB=" + AB.longueur());
        System.out.println();
        System.out.println("---------- projetés");
        System.out.println("projX du segment AB=" + AB.projX());
        System.out.println("projY du segment AB=" + AB.projY());

    }
}
