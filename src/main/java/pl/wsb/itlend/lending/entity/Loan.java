package pl.wsb.itlend.lending.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

/**
 * Wypożyczenie sprzętu: kto, w jakim celu, na jaki okres i w jakim jest stanie.
 * Relacje (sprzęt, oddział, konto) dojdą na kolejnych zajęciach.
 */
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrower_name", nullable = false, length = 80)
    private String borrowerName;

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

    protected Loan() {
    }

    public Loan(String borrowerName, String purpose, LoanStatus status,
                LocalDate startDate, LocalDate endDate, LocalDate returnedAt) {
        this.borrowerName = borrowerName;
        this.purpose = purpose;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnedAt = returnedAt;
    }

    public Long getId() {
        return id;
    }

    public String getBorrowerName() {
        return borrowerName;
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
}
