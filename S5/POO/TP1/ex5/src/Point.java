public class Point {

    public Point(){

        x = 0;
        y = 0;

    }

    public Point(double x, double y){

        this.x = x;
        this.y = y;

    }

    private final double x;
    private final double y;

    public double getAbscisse(){

        return x;

    }

    public double getOrdonnee(){

        return y;

    }

    public double distanceP(Point p){

        return Math.sqrt(Math.pow(x - p.getAbscisse(), 2) + Math.pow(y - p.getOrdonnee(), 2));

    }

    @Override
    public String toString(){

        return "(" + x + " ; " + y + ')';

    }
}
