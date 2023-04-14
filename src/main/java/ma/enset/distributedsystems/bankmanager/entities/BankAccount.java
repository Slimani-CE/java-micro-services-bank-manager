package ma.enset.distributedsystems.bankmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.distributedsystems.bankmanager.enums.AccountType;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date creationDate;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
