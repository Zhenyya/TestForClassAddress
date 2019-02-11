package main;

public class Address {

    private Country country;
    private String city;
    private String street;
    private String homeNumber;
    private String apartment;

    public Address(Country country, String city, String street, String homeNumber, String apartment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartment = apartment;
    }

    public Address(Country country) {
        setCountry(country);
    }

    @Override
    public String toString() {
        return "main.Address: " + country + ", " + city + ", " + street + " street " + homeNumber + "/" + apartment;
    }

    public void setCountry(Country country) {
        this.country = (country == null) ? Country.UKRAINE : country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCity(String city) {
        if (isOnlyLetters(city)) {
            this.city = city;
        }
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        if (isOnlyLettersAndApostrophic(street)) {
            this.street = street;
        }
    }

    public String getStreet() {
        return street;
    }

    public void setHomeNumber(String homeNumber) {
        if (isOnlyLettersAndDigits(homeNumber)) {
            this.homeNumber = homeNumber;
        }
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setApartment(String apartment) {
        if (isOnlyLettersAndDigits(apartment)) {
            this.apartment = apartment;
        }
    }

    public String getApartment() {
        return apartment;
    }

    public boolean isOnlyLetters (String str) {
        String regex = "[a-z, A-Z]+";
        boolean b = str.matches(regex);
        return b;
    }

    public boolean isOnlyLettersAndApostrophic (String str) {
        String regex = "[a-z, A-Z, ']+";
        boolean b = str.matches(regex);
        return b;
    }

    public boolean isOnlyLettersAndDigits (String str) {
        return str.chars().allMatch(c -> Character.isLetterOrDigit(c));
    }
}