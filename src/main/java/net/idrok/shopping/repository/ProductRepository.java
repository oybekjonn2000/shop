package net.idrok.shopping.repository;


import net.idrok.shopping.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryIdOrderByDescriptionAsc(@RequestParam("id") Long categoryId);
    Page<Product> findByNameContainingIgnoreCase(String k1, Pageable pageable);

    

}
