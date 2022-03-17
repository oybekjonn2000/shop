package net.idrok.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Payment;

import net.idrok.shopping.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {

    @Autowired
    PaymentRepository paymentRepository;

    public Page<Payment> getAll(String key, Pageable pageable) {
        return paymentRepository.findByNameOrStatusContainingIgnoreCase(key, key, pageable);
    }

    public Payment getById(Long id) {
        return paymentRepository.findById(id).get();
    }

    public Payment create(Payment t) {
        if (t.getId() == null)
            return paymentRepository.save(t);
        throw new RuntimeException("id null bolishi kerak");
    }

    public Payment update(Payment t) {
        if (t.getId() != null)
            return paymentRepository.save(t);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Payment t) {
        paymentRepository.delete(t);
    }

    public void deleteById(Long mjId) {
        paymentRepository.deleteById(mjId);
    }

}