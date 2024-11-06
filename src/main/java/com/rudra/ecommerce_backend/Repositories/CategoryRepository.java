package com.rudra.ecommerce_backend.Repositories;

import com.rudra.ecommerce_backend.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

//    List<Category> findByIdGreaterThanAndNameGreaterThan(
//            Long id, String name);

    Category save(Category category);
}
