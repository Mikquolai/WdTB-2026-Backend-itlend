# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 6 · kolumny: 39 · relacje: 5 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| employee | Employee | 7 | location_id, user_account_id |
| equipment | Equipment | 8 | location_id |
| loan | Loan | 7 | employee_id |
| loan_item | LoanItem | 5 | equipment_id, loan_id |
| location | Location | 7 | — |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    employee {
        Long id PK
        String email
        String first_name
        String job_title
        String last_name
        Long location_id FK
        Long user_account_id FK
    }
    equipment {
        Long id PK
        EquipmentCategory category
        Long location_id FK
        String name
        LocalDate purchase_date
        BigDecimal purchase_price
        String serial_number
        EquipmentStatus status
    }
    loan {
        Long id PK
        Long employee_id FK
        LocalDate end_date
        String purpose
        LocalDate returned_at
        LocalDate start_date
        LoanStatus status
    }
    loan_item {
        Long id PK
        ItemCondition condition_on_issue
        ItemCondition condition_on_return
        Long equipment_id FK
        Long loan_id FK
    }
    location {
        Long id PK
        String city
        Integer employee_count
        String name
        String phone
        String postal_code
        String street
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    employee ||--o{ loan : "employee_id"
    equipment ||--o{ loan_item : "equipment_id"
    loan ||--o{ loan_item : "loan_id"
    location ||--o{ employee : "location_id"
    location ||--o{ equipment : "location_id"
    user_account |o--o| employee : "user_account_id"
```
