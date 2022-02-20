package net.idrok.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shopping.entity.Mijoz;
import net.idrok.shopping.repository.MijozRepository;
import net.idrok.shopping.service.dto.MijozDTO;

@Service
public class MijozService {

    @Autowired
    MijozRepository userRepo;

    public Page<MijozDTO> getAll(String key, Pageable pageable) {
        // return userRepo.findAllByIsmOrFamiliyaContainingIgnoreCase(key, key,
        // pageable).map(mijoz -> new MijozDTO(mijoz));
        return userRepo.findAllByIsmOrFamiliyaContainingIgnoreCase(key, key, pageable).map(MijozDTO::new);
    };

    public MijozDTO getById(Long id) {
        return userRepo.findById(id).map(MijozDTO::new).get();
    }

    public MijozDTO create(Mijoz mj) {
        if (mj.getId() == null)
            return new MijozDTO(userRepo.save(mj));
        throw new RuntimeException("id null bolishi kerak");
    }

    public MijozDTO update(Mijoz mj) {
        if (mj.getId() != null)
            return new MijozDTO( userRepo.save(mj));
        throw new RuntimeException("id null bolmasligi kerak");
    }

    public void delete(Mijoz mj) {
        userRepo.delete(mj);
    }

    public void deleteById(Long mjId) {
        userRepo.deleteById(mjId);
    }

}