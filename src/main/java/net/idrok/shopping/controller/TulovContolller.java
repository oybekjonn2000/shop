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
import net.idrok.shopping.entity.Tulov;
import net.idrok.shopping.service.TulovService;

@RestController
@RequestMapping("/api/tulov")
@CrossOrigin(maxAge = 3600)
public class TulovContolller {


    @Autowired
    TulovService ts;

    @GetMapping()
    public ResponseEntity<Page<Tulov>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(ts.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tulov> getById(@PathVariable Long id){
        return ResponseEntity.ok(ts.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Tulov> create(@RequestBody Tulov mj){
        return ResponseEntity.ok( ts.create(mj));
    }

    @PutMapping()
    public ResponseEntity<Tulov> update(@RequestBody Tulov mj){
        return ResponseEntity.ok(ts.update(mj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ts.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}