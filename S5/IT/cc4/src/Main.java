/*Écrire une méthode Java de signature
public static String sum(int[] tab, int s)
qui retourne une chaine de caractères qui représente une somme d'entiers
contenus dans le tableau tab dont la somme vaut s, s'il n'est pas possible d'obtenir s,
la chaine retournée est vide. Les valeurs de tab ne peuvent être prises qu'au plus une fois. */

import java.util.ArrayList;

public class Main {
    public static String sum(int[] tab, int s){

        boolean[] flags = new boolean[tab.length];

        String res = "";
        int sum = 0;
        for (int i = tab.length - 1; i >= 0; --i){
            if (!flags[i] && sum + tab[i] <= s){
                sum += tab[i];
                flags[i] = true;
                res += '+' + String.valueOf(tab[i]);

                if (sum == s){
                    break;
                }
            }
        }
        return res;
    }

    public static void ass(String s1, String s2){
        if (!s1.equals(s2)){
            System.err.println(s1 + " != " + s2);
            throw new RuntimeException();
        } else {
            System.out.println(s1 + " == " + s2);
        }
    }

    public static void main(String[] args){
        /*assert(sum(new int[]{5,11,3},8).equals("+3+5"));
        assert(sum(new int[]{5,11,3},14).equals("+3+11"));
        assert(sum(new int[]{5,11,3},19).equals("+3+11+5"));
        assert(sum(new int[]{5,11,3},0).equals(""));*/

        ass(sum(new int[]{5,11,3},8), "+3+5");
        ass(sum(new int[]{5,11,3},14), "+3+11");
        ass(sum(new int[]{5,11,3},19), "+3+11+5");
        ass(sum(new int[]{5,11,3},0), "");
    }
}
