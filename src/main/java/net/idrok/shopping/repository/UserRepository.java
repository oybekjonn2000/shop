package net.idrok.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.shopping.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByUsernameOrPasswordContainingIgnoreCase(String k1, String k2, Pageable pageable);

}