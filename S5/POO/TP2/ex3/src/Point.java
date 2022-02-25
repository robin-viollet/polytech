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

    public Point projX(){

        return new Point(x, 0);

    }

    public Point projY(){

        return new Point(0, y);

    }

    public double distanceP(Point p){

        return Math.sqrt(Math.pow(x - p.getAbscisse(), 2) + Math.pow(y - p.getOrdonnee(), 2));

    }

    @Override
    public String toString(){

        return "(" + x + " ; " + y + ')';

    }

    @Override
    public boolean equals(Object o){

        if (!(o instanceof Point)) return false;

        double epsilon = 0.1;
        Point point = (Point) o;

        return x - point.x <= epsilon && y - point.y <= epsilon;

    }
}
