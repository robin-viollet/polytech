package ex1;

public enum Pokemon {
    SALAMECHE(TypePokemon.FEU, 5, 4),
    ODDISH(TypePokemon.PLANTE, 6, 2),
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

        this.life = life;

    }
}
