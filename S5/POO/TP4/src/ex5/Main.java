package ex5;

public class Main {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD4 - ex2                                          *\n" +
                "* ----------------------------------------------------------- *");

        ClockDisplay clockDisplay = new ClockDisplay();

        System.out.println("clockDisplay.getTime() = " + clockDisplay.getTime());

        for (int i = 0; i < 1000; ++i){

            clockDisplay.timeTick();

        }

        System.out.println("clockDisplay.getTime() = " + clockDisplay.getTime());

        try {

            clockDisplay.setTime(14, 55);

        } catch (ClockDisplayException e){

            System.err.println(e.getMessage());

        }

        System.out.println("clockDisplay.getTime() = " + clockDisplay.getTime());

        try {

            clockDisplay.setTime(14, 75);

        } catch (ClockDisplayException e){

            System.err.println(e.getMessage());

        }

        System.out.println("clockDisplay.getTime() = " + clockDisplay.getTime());

        try {

            clockDisplay.setTime(24, 55);

        } catch (ClockDisplayException e){

            System.err.println(e.getMessage());

        }

        System.out.println("clockDisplay.getTime() = " + clockDisplay.getTime());

        // TODO Fix
//        clockDisplay.getTime() = 00:00
//        clockDisplay.getTime() = 16:40
//        clockDisplay.getTime() = 14:55
        //TODO Hours should not be set if minutes is impossible
//        clockDisplay.getTime() = 14:00
        //TODO Minutes should not be set if hours is impossible
//        clockDisplay.getTime() = 00:55

        //TODO Possible
//        ClockDisplayException error: this time (14:75) is impossible
        //TODO Possible
//        ClockDisplayException error: this time (24:55) is impossible

    }
}
