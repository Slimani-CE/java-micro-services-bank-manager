package ma.enset.distributedsystems.bankmanager.service;

import ma.enset.distributedsystems.bankmanager.dto.BankAccountRequestDTO;
import ma.enset.distributedsystems.bankmanager.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
}
