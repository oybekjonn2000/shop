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
    UserRepository userRepository;

    public Page<User> getAll(String key, Pageable pageable) {
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
