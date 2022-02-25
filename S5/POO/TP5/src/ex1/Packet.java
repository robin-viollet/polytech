package ex1;

import java.util.ArrayList;
import java.util.List;

public class Packet {
    public Packet(){

        this.packet = new ArrayList<>();

    }

    private final List<Pokemon> packet;

    public void add(Pokemon pokemon){

        packet.add(pokemon);

    }

    public void remove(Pokemon pokemon){

        packet.remove(pokemon);

    }

    public Pokemon getOne(){

        return packet.get(0);

    }

    public Pokemon[] getTwo(){

        return new Pokemon[]{packet.get(0), packet.get(1)};

    }

    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();

        for (Pokemon pokemon : packet){

            s.append(pokemon.name()).append('\n');

        }

        return s.toString();

    }
}
