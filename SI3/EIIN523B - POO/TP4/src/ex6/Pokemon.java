package ex6;

public class Pokemon {

    public enum Type {
        EAU,
        FEU,
        PLANTE,
        INSECTE
    }

    private final String name;
    private final Type type;
    private int hp;
    private final int ap;
    private final int dp;

    public Pokemon(String name, Type type, int hp, int ap, int dp){

        this.name = name;
        this.type = type;
        this.hp = hp;
        this.ap = ap;
        this.dp = dp;

    }

    public String getName(){

        return name;

    }

    public Type getType(){

        return type;

    }

    public int getHp(){

        return hp;

    }

    public int getAp(){

        return ap;

    }

    public int getDp(){

        return dp;

    }

    public boolean isKo(){

        return hp <= 0;

    }

    private void addHp(int amount){

        this.hp = Math.max(hp + amount, 0);

        if (isKo()){

            System.out.println(name + " is dead!");

        }
    }

    public static void vs(Pokemon card1, Pokemon card2){

        //Aux points de vie de chaque combattant on soustrait les point d’attaque de l’adversaire
        //et on ajoute ses propres points de défense

        card1.addHp(-card2.ap + card1.dp);
        card2.addHp(-card1.ap + card2.dp);

        if (card1.isKo() && card2.isKo()){

            System.out.println("\t===> Both pokemons are KO!");

        } else if (card1.isKo()){

            System.out.println("\t===> " + card2);

        } else if (card2.isKo()){

            System.out.println("\t===> " + card1);

        } else {

            System.out.println("\t===> " + card1 + " and " + card2);

        }

        System.out.println();

    }

    @Override
    public String toString(){

        return name + " (life=" + hp + ", attack=" + ap + ", defense=" + dp + ")";

    }
}
