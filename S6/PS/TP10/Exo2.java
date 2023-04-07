public class Exo2 {
    public static native long pid();

    static {
        System.loadLibrary("Exo2");
    }

    public static void main(String[] args){
        System.out.println(pid());
        try {
        Thread.sleep(3000);
        } catch(Exception e){

        }
    }
}
