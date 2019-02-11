package test;

import main.Address;
import main.Country;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressTest {

    @Test
    public void testSetCountry() {
        Address address = new Address(null);
        Country actual = address.getCountry();
        Country expected = Country.UKRAINE;
        assertEquals(expected, actual);
    }

    @Test
    public void testIsOnlyLetters() {
        Address address = new Address(Country.ITALY, "Rome", null, null, null);
        boolean expected = address.isOnlyLetters(address.getCity());
        assertTrue(expected);
    }

    @Test
    public void testIsOnlyLettersAndApostrophic() {
        Address address = new Address(Country.UKRAINE, "Lviv", "Chornovola's avenue", null, null);
        boolean actual = true;
        boolean expected = address.isOnlyLettersAndApostrophic(address.getStreet());
        assertEquals(expected, actual);
    }

    @Test
    public void testIsOnlyLettersAndDigits() {
        Address address = new Address(Country.UKRAINE, "Lviv", "Chornovola's avenue", "41A", "101a");
        boolean expectedHomeNumber = address.isOnlyLettersAndDigits(address.getHomeNumber());
        assertTrue(expectedHomeNumber);
        boolean expectedApartment = address.isOnlyLettersAndDigits(address.getApartment());
        assertTrue(expectedApartment);
    }

}
