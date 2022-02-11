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
import net.idrok.shopping.entity.Chegirma;
import net.idrok.shopping.service.ChegirmaService;


@RestController
@RequestMapping("/api/chegirma")
@CrossOrigin(maxAge = 3600)
public class ChegirmaController {


    @Autowired
    ChegirmaService chs;

    @GetMapping()
    public ResponseEntity<Page<Chegirma>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(chs.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chegirma> getById(@PathVariable Long id){
        return ResponseEntity.ok(chs.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Chegirma> create(@RequestBody Chegirma ch){
        return ResponseEntity.ok( chs.create(ch));
    }

    @PutMapping()
    public ResponseEntity<Chegirma> update(@RequestBody Chegirma ch){
        return ResponseEntity.ok(chs.update(ch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        chs.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}