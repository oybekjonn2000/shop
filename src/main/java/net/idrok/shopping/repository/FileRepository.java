package net.idrok.shopping.repository;

import net.idrok.shopping.entity.Fayl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository  extends JpaRepository<Fayl, Long> {

}
