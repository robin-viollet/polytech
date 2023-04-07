import java.util.Scanner;

public class HelloWorld {
    public static native void printCpp(); // Déclaration prototype méthode native
    public static native void printStringToCpp(String str);
    public native String stringFromCpp();
    public native void callJavaMethod();
    public native String toString();
    public static native int fib(int n);

    public int entier;

    static {
        System.loadLibrary("HelloWorld"); // Chargement de la bibliothèque
    }

    public static void main(String args[]) {
        System.out.print("Hello "); // Affiche Hello en Java
        HelloWorld.printCpp(); // Affiche World en C/C++
        Scanner scanner = new Scanner(System.in);
        printStringToCpp(scanner.nextLine());
        String s = new HelloWorld().stringFromCpp();
        System.out.println("\"" + s + "\"");
        new HelloWorld().callJavaMethod();
        System.out.println(new HelloWorld().toString());
        System.out.println("Fib of 14 is " + HelloWorld.fib(14) + " (should be 377)");
    }

    public static void test(String s){
        System.out.println(s);
    }
}
