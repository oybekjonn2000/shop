package net.idrok.shopping.service.impl;


import net.idrok.shopping.dto.UserDTO;
import net.idrok.shopping.entity.Role;
import net.idrok.shopping.entity.User;
import net.idrok.shopping.repository.UserRepository;
import net.idrok.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<User> getAll(Pageable pageable, String key) {
        return userRepository.findByLoginOrFirstNameContainingIgnoreCase(key, key, pageable);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User create(User entity) {
        // TODO Auto-generated method stub
        if(entity.getId() == null){
            entity.setRole(Role.USER);
            entity.setRegTime(LocalDateTime.now());
            entity.setLastVisit(LocalDateTime.now());
            entity.setActive(true);
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            return userRepository.save(entity);
        }
        throw new RuntimeException("id null bo'lsihi shart");
    }



    @Override
    public User update(User entity) {
        User u = userRepository.findById(entity.getId()).get();
        u.setFirstName(entity.getFirstName());
        u.setLastName(entity.getLastName());
        u.setImage(entity.getImage());



        return  userRepository.save(u);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);

    }

    @Override
    public void deleteById(Long entityId) {
        userRepository.deleteById(entityId);

    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if(authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User u = userRepository.findByLogin(userDetails.getUsername())
                    .orElseThrow(()->  new RuntimeException("not found"));
        return  new UserDTO(u);
        }
        throw  new RuntimeException("not found");
    }
}
