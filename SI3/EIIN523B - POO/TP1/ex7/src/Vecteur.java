public class Vecteur {

    public Vecteur(){

        this.pointA = new Point();
        this.pointB = new Point();

    }

    public Vecteur(Point pointA, Point pointB){

        this.pointA = pointA;
        this.pointB = pointB;

    }

    // TODO Norme du vecteur
    //Addition avec un autre vecteur
    //Millieu du vecteur
    //Homothétie
    //Translation
    //Symétrie
    //Colinéaire

    private final Point pointA;
    private final Point pointB;

    public Point getPointA(){

        return pointA;

    }

    public Point getPointB(){

        return pointB;

    }

    public double getNorme(){

        return Math.sqrt(Math.pow(pointA.getAbscisse() - pointB.getAbscisse(), 2)
                + Math.pow(pointA.getOrdonnee() - pointB.getOrdonnee(), 2));

    }

    public Vecteur ajouter(Vecteur vec){

        Point pointA = new Point(this.pointA.getAbscisse(), this.pointA.getOrdonnee());
        Point pointB = new Point(this.pointB.getAbscisse() + (vec.pointB.getAbscisse() - vec.pointA.getAbscisse()),
                this.pointB.getOrdonnee() + (vec.pointB.getOrdonnee() - vec.pointA.getOrdonnee()));

        return new Vecteur(pointA, pointB);

    }

    public Point milieu(){

        return new Point(pointA.getAbscisse() + (pointB.getAbscisse() - pointA.getAbscisse()) / 2,
                pointA.getOrdonnee() + (pointB.getOrdonnee() - pointA.getOrdonnee()) / 2);

    }

    public Vecteur mul(double d){

        Point pointA = new Point(this.pointA.getAbscisse(), this.pointA.getOrdonnee());
        Point pointB = new Point(
                this.pointA.getAbscisse() + (this.pointB.getAbscisse() - this.pointA.getAbscisse()) * d,
                this.pointA.getOrdonnee() + (this.pointB.getOrdonnee() - this.pointA.getOrdonnee()) * d);

        return new Vecteur(pointA, pointB);

    }

    public Vecteur translate(Vecteur vec){

        Point pointA = new Point(
                this.pointA.getAbscisse() + (vec.pointB.getAbscisse() - vec.pointA.getAbscisse()),
                this.pointA.getOrdonnee() + (vec.pointB.getOrdonnee() - vec.pointA.getOrdonnee()));
        Point pointB = new Point(
                this.pointB.getAbscisse() + (vec.pointB.getAbscisse() - vec.pointA.getAbscisse()),
                this.pointB.getOrdonnee() + (vec.pointB.getOrdonnee() - vec.pointA.getOrdonnee()));

        return new Vecteur(pointA, pointB);

    }

    public Vecteur sym(Point p){

        Point pointA = new Point(
                2 * p.getAbscisse() - this.pointA.getAbscisse(),
                2 * p.getOrdonnee() - this.pointA.getOrdonnee());
        Point pointB = new Point(
                2 * p.getAbscisse() - this.pointB.getAbscisse(),
                2 * p.getOrdonnee() - this.pointB.getOrdonnee());

        return new Vecteur(pointA, pointB);

    }

    public boolean colineaire(Vecteur vec){

        return (pointB.getAbscisse() - pointA.getAbscisse()) * (vec.pointB.getOrdonnee() - vec.pointA.getOrdonnee())
                == (pointB.getOrdonnee() - pointA.getOrdonnee()) * (vec.pointB.getAbscisse() - vec.pointA.getAbscisse());

    }

    @Override
    public String toString(){

        return "( " + pointA + " ; " + pointB + " )";

    }
}
