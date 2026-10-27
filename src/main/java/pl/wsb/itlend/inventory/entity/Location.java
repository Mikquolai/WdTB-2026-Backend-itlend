package pl.wsb.itlend.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Oddział firmy, między którymi wypożyczany jest sprzęt IT.
 */
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;

    @Embedded
    private Address address;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "employee_count", nullable = false)
    private Integer employeeCount;

    protected Location() {
    }

    public Location(String name, Address address, String phone, Integer employeeCount) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.employeeCount = employeeCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }
}
