package ex4;

public class Segment {

    public Segment(Point origine, Point extremite){

        this.origine = origine;
        this.extremite = extremite;

    }

    private Point origine;
    private Point extremite;

    public Point getOrigine(){

        return new Point(origine.getAbscisse(), origine.getOrdonnee());

    }

    public Point getExtremite(){

        return new Point(extremite.getAbscisse(), extremite.getOrdonnee());

    }

    double longueur(){

        return Math.sqrt(
                Math.pow(origine.getAbscisse() - extremite.getAbscisse(), 2) +
                Math.pow(origine.getOrdonnee() - extremite.getOrdonnee(), 2));

    }

    Segment projX(){

        return new Segment(origine.projX(), extremite.projX());

    }

    Segment projY(){

        return new Segment(origine.projY(), extremite.projY());

    }

    @Override
    public String toString(){

        return "[ " + origine + " ; " + extremite + " ]";

    }
}
