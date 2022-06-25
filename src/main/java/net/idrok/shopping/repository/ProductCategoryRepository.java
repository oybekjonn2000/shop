package net.idrok.shopping.repository;

import net.idrok.shopping.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    Page<ProductCategory> findAllByCategoryNameContainingIgnoreCase(@RequestParam(name = "key") String k1, Pageable pageable);
    
}
