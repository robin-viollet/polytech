package exercice7;

import java.util.ArrayList;

public class TestMenu {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD3 - ex7                                          *\n" +
                "* ----------------------------------------------------------- *");

        Restaurant fred = new Restaurant("Chez Fred", 1970);
        Restaurant cantine = new Restaurant("La cantine", 1972);
        Restaurant jarrerie = new Restaurant("La jarrerie", 2018);
        Restaurant miam = new Restaurant("Le miam", 2019);

        ArrayList<Restaurant> prestigeDistributors = new ArrayList<>();
        ArrayList<Restaurant> rapidDistributors = new ArrayList<>();

        rapidDistributors.add(cantine);
        rapidDistributors.add(miam);

        Menu prestige = new Menu("Prestige", jarrerie, prestigeDistributors);
        Menu rapid = new Menu("Rapid", fred, rapidDistributors);

        System.out.println(prestige);
        System.out.println(rapid);

    }
}
