package ma.enset.distributedsystems.bankmanager.repositories;

import ma.enset.distributedsystems.bankmanager.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
