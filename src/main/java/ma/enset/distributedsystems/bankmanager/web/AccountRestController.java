package ma.enset.distributedsystems.bankmanager.web;

import ma.enset.distributedsystems.bankmanager.dto.BankAccountRequestDTO;
import ma.enset.distributedsystems.bankmanager.dto.BankAccountResponseDTO;
import ma.enset.distributedsystems.bankmanager.entities.BankAccount;
import ma.enset.distributedsystems.bankmanager.repositories.BankAccountRepository;
import ma.enset.distributedsystems.bankmanager.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blabla")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account with id %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveBankAccount(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreationDate() != null) account.setCreationDate(bankAccount.getCreationDate());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getAccountType() != null) account.setAccountType(bankAccount.getAccountType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
