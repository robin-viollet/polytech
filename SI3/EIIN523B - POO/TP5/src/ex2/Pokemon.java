package ex2;

public enum Pokemon {
    SALAMECHE(TypePokemon.FEU, 5, 4),
    ODDISH(TypePokemon.PLANTE, 2, 6),
    VENONAT(TypePokemon.INSECTE, 9, 1),
    TENTACOOL(TypePokemon.EAU, 0, 0);

    Pokemon(TypePokemon type, int defense, int attack){

        this.type = type;
        this.defense = defense;
        this.attack = attack;
        this.life = 10;

    }

    private final TypePokemon type;
    private final int attack;
    private final int defense;
    private int life;

    public TypePokemon getType(){

        return type;

    }

    public int getAttack(){

        return attack;

    }

    public int getDefense(){

        return defense;

    }

    public int getLife(){

        return life;

    }

    public void setLife(int life){

        this.life = Math.max(life, 0);

    }

    public String description(){

        return toString();

    }

    @Override
    public String toString(){

        return this.name() + " (life=" + life + ", attack=" + attack + ", defense=" + defense + ")";

    }
}
