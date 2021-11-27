package exercice8;

import java.util.ArrayList;

public class TestDatabase {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD3 - ex8                                          *\n" +
                "* ----------------------------------------------------------- *");

        Database database = new Database();

        Restaurant fred = new Restaurant("Chez Fred", 1970);
        Restaurant cantine = new Restaurant("La cantine", 1972);
        Restaurant jarrerie = new Restaurant("La jarrerie", 2017);
        Restaurant miam = new Restaurant("Le miam", 2019);

        database.addRestaurant(fred);
        database.addRestaurant(cantine);
        database.addRestaurant(jarrerie);
        database.addRestaurant(miam);

        ArrayList<Restaurant> rapidDistributors = new ArrayList<>();

        rapidDistributors.add(cantine);
        rapidDistributors.add(miam);

        Menu rapid = new Menu("Rapide", fred, rapidDistributors);

        database.addMenu(rapid);

        System.out.println(database.getProspects(rapid));

    }
}
