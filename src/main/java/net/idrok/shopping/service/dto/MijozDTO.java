package net.idrok.shopping.service.dto;

import net.idrok.shopping.entity.Mijoz;

public class MijozDTO {

    private  Long id;

    private String ism;
    private String familiya;
    private String telefon;


    private String address;
   


    

    public MijozDTO() {


    }
    public MijozDTO(Mijoz mijoz) {
       this.ism = mijoz.getIsm();
       this.familiya = mijoz.getFamiliya();
       this.telefon = mijoz.getPhone();
       this.address = mijoz.getAddress();



    }
    


    


    public MijozDTO(Long id, String ism, String familiya, String telefon, String address) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.telefon = telefon;
        this.address = address;
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
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    
    

 

}
