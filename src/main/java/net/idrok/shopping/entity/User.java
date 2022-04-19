package net.idrok.shopping.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Table (name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(nullable = false, length = 30)
    private String firstName;

    @Size(max = 30)
    @Column(length = 30)
    private String lastName;

    @Size(max = 30)
    @Column(length = 30)
    private String email;

    @NotNull
    @Size(min = 6, max = 30)
    @Column(nullable = false, length = 30, unique = true)
    private String login;

    @NotNull
    @Size(min = 60, max = 60)
    @Column(nullable = false, length = 60)
    private String password;

    private LocalDateTime regTime;
    private LocalDateTime lastVisit;


    private Role role;
    private boolean active;

    @ManyToOne
    private  Fayl image;

    public Fayl getImage() {
        return image;
    }

    public void setImage(Fayl image) {
        this.image = image;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
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
}
