package com.ruanfelipe.apiprodcuts.repositories;

import com.ruanfelipe.apiprodcuts.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
