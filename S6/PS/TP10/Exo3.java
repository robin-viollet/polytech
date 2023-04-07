public class Exo3 {
    public static native int fork();

    static {
        System.loadLibrary("Exo3");
    }

    public static void main(String[] args){
        System.out.println(fork());
    }
}
