package net.idrok.shopping.service.dto;

import net.idrok.shopping.entity.Customer;

public class CustomerDTO {

    private  Long id;

    private String firstName;
    private String lastName;
    private String phone;


    private String address;
   


    

    public CustomerDTO() {


    }
    public CustomerDTO(Customer customer) {
       this.firstName = customer.getFirstName();
       this.lastName = customer.getLastName();
       this.phone = customer.getPhone();
       this.address = customer.getAddress();



    }
    public CustomerDTO(Long id, String firstName, String lastName, String phone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    

    

    

    

 

}
