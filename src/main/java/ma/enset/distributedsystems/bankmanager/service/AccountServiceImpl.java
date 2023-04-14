package ma.enset.distributedsystems.bankmanager.service;

import ma.enset.distributedsystems.bankmanager.dto.BankAccountRequestDTO;
import ma.enset.distributedsystems.bankmanager.dto.BankAccountResponseDTO;
import ma.enset.distributedsystems.bankmanager.entities.BankAccount;
import ma.enset.distributedsystems.bankmanager.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    BankAccountRepository bankAccountRepository;
    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        // Create a new bank account based on the request
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .accountType(bankAccountRequestDTO.getAccountType())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .creationDate(new Date(System.currentTimeMillis()))
                .build();
        // Save the bank account
        BankAccount savedAccount = bankAccountRepository.save(bankAccount);
        // Return the response
        BankAccountResponseDTO responseDTO = BankAccountResponseDTO.builder()
                .id(savedAccount.getId())
                .accountType(savedAccount.getAccountType())
                .balance(savedAccount.getBalance())
                .currency(savedAccount.getCurrency())
                .creationDate(savedAccount.getCreationDate())
                .build();
        return responseDTO;
    }
}
