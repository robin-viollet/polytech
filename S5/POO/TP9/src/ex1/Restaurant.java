package ex1;

public class Restaurant {

    private double latitude, longitude;
    private String name, address, city, state;

    public double getLatitude(){

        return latitude;
    }

    public void setLatitude(double latitude){

        this.latitude = latitude;
    }

    public double getLongitude(){

        return longitude;
    }

    public void setLongitude(double longitude){

        this.longitude = longitude;
    }

    public String getName(){

        return name;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getAddress(){

        return address;
    }

    public void setAddress(String address){

        this.address = address;
    }

    public String getCity(){

        return city;
    }

    public void setCity(String city){

        this.city = city;
    }

    public String state(){

        return state;
    }

    public void setState(String state){

        this.state = state;
    }
}
