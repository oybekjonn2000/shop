package net.idrok.shopping.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.idrok.shopping.entity.Tulov;
import net.idrok.shopping.entity.TulovTur;

@Repository
public interface TulovRepository extends JpaRepository<Tulov, Long> {
    Page<Tulov> findByNomOrStatusContainingIgnoreCase(String k1, String k2,  Pageable pageable);

    List<Tulov> findByTulovTur(TulovTur tulovTur);

    // default List<Tulov> findByTulovTurUZCARD(){
    //    return this.findByTulovTur(TulovTur.UZCARD);
    // }


    // @Query("FROM Tulov m WHERE m.tulovTur = net.idrok.shopping.entity.TulovTur.NAQD")
    // List<Tulov> findbyTulovTurNAQD();

}