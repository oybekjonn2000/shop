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
    UserRepository userREPO;

    public Page<User> getAll(String key, Pageable pageable) {
        return userREPO.findByUsernameContainingIgnoreCase(key, pageable);
    }

    public User getById(Long id) {
        return userREPO.findById(id).get();
    }

    public User create(User t) {
        if (t.getId() == null)
            return userREPO.save(t);
        throw new RuntimeException("id null bolishi kerak");
    }

    public User update(User t) {
        if (t.getId() != null)
            return userREPO.save(t);
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(User t) {
        userREPO.delete(t);
    }

    public void deleteById(Long mjId) {
        userREPO.deleteById(mjId);
    }
}
