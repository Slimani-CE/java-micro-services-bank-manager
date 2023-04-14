package ma.enset.distributedsystems.bankmanager;

import ma.enset.distributedsystems.bankmanager.entities.BankAccount;
import ma.enset.distributedsystems.bankmanager.entities.Customer;
import ma.enset.distributedsystems.bankmanager.enums.AccountType;
import ma.enset.distributedsystems.bankmanager.repositories.BankAccountRepository;
import ma.enset.distributedsystems.bankmanager.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {
            // Create clients
            Stream.of("Mohamed", "Ahmed", "Ali", "Salma", "Sanae", "Imane").forEach(name -> {
                Customer customer = Customer.builder()
                        .name(name)
                        .build();
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    bankAccountRepository.save(BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(Math.random() * 10000)
                            .currency("MAD")
                            .creationDate(new Date(System.currentTimeMillis()))
                            .accountType(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVINGS_ACCOUNT)
                            .customer(customer)
                            .build());
                }
            });


        };
    }

}
