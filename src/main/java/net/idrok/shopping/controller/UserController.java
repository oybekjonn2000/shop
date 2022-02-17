package net.idrok.shopping.controller;
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
@RequestMapping("/api/mijoz")
@CrossOrigin(maxAge = 3600)
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<Page<User>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(userService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User mj){
        return ResponseEntity.ok( userService.create(mj));
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User mj){
        return ResponseEntity.ok(userService.update(mj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}