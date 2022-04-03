package net.idrok.shopping.entity.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.idrok.shopping.entity.Payment;
import net.idrok.shopping.entity.PaymentType;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Page<Payment> findByNameOrStatusContainingIgnoreCase(String k1, String k2,  Pageable pageable);

    List<Payment> findByPaymentType(PaymentType paymentType);

    default List<Payment> findByPaymentTypeUZCARD(){
       return this.findByPaymentType(PaymentType.UZCARD);
    }


    @Query("FROM Payment p WHERE p.paymentType = net.idrok.shopping.entity.PaymentType.HUMO")
    List<Payment> findbyPaymentTypeHUMO();
    //

}