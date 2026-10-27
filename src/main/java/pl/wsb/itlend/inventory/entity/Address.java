package pl.wsb.itlend.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Adres oddziału: klasa wbudowana, nie osobna tabela.
 * Jej kolumny (street, city, postal_code) trafiają do tabeli location.
 */
@Embeddable
public class Address {

    @Column(name = "street", nullable = false, length = 120)
    private String street;

    @Column(name = "city", nullable = false, length = 60)
    private String city;

    @Column(name = "postal_code", nullable = false, length = 6)
    private String postalCode;

    protected Address() {
    }

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
