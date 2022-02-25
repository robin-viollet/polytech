package ex1;

public class Main {

    public static void main(String[] args){

        McDonalds mcDonalds = new McDonalds();

        System.out.println("nb of McDos = " + mcDonalds.getSize());
        System.out.println("The number of cities that have a McDonald : " + mcDonalds.nbCitiesHaveMcDo());
        System.out.println("The city has the most MacDonald : " + mcDonalds.cityHasMostMcDo());

    }
}
