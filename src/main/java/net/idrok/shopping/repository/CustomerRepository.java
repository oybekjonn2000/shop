package net.idrok.shopping.repository;

import net.idrok.shopping.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAllByFirstNameOrLastNameContainingIgnoreCase(String k1, String k2, Pageable pageable);
    Customer findByEmail(String theEmail);

}