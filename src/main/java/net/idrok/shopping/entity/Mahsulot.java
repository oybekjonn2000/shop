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
    private String rang;
    private Double narx;
    private String miqdor;

    @ManyToOne
    private Chegirma chegirma;

    @ManyToOne
    private Brend brend;

    @ManyToOne
    private Type type;

    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public Double getNarx() {
        return narx;
    }

    public void setNarx(Double narx) {
        this.narx = narx;
    }

    public String getMiqdor() {
        return miqdor;
    }

    public void setMiqdor(String miqdor) {
        this.miqdor = miqdor;
    }

    public Chegirma getChegirma() {
        return chegirma;
    }

    public void setChegirma(Chegirma chegirma) {
        this.chegirma = chegirma;
    }

    public Brend getBrend() {
        return brend;
    }

    public void setBrend(Brend brend) {
        this.brend = brend;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    

  
}
