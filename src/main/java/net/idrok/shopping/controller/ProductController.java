package net.idrok.shopping.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.idrok.shopping.entity.Product;
import net.idrok.shopping.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(maxAge = 3600)

public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<Page<Product>> getAll(@RequestParam(name = "key", required = false) String key,
            Pageable pageable) {
        if (key == null)
            key = "";
        Page<Product> p1 = productService.getAll(pageable, key);
        p1.getContent().forEach(p -> p.setImg(null));
        return ResponseEntity.ok(p1);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    /**
     * rasmlar yuklash uchun
     * 
     * @param id
     * @return byteArryResource img
     * @throws IOException
     */
    @GetMapping("/{id}/download")
    public ResponseEntity<ByteArrayResource> getImgProduct(@PathVariable Long id) throws IOException {
        Product p = productService.getById(id);
        byte[] img = p.getImg();
        if (img == null) {
            return ResponseEntity.notFound().build();
        }
        InputStream is = new ByteArrayInputStream(img);
        String mimeType = URLConnection.guessContentTypeFromStream(is);

        if (mimeType == null) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE.toString();
        }

        return ResponseEntity.ok()
                .cacheControl(CacheControl.noCache())
                .contentType(MediaType.valueOf(mimeType))
                .body(new ByteArrayResource(img));

    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<?> uploadFileProduct(@PathVariable Long id, @RequestParam("file") MultipartFile file) {

        Product p = productService.getById(id);

        try {
            p.setImg(file.getBytes());
            productService.update(p);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product bm) {
        return ResponseEntity.ok(productService.create(bm));
    }

    @PutMapping()
    public ResponseEntity<Product> update(@RequestBody Product bm) {
        return ResponseEntity.ok(productService.update(bm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
