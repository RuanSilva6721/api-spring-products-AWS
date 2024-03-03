package com.ruanfelipe.apiprodcuts.services;

import com.ruanfelipe.apiprodcuts.domain.category.Category;
import com.ruanfelipe.apiprodcuts.domain.category.execptions.CategoryNotFoundException;
import com.ruanfelipe.apiprodcuts.domain.product.Product;
import com.ruanfelipe.apiprodcuts.domain.product.ProductDTO;
import com.ruanfelipe.apiprodcuts.domain.product.execptions.ProductNotFoundException;
import com.ruanfelipe.apiprodcuts.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryService categoryService;
    private final ProductRepository repository;

    public Product insert(ProductDTO productData) {
        Category category = this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        Product newProduct = new Product(productData, category);
        return repository.save(newProduct);
    }

    public Product update(String id, ProductDTO productData) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        Category category = this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        product.setTitle(productData.title());
        product.setDescription(productData.description());
        product.setPrice(productData.price());
        product.setCategory(category);

        return repository.save(product);
    }

    public void delete(String id) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        repository.delete(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }
}