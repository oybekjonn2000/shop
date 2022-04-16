package net.idrok.shopping.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.shopping.entity.User;
import net.idrok.shopping.service.UserService;

@RestController
@RequestMapping("/api/systemuser")
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    UserService userSVC;

    @GetMapping()
    public ResponseEntity<Page<User>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(userSVC.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(userSVC.getById(id));
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User kt){
        return ResponseEntity.ok( userSVC.create(kt));
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User kt){
        return ResponseEntity.ok(userSVC.update(kt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userSVC.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
