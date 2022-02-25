package midterm;

import java.util.ArrayList;
import java.util.List;

public class Minterm extends ArrayList<Integer> {
    public boolean isMarked = false;

    /**
     * a marked Minterm implies will be represented by an empty string ("").
     * a Minterm is represented by a value of "0", "1" or "-" (if the value is -1)
     * @return
     */
    @Override
    public String toString() {
        if (isMarked){
            return "";
        }

        StringBuilder builder = new StringBuilder();

        builder.append(" ");

        for (int i = size() - 1; i >= 0; --i){
            switch (get(i)) {
                case 0:
                    builder.append(0);
                    break;

                case 1:
                    builder.append(1);
                    break;

                case -1:
                    builder.append('-');
                    break;
            }
        }

        return builder.toString();

    }

    /**
     * convert the current value of this Midterm (binary encoding)
     * into a decimal value
     * @return a decimal value to represent the value of this Midterm
     */
    public int toIntValue(){

        return Integer.parseInt(toString().replaceAll("-", "")
                .replaceAll(" ", ""), 2);

    }


    /**
     * create a Minterm from the union of two Minterms when it is posssible
     * Carreful, to unify two Minterms it is mandatory that the two elements are in successive classes
     * @param other is another Minterm whitch we try to unify
     * @return a new Minterm when it is possible to unify, else null
     */
    public Minterm union(Minterm other) {

        StringBuilder builder = new StringBuilder();

        String binaryMinterm1 = this.toString().replaceAll(" ", "");
        String binaryMinterm2 = other.toString().replaceAll(" ", "");

        boolean hasAMinus = false;

        if (binaryMinterm1.length() == binaryMinterm2.length()) {

            for (int i = 0; i < binaryMinterm1.length(); ++i){

                char c1 = binaryMinterm1.charAt(i);
                char c2 = binaryMinterm2.charAt(i);

                if (c1 != c2){

                    if (hasAMinus){

                        return null;

                    }

                    hasAMinus = true;

                    builder.append('-');

                } else {

                    builder.append(c1);

                }
            }

            Minterm newMinterm = new Minterm();

            for (int i = builder.length() - 1; i >= 0; --i){

                char c = builder.charAt(i);

                if (c == '-'){

                    newMinterm.add(-1);

                } else if (c == '1'){

                    newMinterm.add(1);

                } else if (c == '0'){

                    newMinterm.add(0);

                }
            }

            this.isMarked = true;
            other.isMarked = true;

            return newMinterm;

        }

        return null;

    }

    public static void main(String[] args) {

        Minterm minterm = new Minterm();
        minterm.add(1); minterm.add(0); minterm.add(0); minterm.add(1); minterm.add(1);
        System.out.println(minterm);

        Minterm minterm2 = new Minterm();
        minterm2.add(1); minterm2.add(0); minterm2.add(0); minterm2.add(1); minterm2.add(1);
        minterm2.isMarked = true;
        System.out.println(minterm2);

        Minterm minterm3 = new Minterm();
        minterm3.add(1); minterm3.add(1); minterm3.add(0); minterm3.add(1);
        System.out.println(minterm3);

        Minterm minterm4 = new Minterm();
        minterm4.add(1); minterm4.add(1); minterm4.add(1); minterm4.add(0); minterm4.add(1);
        System.out.println(minterm4.toIntValue());

        Minterm minterm51 = new Minterm();
        Minterm minterm52 = new Minterm();
        minterm51.add(1); minterm51.add(0); minterm51.add(0); minterm51.add(1); minterm51.add(1);
        minterm52.add(0); minterm52.add(0); minterm52.add(1); minterm52.add(1); minterm52.add(1);

        Minterm res5 = minterm51.union(minterm52);
        System.out.println(res5);

        Minterm minterm61 = new Minterm();
        Minterm minterm62 = new Minterm();
        minterm61.add(1); minterm61.add(0); minterm61.add(0); minterm61.add(1); minterm61.add(1);
        minterm62.add(0); minterm62.add(0); minterm62.add(0); minterm62.add(1); minterm62.add(1);

        Minterm res6 = minterm61.union(minterm62);
        System.out.println(res6);

        QMC qmc = new QMC(0,1,3,8);
        System.out.println(qmc);

        QMC qmc2 = new QMC(1,2,5,6,7,8,10,12,13,14,17);
        System.out.println(qmc2);

        QMC qmc3 = new QMC(0, 3, 5, 6, 7, 9, 10, 12, 13, 14, 15);
        System.out.println(qmc3);

        System.out.println();
        System.out.println();
        System.out.println();

        QMC qmc4 = new QMC(0,1,2,8);
        qmc4.iterate();
        System.out.println(qmc4);

        QMC qmc5 = new QMC(0,3,5,6,7,9,10,12,13,14,15);
        qmc5.iterate();
        System.out.println(qmc5);

    }
}