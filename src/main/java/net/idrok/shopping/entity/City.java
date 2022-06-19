package net.idrok.shopping.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="city")

@Data
public class City {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="province")
    private Province province;

}
