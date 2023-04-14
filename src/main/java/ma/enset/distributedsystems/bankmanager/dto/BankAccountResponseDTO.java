package ma.enset.distributedsystems.bankmanager.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.distributedsystems.bankmanager.enums.AccountType;

import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Date creationDate;
    private Double balance;
    private String currency;
    private AccountType accountType;
}
