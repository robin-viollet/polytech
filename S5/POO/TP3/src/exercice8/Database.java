package exercice8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Database {

    public Database(){

        restaurants = new ArrayList<>();
        menus = new ArrayList<>();

    }

    private final Collection<Restaurant> restaurants;
    private final Collection<Menu> menus;

    public void addMenu(Menu menu){

        menus.add(menu);

    }

    public void addRestaurant(Restaurant restaurant){

        restaurants.add(restaurant);

    }

    public void delMenu(Menu menu){

        menus.remove(menu);

    }

    public void delRestaurant(Restaurant restaurant){

        restaurants.remove(restaurant);

    }

    public Collection<Restaurant> getRecentRestaurants(){

        ArrayList<Restaurant> recentRestaurants = new ArrayList<>();

        for (Restaurant restaurant : restaurants){

            if (LocalDateTime.now().getYear() - restaurant.getYear() < 3){

                recentRestaurants.add(restaurant);

            }
        }

        return recentRestaurants;

    }

    public Collection<Restaurant> getProspects(Menu menu){

        ArrayList<Restaurant> prospects = new ArrayList<>();

        for (Restaurant restaurant : restaurants){

            if (!prospects.contains(restaurant) && !menu.getDistributors().contains(restaurant)){

                prospects.add(restaurant);

            }
        }

        return prospects;

    }
}
