package ex15;

public class Main {
    private static final String[] ALPHABET = {"a","b","c"};
    private static final String SEP = " ";

    public static void genMirror(int n){
        genMirror("", n);
    }

    private static void genMirror(String u, int k){
        if (k > 0){
            genMirror(ALPHABET[0] + u + ALPHABET[0], k - 2);
        } else {
            System.out.println(u + SEP);
        }
    }

    public static void main(String[] args){
        genMirror(4);
    }
}
