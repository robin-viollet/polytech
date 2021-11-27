package ex4;

public class TestEntiersBornes {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD2   - ex4                                        *\n" +
                "* ----------------------------------------------------------- *\n");

        EntiersBornes e1 = new EntiersBornes(3, 5);
        EntiersBornes e2 = new EntiersBornes(3, 6);

        System.out.println("ensemble e1 = " + e1);
        System.out.println("ensemble e2 = " + e2);
        System.out.println();
        System.out.println("TEST DE LA METHODE add()");
        System.out.println("on ajoute --> 5 à e1");

        e1.add(5);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 5 (encore) à e1");

        e1.add(5);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 1 à e1");

        e1.add(1);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 2 à e1");

        e1.add(2);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 1 à e2");

        e2.add(1);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 2 à e2");

        e2.add(2);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 6 à e2");

        e2.add(6);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 3 à e2");

        e2.add(3);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 4 à e2");

        e2.add(4);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("on ajoute --> 5 à e2");

        e2.add(5);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("TEST DE LA METHODE remove()");
        System.out.println("on supprime --> 4 à e2");

        e2.remove(4);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println("on supprime --> 3 à e2");

        e2.remove(3);

        System.out.println("-->  ensemble  e1 = " + e1);
        System.out.println("-->  ensemble  e2 = " + e2);
        System.out.println();
        System.out.println("TEST DE LA METHODE union()");
        System.out.println("ensemble e1 = " + e1);
        System.out.println("ensemble e2 = " + e2);
        System.out.println("--> ensemble e1 UNION e2 = " + e1.union(e2));
        System.out.println();
        System.out.println("TEST DE LA METHODE intersect()");
        System.out.println("ensemble e1 = " + e1);
        System.out.println("ensemble e2 = " + e2);
        System.out.println("--> ensemble e1 INTER e2 = " + e1.inter(e2));

    }
}
