package net.idrok.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Customer;
import net.idrok.shopping.repository.CustomerRepository;
import net.idrok.shopping.service.dto.CustomerDTO;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Page<CustomerDTO> getAll(String key, Pageable pageable) {
        // return userRepo.findAllByIsmOrFamiliyaContainingIgnoreCase(key, key,
        // pageable).map(mijoz -> new MijozDTO(mijoz));
        return customerRepository.findAllByFirstNameOrLastNameContainingIgnoreCase(key, key, pageable).map(CustomerDTO::new);
    };

    public CustomerDTO getById(Long id) {
        return customerRepository.findById(id).map(CustomerDTO::new).get();
    }

    public CustomerDTO create(Customer mj) {
        if (mj.getId() == null)
            return new CustomerDTO(customerRepository.save(mj));
        throw new RuntimeException("id null bolishi kerak");
    }

    public CustomerDTO update(Customer mj) {
        if (mj.getId() != null)
            return new CustomerDTO( customerRepository.save(mj));
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Customer mj) {
        customerRepository.delete(mj);
    }

    public void deleteById(Long mjId) {
        customerRepository.deleteById(mjId);
    }

}