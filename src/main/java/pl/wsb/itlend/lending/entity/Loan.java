package pl.wsb.itlend.lending.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Wypożyczenie sprzętu: kto (pracownik), w jakim celu, na jaki okres i w jakim jest stanie.
 * Wypożyczony sprzęt to pozycje (LoanItem).
 */
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Wypożyczający: wiele wypożyczeń → jeden pracownik. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "purpose", length = 200)
    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private LoanStatus status;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    /** Faktyczna data zwrotu; null, dopóki sprzęt nie wróci. */
    @Column(name = "returned_at")
    private LocalDate returnedAt;

    /** Pozycje wypożyczenia: drugi koniec relacji LoanItem.loan (nie tworzy kolumny). */
    @OneToMany(mappedBy = "loan")
    private List<LoanItem> items = new ArrayList<>();

    protected Loan() {
    }

    public Loan(Employee employee, String purpose, LoanStatus status,
                LocalDate startDate, LocalDate endDate, LocalDate returnedAt) {
        this.employee = employee;
        this.purpose = purpose;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnedAt = returnedAt;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getPurpose() {
        return purpose;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getReturnedAt() {
        return returnedAt;
    }

    public List<LoanItem> getItems() {
        return items;
    }
}
