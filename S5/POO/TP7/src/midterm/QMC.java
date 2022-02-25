package midterm;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class QMC extends ArrayList<Minterm> {
    private MapOfMinterm classes;
    private int numNextClass = 0;
    private int nbBits;


    public QMC(int... values){

        // TODO

        for (int value : values){

            Minterm minterm = new Minterm();

            String binary = Integer.toString(value, 2);

            for (int j = binary.length() - 1; j >= 0; --j){

                if (binary.charAt(j) == '0'){

                    minterm.add(0);

                } else if (binary.charAt(j) == '1'){

                    minterm.add(1);

                }
            }

            add(minterm);
            int valueNbBits = numberOfBitsNeeded(value);

            if (valueNbBits > nbBits){

                nbBits = valueNbBits;

            }
        }

        classes = createClasses();

    }

    /**
     * compute the number of bits needed to store all the terms of the qmc
     * it should be called by constructor
     *
     * @param decimal the value of the hiest term
     * @return number of bits needed
     **/
    private int numberOfBitsNeeded(int decimal){
        //TODO check

        return Integer.toString(decimal, 2).length();
    }

    /**
     * convert a decimal value into a term (e.g. into a Minterm class)
     *
     * @param decimal value to convert
     * @return
     */
    private Minterm toBinary(int decimal){

        // TODO check
        Minterm minterm = new Minterm();

        while (decimal != 0){

            minterm.add(decimal % 2);
            decimal /= 2;

        }

        return minterm;
    }

    /**
     * compute the number of 1 into a binary coded term (or Minterm)
     * should be called to create the classes
     *
     * @param minterm the term to examine
     * @return the number of 1 present
     */
    private int numberOfOnes(Minterm minterm){
        // TODO check

        String binary = minterm.toString();
        int count = 0;

        for (int i = 0; i < binary.length(); ++i){

            if (binary.charAt(i) == '1'){

                count++;

            }

        }

        return count;
    }


    /**
     * create the diffesrent classes with all terms of the function
     * each class level is given by the number of 1 present in the binary encoding term
     * the method up to date the value of numNextClass
     * if a class doesn't contain any value, the value is null (but not the key)
     *
     * @return a map (key:value) of classes MapOfMin
     */
    private MapOfMinterm createClasses(){

        MapOfMinterm mapOfMinterm = new MapOfMinterm();

        for (Minterm minterm : this){

            int numberOfOnes = numberOfOnes(minterm);

            ListMinterm minterms = mapOfMinterm.get(numberOfOnes);

            if (minterms == null){

                minterms = new ListMinterm();

            }

            minterms.add(minterm);

            mapOfMinterm.put(numberOfOnes, minterms);

        }

        return mapOfMinterm;
    }


    @Override
    /**
     * a QMC can be represented by a string which starts with "QMC: [",
     * which contains all the Minterms of all the classes separated
     * by spaces and which ends with].
     * For example QMC: [ 00-01 , -0001 , 001-1 , 0-101 , 0011- , 0110- , 0--10 , 01--0 ]
     */
    public String toString(){

        StringBuilder builder = new StringBuilder();

        builder.append("QMC: [");

        Set<Map.Entry<Integer, ListMinterm>> minterms = classes.entrySet();

        boolean start = true;

        for (Map.Entry<Integer, ListMinterm> entry : minterms){
            for (Minterm minterm : entry.getValue()){

                if (!start){
                    builder.append(",");
                }

                start = false;

                builder.append(' ');

                String binaryMinterm = minterm.toString().replaceAll(" ", "");

                builder.append("0".repeat(Math.max(0, nbBits - binaryMinterm.length())));

                builder.append(binaryMinterm);
                builder.append(' ');

            }
        }

        builder.append("]");

        return builder.toString();
    }

    public void iterate(){

        Set<Map.Entry<Integer, ListMinterm>> minterms = classes.entrySet();

        for (int i = 0; i < nbBits - 1; ++i){

            ListMinterm classe1 = classes.get(i);
            ListMinterm classe2 = classes.get(i + 1);

            if (classe1 != null){

                for (Minterm minterm1 : classe1){

                    if (classe2 != null){

                        for (Minterm minterm2 : classe2){

                            Minterm newMinterm = minterm1.union(minterm2);

                            if (newMinterm != null){

                                add(newMinterm);
                                classes = createClasses();

                            }
                        }
                    }
                }
            }
        }
    }
}