package com.ruanfelipe.apiprodcuts.repositories;

import com.ruanfelipe.apiprodcuts.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
