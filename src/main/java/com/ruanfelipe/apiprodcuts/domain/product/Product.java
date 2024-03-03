package com.ruanfelipe.apiprodcuts.domain.product;

import com.ruanfelipe.apiprodcuts.domain.category.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="products")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "category_id") // nome da coluna que será criada na tabela Product para armazenar a chave estrangeira
    private Category category;

    public Product(ProductDTO data, Category category) {
        this.title = data.title();
        this.description = data.description();
        this.ownerId = data.ownerId();
        this.price = data.price();
        this.category = category;
    }

}
