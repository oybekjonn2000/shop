package net.idrok.shopping.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.idrok.shopping.entity.User;
import net.idrok.shopping.repository.UserRepository;
import net.idrok.shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getAll(Pageable pageable, String key) {
        return (Page<User>) userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User create(User entity) {
        return  userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        return  userRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);

    }

    @Override
    public void deleteById(Long entityId) {
        userRepository.deleteById(entityId);

    }
}
