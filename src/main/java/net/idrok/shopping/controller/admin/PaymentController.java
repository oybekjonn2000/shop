package net.idrok.shopping.controller.admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.idrok.shopping.entity.Payment;
import net.idrok.shopping.service.PaymentService;


@RestController
@RequestMapping("/api/payment")
@CrossOrigin(maxAge = 3600)
public class PaymentController {


    private final
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public ResponseEntity<Page<Payment>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(paymentService.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Payment> create(@RequestBody Payment mj){
        return ResponseEntity.ok( paymentService.create(mj));
    }

    @PutMapping()
    public ResponseEntity<Payment> update(@RequestBody Payment mj){
        return ResponseEntity.ok(paymentService.update(mj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}