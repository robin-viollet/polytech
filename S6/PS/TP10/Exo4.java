public class Exo4 {
    public static native long pid();
    public static native int fork();
    public static native void waitD();
    public static native void exit();
    public static native void sleep(int s);

    static {
        System.loadLibrary("Exo4");
    }

    public static void main(String[] args){
        for (int i = 0; i < 10; ++i){
            int pid = fork();
            if (pid == 0){
                for (int j = 0; j < 10; ++j){
                    System.out.println("Fils " + i + " " + pid());
                    sleep(1);
                }
                exit();
            }
        }

        for (int i = 0; i < 10; ++i){
            waitD();
        }
    }
}

