package net.idrok.shopping.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.idrok.shopping.entity.Mahsulot;
import net.idrok.shopping.entity.MahsulotKategoriya;


@Repository
public interface MahsulotRepository extends JpaRepository<Mahsulot, Long> {
    Page<Mahsulot> findByNomOrInfoContainingIgnoreCase(String k1, String k2,  Pageable pageable);

    List<Mahsulot> findByMahsulotKategoriya(MahsulotKategoriya mahsulotKategoriya);

    default List<Mahsulot> findByMahsulotKategoriyaKOMPYUTER(){
       return this.findByMahsulotKategoriya(MahsulotKategoriya.KOMPYUTER);
    }


    @Query("FROM Mahsulot m WHERE m.mahsulotKategoriya = net.idrok.shopping.entity.MahsulotKategoriya.ASCESSUAR")
    List<Mahsulot> findbyMahsulotKategoriyaASCESSUAR();

}
