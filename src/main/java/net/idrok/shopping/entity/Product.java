package net.idrok.shopping.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import net.idrok.shopping.entity.Fayl;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private  ProductCategory category;
    private String sku;
    private String name;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Discount discount;
    private String description;
    private Long unitPrice;

    @ManyToOne
    private Fayl productImage;

    private boolean active;

    private int unitsInStock;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
