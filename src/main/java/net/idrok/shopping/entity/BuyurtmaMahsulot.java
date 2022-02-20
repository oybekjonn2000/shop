package net.idrok.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BuyurtmaMahsulot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Buyurtma buyurtma;

    @OneToOne
    private Mahsulot mahsulot;



    private String info;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyurtma getBuyurtma() {
        return buyurtma;
    }

    public void setBuyurtma(Buyurtma buyurtma) {
        this.buyurtma = buyurtma;
    }

    public Mahsulot getMahsulot() {
        return mahsulot;
    }

    public void setMahsulot(Mahsulot mahsulot) {
        this.mahsulot = mahsulot;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    

}
