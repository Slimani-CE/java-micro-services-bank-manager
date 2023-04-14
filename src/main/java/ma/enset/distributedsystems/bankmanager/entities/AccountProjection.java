package ma.enset.distributedsystems.bankmanager.entities;

import ma.enset.distributedsystems.bankmanager.enums.AccountType;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name ="p1")
public interface AccountProjection {
    public Double getBalance();
    public AccountType getAccountType();
}
