package net.idrok.shopping.dto;

import java.time.LocalDateTime;

import javax.persistence.Id;


import net.idrok.shopping.entity.Fayl;
import net.idrok.shopping.entity.Role;
import net.idrok.shopping.entity.User;

public class UserDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private Role role;
    private LocalDateTime regTime;
    private Fayl rasm;



    public UserDTO(){

    }

    public UserDTO(User user){

        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.login = user.getLogin();
        this.regTime = user.getRegTime();
        this.role = user.getRole();
        this.rasm = user.getRasm();

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public Fayl getRasm() {
        return rasm;
    }

    public void setRasm(Fayl rasm) {
        this.rasm = rasm;
    }


  

    
}
