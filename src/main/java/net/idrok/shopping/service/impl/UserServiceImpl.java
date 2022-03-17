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

    public Page<User> getAll(Pageable pageable,String key) {
        return userRepository.findByUsernameOrEmailContainingIgnoreCase(key,key, pageable);
    }

    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public User create(User t) {
        if (t.getId() == null)
            return userRepository.save(t);
        throw new RuntimeException("id null bolishi kerak");
    }

    public User update(User t) {
        if (t.getId() != null)
            return userRepository.save(t);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(User t) {
        userRepository.delete(t);
    }

    public void deleteById(Long mjId) {
        userRepository.deleteById(mjId);
    }
}
