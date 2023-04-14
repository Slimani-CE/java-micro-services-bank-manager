package ma.enset.distributedsystems.bankmanager.web;

import ma.enset.distributedsystems.bankmanager.dto.BankAccountRequestDTO;
import ma.enset.distributedsystems.bankmanager.dto.BankAccountResponseDTO;
import ma.enset.distributedsystems.bankmanager.entities.BankAccount;
import ma.enset.distributedsystems.bankmanager.entities.Customer;
import ma.enset.distributedsystems.bankmanager.repositories.BankAccountRepository;
import ma.enset.distributedsystems.bankmanager.repositories.CustomerRepository;
import ma.enset.distributedsystems.bankmanager.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    private BankAccountRepository bankAccountRepository;
    private AccountServiceImpl accountService;
    private CustomerRepository customerRepository;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository, AccountServiceImpl accountService, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account with id %s not found", id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addBankAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public void deleteBankAccount(@Argument  String id){
        accountService.deleteAccount(id);
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}
