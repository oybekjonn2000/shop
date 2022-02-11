package net.idrok.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Buyurtma{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    @ManyToOne
    private Mijoz mijoz;

    private String miqdor;

    @OneToOne
    private Tulov tulov;

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

    public Mijoz getMijoz() {
        return mijoz;
    }

    public void setMijoz(Mijoz mijoz) {
        this.mijoz = mijoz;
    }

    public String getMiqdor() {
        return miqdor;
    }

    public void setMiqdor(String miqdor) {
        this.miqdor = miqdor;
    }

    public Tulov getTulov() {
        return tulov;
    }

    public void setTulov(Tulov tulov) {
        this.tulov = tulov;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    
 



}