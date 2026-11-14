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
import jakarta.persistence.Table;
import pl.wsb.itlend.inventory.entity.Equipment;

/**
 * Pozycja wypożyczenia: encja łącząca relacji wiele-do-wielu loan ↔ equipment.
 * Jedno wypożyczenie może obejmować wiele egzemplarzy, a ten sam egzemplarz
 * bywa wypożyczany wiele razy. Para ma własne dane: stan przy wydaniu i zwrocie.
 */
@Entity
@Table(name = "loan_item")
public class LoanItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition_on_issue", nullable = false, length = 20)
    private ItemCondition conditionOnIssue;

    /** Stan przy zwrocie; null, dopóki sprzęt nie wróci. */
    @Enumerated(EnumType.STRING)
    @Column(name = "condition_on_return", length = 20)
    private ItemCondition conditionOnReturn;

    protected LoanItem() {
    }

    public LoanItem(Loan loan, Equipment equipment, ItemCondition conditionOnIssue,
                    ItemCondition conditionOnReturn) {
        this.loan = loan;
        this.equipment = equipment;
        this.conditionOnIssue = conditionOnIssue;
        this.conditionOnReturn = conditionOnReturn;
    }

    public Long getId() {
        return id;
    }

    public Loan getLoan() {
        return loan;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public ItemCondition getConditionOnIssue() {
        return conditionOnIssue;
    }

    public ItemCondition getConditionOnReturn() {
        return conditionOnReturn;
    }
}
