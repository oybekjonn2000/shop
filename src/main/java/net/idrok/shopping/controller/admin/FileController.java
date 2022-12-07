package net.idrok.shopping.controller.admin;

import net.idrok.shopping.entity.Fayl;
import net.idrok.shopping.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/api/fayl")
public class FileController {
    private final Logger logger = LoggerFactory.getLogger((FileController.class.getName()));

    private String ROOT_DIRECTORY="files";



    @Value("${system.root-directory}")
    private  void setDirectory (String url){
        this.ROOT_DIRECTORY = url;

    }


    private final  FileService fileService;
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping()
    public ResponseEntity<Page<Fayl>> getAll(@RequestParam(name="key", required = false) String key, Pageable pageable){
        if(key==null) key = "";
        return ResponseEntity.ok(fileService.getAll(pageable, key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fayl> getById(@PathVariable Long id){
        return ResponseEntity.ok(fileService.getById(id));
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable Long id){
      Fayl f =fileService.getById(id);

      File file = new File(ROOT_DIRECTORY+"/"+f.getId()+"_"+f.getName());
      if(file.exists()){
          try {
              InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
              HttpHeaders headers = new HttpHeaders();
              headers.add("Cache-Control", "no-cache , no-store, must-revalidate");
              headers.add("Pragma", "no-cache");
              headers.add("Expires", "0");
              MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
              if(f.getType()!=null){
                  mediaType = MediaType.parseMediaType(f.getType());
              }

              return ResponseEntity.ok()
                      .headers(headers)
                      .contentLength(file.length())
                      .contentType(mediaType)
                      .body(resource);

          } catch (FileNotFoundException e) {
              logger.error(e.getMessage());

          }
      }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<Fayl> upload(@RequestParam("file")MultipartFile fayl) {

        Fayl f = new Fayl();
        f.setName(fayl.getOriginalFilename());
        f.setType(fayl.getContentType());
        f = fileService.create(f);
        try {
        File saveFile = new File(ROOT_DIRECTORY);
        if(!saveFile.exists()) saveFile.mkdirs();
        saveFile = new File(ROOT_DIRECTORY+"/"+f.getId()+"_"+f.getName());

            saveFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(saveFile);
            fos.write(fayl.getBytes());
            fos.close();
             return ResponseEntity.ok(f);


        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        fileService.delete(f);


        return ResponseEntity.badRequest().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        fileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
