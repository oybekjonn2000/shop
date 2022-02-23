package net.idrok.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    @ManyToOne(targetEntity = Kategoriya.class)
    private Kategoriya kategoriya;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kategoriya getKategoriya() {
        return kategoriya;
    }

    public void setKategoriya(Kategoriya kategoriya) {
        this.kategoriya = kategoriya;
    }

    


}
