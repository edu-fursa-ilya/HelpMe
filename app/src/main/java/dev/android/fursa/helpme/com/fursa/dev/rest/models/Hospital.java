package dev.android.fursa.helpme.com.fursa.dev.rest.models;

public class Hospital {

    private String name;
    private String address;
    private double latitude;
    private double longitude;

    public Hospital(String name, String address, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Hospital() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
