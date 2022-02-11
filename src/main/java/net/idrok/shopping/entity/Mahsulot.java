package net.idrok.shopping.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Mahsulot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String kategoriya;
    private String narx;

    @ManyToOne
    private Chegirma chegirma;

    private String info;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKategoriya() {
        return kategoriya;
    }

    public void setKategoriya(String kategoriya) {
        this.kategoriya = kategoriya;
    }

    public String getNarx() {
        return narx;
    }

    public void setNarx(String narx) {
        this.narx = narx;
    }

    public Chegirma getChegirma() {
        return chegirma;
    }

    public void setChegirma(Chegirma chegirma) {
        this.chegirma = chegirma;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
