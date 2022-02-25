package ex5;

public class NumberDisplay {

    public NumberDisplay(int limit){

        this.limit = limit;
        this.value = 0;

    }

    private final int limit;
    private int value;

    public int getValue(){

        return value;

    }

    public String getDisplayValue(){

        return (value < 10 ? "0" : "") + value;

    }

    public void setValue(int value){

        this.value = value >= limit ? 0 : value;

    }

    public void increment(){

        setValue(value + 1);

    }
}
