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

import net.idrok.shopping.entity.Type;
import net.idrok.shopping.service.TypeService;


@RestController
@RequestMapping("/api/type")
@CrossOrigin(maxAge = 3600)
public class TypeController {


    @Autowired
    TypeService ts;

    @GetMapping()
    public ResponseEntity<Page<Type>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(ts.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getById(@PathVariable Long id){
        return ResponseEntity.ok(ts.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Type> create(@RequestBody Type mj){
        return ResponseEntity.ok( ts.create(mj));
    }

    @PutMapping()
    public ResponseEntity<Type> update(@RequestParam Type mj){
        return ResponseEntity.ok(ts.update(mj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ts.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
