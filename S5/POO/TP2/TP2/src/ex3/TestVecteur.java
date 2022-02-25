package ex3;

public class TestVecteur {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD2 - ex3                                          *\n" +
                "* ----------------------------------------------------------- *\n");

        Point pointA = new Point(1.0, 0.0);
        Point pointB = new Point(2.0, 3.0);
        Point pointC = new Point(0.0, 2.0);
        Point pointD = new Point(2.0, 4.0);

        Vecteur vecteurNull = new Vecteur();
        Vecteur AB = new Vecteur(pointA, pointB);
        Vecteur BC = new Vecteur(pointB, pointC);
        Vecteur AC = new Vecteur(pointA, pointC);
        Vecteur CD = new Vecteur(pointC, pointD);

        Vecteur CA = new Vecteur(pointC, pointA);

        System.out.println("Vecteur null " + vecteurNull);
        System.out.println("Vecteur AB " + AB);
        System.out.println("Vecteur BC " + BC);
        System.out.println("Vecteur AC " + AC);
        System.out.println("Vecteur CD " + CD);
        System.out.println();

        System.out.println("-------- norme ----------");
        System.out.println("norme de ||AB|| " + AB.getNorme());
        System.out.println();

        System.out.println("-------- addition ----------");
        System.out.println("Vecteurs AB + AC = " + AB.ajouter(AC));
        System.out.println("Vecteurs AB + CA = " + AB.ajouter(CA));
        System.out.println();

        System.out.println("-------- milieu ----------");
        System.out.println("milieu de AB = " + AB.milieu());
        System.out.println("milieu de AC = " + AC.milieu());
        System.out.println();

        System.out.println("-------- homothétie ----------");
        System.out.println("AC*2 = " + AC.mul(2));
        System.out.println("BC*2 = " + BC.mul(2));
        System.out.println("AB*0.5 = " + AB.mul(0.5));
        System.out.println();

        System.out.println("-------- translation ----------");
        System.out.println("translation de AB par AC = " + AB.translate(AC));
        System.out.println();

        System.out.println("-------- symétrie ----------");
        System.out.println("symétrie de AB par C = " + AB.sym(pointC));
        System.out.println();

        System.out.println("-------- colinéarité ----------");
        System.out.println("Vecteur colinéaire ?  AB x CD ==> " + AB.colineaire(CD));
        System.out.println("Vecteur colinéaire ?  AB x AC ==> " + AB.colineaire(AC));

    }
}
