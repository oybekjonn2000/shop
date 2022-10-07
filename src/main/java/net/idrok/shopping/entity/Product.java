package net.idrok.shopping.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private  ProductCategory category;

    private String name;
//    @ManyToOne
//    private Brand brand;
//    @ManyToOne
//    private Discount discount;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_images",
            joinColumns = {
                @JoinColumn(name = "product_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "image_id")
    }
    )
    private Set<ImageModel> productImages;
    private String description;
    private Double unitPrice;
    private boolean active;
    private int unitsInStock;
//    @CreationTimestamp
//    private LocalDateTime dateCreated;
//    @UpdateTimestamp
//    private LocalDateTime lastUpdated;


    public Set<ImageModel> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ImageModel> productImages) {
        this.productImages = productImages;
    }

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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

//    public LocalDateTime getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDateTime dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public LocalDateTime getLastUpdated() {
//        return lastUpdated;
//    }
//
//    public void setLastUpdated(LocalDateTime lastUpdated) {
//        this.lastUpdated = lastUpdated;
//    }
}
