package net.idrok.shopping.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mijoz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String ism;
    private String familiya;
    private String telefon;


    private String address;
    @OneToOne(targetEntity = User.class)
    private User user;


    public Mijoz(Long id, String firstName, String lastName, String phone, String address, User user) {
        this.id = id;
        this.ism = firstName;
        this.familiya = lastName;
        this.telefon = phone;
        this.address = address;
        this.user = user;
    }
    


    public Mijoz() {
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getIsm() {
        return ism;
    }


    public void setIsm(String ism) {
        this.ism = ism;
    }


    public String getFamiliya() {
        return familiya;
    }


    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }


    public String getPhone() {
        return telefon;
    }


    public void setPhone(String phone) {
        this.telefon = phone;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    
    

    





    
}