package ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class McDonalds {

    public McDonalds(){

        Stream<String> lines = null;
        try {
            String file = System.getProperty("user.dir")
                    + System.getProperty("file.separator") + "data/mcdonalds.csv";

            System.out.println(file);
            lines = Files.lines(Paths.get(file));
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mcdos = lines.map(s -> {   // -72.84817,41.27988,"McDonalds-Branford,CT","424 W Main St, Branford,CT, (203)
            // 488-9353"
            String[] strings = s.split(",");
            Restaurant mdo = new Restaurant();
            mdo.setLatitude(Double.parseDouble(strings[0]));
            mdo.setLongitude(Double.parseDouble(strings[1]));
            mdo.setName(strings[2].substring(1) + strings[3].substring(0, strings[3].length() - 1));
            mdo.setAddress(strings[4].substring(1));
            mdo.setCity(strings[5].trim());
            mdo.setState(strings[6].trim());
            if (mdo.state().endsWith("\"")){
                mdo.setState(mdo.state().substring(0, mdo.state().length() - 1));
            }
            if (mdo.state().contains(" ")){
                mdo.setState(mdo.state().substring(0, mdo.state().indexOf(" ")));
            }
            if (mdo.state().length() > 2){
                mdo.setState(strings[7].trim());
            }
            return mdo;
        }).collect(Collectors.toList());
    }

    private final List<Restaurant> mcdos;

    int getSize(){ //Question 1 : compter le nb de restaurants

        return mcdos.size();

    }

    long nbCitiesHaveMcDo(){ // Question 2 : le nombre de villes qui disposent d'un restaurant McDonald

        return mcdos.stream().map(Restaurant::getCity).distinct().count();

    }

    Map.Entry<String, Long> cityHasMostMcDo(){ // Question 3 : La ville qui dispose du plus grand nombre de MacDonald

        return mcdos.stream()
                .map(restaurant -> new AbstractMap.SimpleEntry<String, Long>(restaurant.getCity(), 1L) {})
                .collect(groupingBy((Function<AbstractMap.SimpleEntry<String, Long>, String>) AbstractMap.SimpleEntry::getKey, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();

    }
}