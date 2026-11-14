package pl.wsb.itlend.lending.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.wsb.itlend.account.domain.UserAccount;
import pl.wsb.itlend.inventory.entity.Location;

/**
 * Pracownik firmy, który wypożycza sprzęt. Pracuje w jednym oddziale
 * i może mieć konto użytkownika w aplikacji (jedno konto = jeden pracownik).
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 120)
    private String email;

    @Column(name = "job_title", length = 60)
    private String jobTitle;

    /** Oddział pracownika: wielu pracowników → jeden oddział. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    /** Konto w aplikacji (opcjonalne): jeden pracownik ↔ jedno konto. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount account;

    protected Employee() {
    }

    public Employee(String firstName, String lastName, String email, String jobTitle,
                    Location location, UserAccount account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.location = location;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Location getLocation() {
        return location;
    }

    public UserAccount getAccount() {
        return account;
    }
}
