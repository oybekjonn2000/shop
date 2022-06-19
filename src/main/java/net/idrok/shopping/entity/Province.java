package net.idrok.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="province")
@Getter
@Setter
public class Province {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="code")
    private String code;


    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="province")
    @JsonIgnore
    private List<City> cities;


}