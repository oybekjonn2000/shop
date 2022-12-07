package net.idrok.shopping.service.impl;

import net.idrok.shopping.entity.Fayl;

import net.idrok.shopping.repository.FileRepository;
import net.idrok.shopping.service.FileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public  class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public Page<Fayl> getAll(Pageable pageable, String key) {
        return (Page<Fayl>) fileRepository.findAll();
    }

    @Override
    public Fayl getById(Long id) {
        return fileRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public Fayl create(Fayl entity) {
        if(entity.getId()==null)
        return fileRepository.save(entity);
        throw  new RuntimeException("id must be null");
    }

    @Override
    public Fayl update(Fayl entity) {
        if(entity.getId()!=null)
            return fileRepository.save(entity);
        throw  new RuntimeException("id must not be null");
    }

    @Override
    public void delete(Fayl entity) {
        fileRepository.delete(entity);

    }

    @Override
    public void deleteById(Long entityId) {
    fileRepository.deleteById(entityId);
    }
}
