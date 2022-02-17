package net.idrok.shopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.User;
import net.idrok.shopping.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository mijozRepository;

    public Page<User> getAll(String key, Pageable pageable) {
        return mijozRepository.findAllByUsernameOrPasswordContainingIgnoreCase(key, key, pageable);
    }

    public User getById(Long id) {
        return mijozRepository.findById(id).get();
    }

    public User create(User mj) {
        if (mj.getId() == null)
       return     mijozRepository.save(mj);
        throw new RuntimeException("id null bolishi kerak");
    }

    public User update(User mj) {
        if (mj.getId() != null)
         return   mijozRepository.save(mj);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(User mj) {
        mijozRepository.delete(mj);
    }

    public void deleteById(Long mjId) {
        mijozRepository.deleteById(mjId);
    }

}