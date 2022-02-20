package net.idrok.shopping.service.dto;

import net.idrok.shopping.entity.Mijoz;

public class MijozDTO {

    private Long id;
    private String ism;
    private String familiya;
    private String sharif;
    private String username;
    private String address;
    private String email;


    

    public MijozDTO() {


    }
    public MijozDTO(Mijoz mijoz) {
        this.id = mijoz.getId();
        this.ism = mijoz.getIsm();
        this.familiya = mijoz.getFamiliya();
        this.sharif = mijoz.getSharif();
        this.username = mijoz.getUsername();
        this.address = mijoz.getAddress();
        this.email = mijoz.getEmail();


    }

    

    
    public MijozDTO(Long id, String ism, String familiya, String sharif, String username, String address,
            String email) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.sharif = sharif;
        this.username = username;
        this.address = address;
        this.email = email;
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
    public String getSharif() {
        return sharif;
    }
    public void setSharif(String sharif) {
        this.sharif = sharif;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

}
