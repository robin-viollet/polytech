package exercice6;

public class TestRestaurant {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD3 - ex6                                          *\n" +
                "* ----------------------------------------------------------- *");

        Restaurant fred = new Restaurant("Chez Fred", 1970);
        Restaurant cantine = new Restaurant("La cantine", 1972);
        Restaurant jarrerie = new Restaurant("La jarrerie", 2019);
        Restaurant miam = new Restaurant("Le miam", 2019);

        System.out.println(fred);
        System.out.println(cantine);
        System.out.println(jarrerie);
        System.out.println(miam);

    }
}
