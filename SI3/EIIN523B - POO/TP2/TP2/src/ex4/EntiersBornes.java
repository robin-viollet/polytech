package ex4;

import java.util.ArrayList;
import java.util.Arrays;

public class EntiersBornes {

    private EntiersBornes(){

        MAXIMUM = 0;
        MAX_VALUE = 0;
        values = new int[0];

    }

    public EntiersBornes(int max, int maxValue){

        this.MAXIMUM = max;
        this.MAX_VALUE = maxValue;
        this.values = new int[0];

    }

    private final int MAXIMUM;
    private final int MAX_VALUE;
    private int[] values;

    private boolean contains(int e){

        for (int i : values){

            if (e == i){

                return true;

            }
        }

        return false;

    }

    public void add(int e){

        if (contains(e) || e > MAX_VALUE || values.length >= MAXIMUM){

            return;

        }

        values = Arrays.copyOf(values, values.length + 1);

        values[values.length - 1] = e;

    }

    public void remove(int e){

        for (int i = 0; i < values.length; ++i){

            if (e == values[i]){

                int[] newValues = new int[values.length - 1];

                int j;

                for (j = 0; j < i; ++j){

                    newValues[j] = values[j];

                }

                for (; j < newValues.length; ++j){

                    newValues[j] = values[j + 1];

                }

                values = newValues;

                return;

            }
        }
    }

    public EntiersBornes union(EntiersBornes e){

        ArrayList<Integer> list = new ArrayList<>();
        int maxValue = 0;

        for (int i : values){

            if (!list.contains(i)){

                list.add(i);

            }

            if (i > maxValue){

                maxValue = i;

            }
        }

        for (int i : e.values){

            if (!list.contains(i)){

                list.add(i);

            }

            if (i > maxValue){

                maxValue = i;

            }
        }

        EntiersBornes unionEnsemble = new EntiersBornes(list.size(), maxValue);

        for (int i : list){

            unionEnsemble.add(i);

        }

        return unionEnsemble;

    }

    public EntiersBornes inter(EntiersBornes e){

        ArrayList<Integer> list = new ArrayList<>();

        int maxValue = 0;

        for (int i : values){

            if (e.contains(i)){

                list.add(i);

                if (i > maxValue){

                    maxValue = i;

                }
            }
        }

        EntiersBornes interEnsemble = new EntiersBornes(list.size(), maxValue);

        for (int i : list){

            interEnsemble.add(i);

        }

        return interEnsemble;

    }

    @Override
    public String toString(){

        String s = "{ ";

        for (int i = 0; i < values.length; ++i){

            if (i != 0){

                s += ',';

            }

            s += values[i];

        }

        return s + " }";

    }
}
