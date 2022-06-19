package net.idrok.shopping.repository;

import net.idrok.shopping.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel="provinces", path="provinces")
public interface ProvinceRepository extends JpaRepository<Province, Long> {
Page<Province> findByCode(String key,  Pageable pageable);

}