package main.java.ua.kpi.tef.model;

/**
 * Created by Gavriliak on 09.03.2018.
 */

public class Address {
    private String index;
    private String cityOfResidence;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Address(String index, String cityOfResidence, String street, String houseNumber, String apartmentNumber) {
        this.index = index;
        this.cityOfResidence = cityOfResidence;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address: " +
                "index=" + index +
                ", " + cityOfResidence + ' ' +
                ", " + street + ' ' +
                houseNumber + ' ' +
                ", " + apartmentNumber;

    }

    //////////
    //Getters
    /////////
    public String getIndex() {
        return index;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    //////////
    //Setters
    //////////
    public void setIndex(String index) {
        this.index = index;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
