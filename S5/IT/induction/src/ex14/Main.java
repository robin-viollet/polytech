package ex14;

public class Main {
    public static void genMEg(int n){
        String out = "";
        for (int i = 0; i < Math.pow(2, n) - 1; ++i){
            String s = Integer.toBinaryString(i);
            if (s.length() < n){
                s = "0".repeat(n - s.length()) + s;
            }
            if (s.chars().filter(ch -> ch == '0').count() == s.chars().filter(ch -> ch == '1').count()){
                out += s + '|';
            }
        }
        System.out.print(out + (out.equals("") ? "|" : ""));
    }

    private static void genMEg(String pref, int  nb0, int  nb1, int k){
        //TO COMPLETE
    }

    public static void main(String[] args){
        genMEg(0);
        System.out.println();
        genMEg(1);
        System.out.println();
        genMEg(2);
        System.out.println();
        genMEg(4);
    }
}
